package com.xuankun.workorder.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xuankun.common.service.impl.CrudServiceImpl;
import com.xuankun.common.utils.Result;
import com.xuankun.workorder.enums.NodeSetTypeEnum;
import com.xuankun.workorder.enums.NodeUserTypeEnum;
import com.xuankun.workorder.service.*;
import com.xuankun.workorder.dto.*;
import com.xuankun.workorder.core.exception.XuanKunException;
import com.xuankun.workorder.dao.WfProcessDao;
import com.xuankun.workorder.entity.*;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-11
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class WfProcessServiceImpl extends CrudServiceImpl<WfProcessDao, WfProcessEntity, WfProcessDTO> implements WfProcessService {

    @Resource
    private WfFormService formService;
    @Resource
    private WfNodeUserService nodeUserService;
    @Resource
    private WfProcessNodeService nodeService;
    @Resource
    private WfNodeConditionService conditionService;
    @Resource
    private WfFormFieldService fieldService;
    @Resource
    private WfFormUserService formUserService;
    @Resource
    private WfDeptUserService deptUserService;
    @Resource
    private WfUserSuperiorService userSuperiorService;
    @Resource
    private WorkOrderService orderService;

    @Override
    public QueryWrapper<WfProcessEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");
        QueryWrapper<WfProcessEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);
        return wrapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveProcessFormInfo(ProcessFormInfoSaveDTO processFormInfoSaveDTO) {
        /* 表单信息 */
        WfFormDTO formDTO = new WfFormDTO();
        formDTO.setFormName(processFormInfoSaveDTO.getFormSetting().getName());
        formDTO.setGroupId(processFormInfoSaveDTO.getFormSetting().getGroupId());
        formDTO.setRemark(processFormInfoSaveDTO.getFormSetting().getRemark());
        formDTO.setInCommonUse(processFormInfoSaveDTO.getFormSetting().getInCommonUse());
        formDTO.setContent(processFormInfoSaveDTO.getFormContent());
        /* 流程信息 */
        WfProcessDTO processDTO = new WfProcessDTO();
        processDTO.setDirectorMaxLevel(processFormInfoSaveDTO.getProcessDTO().getDirectorMaxLevel());
        processDTO.setProcessNode(JSON.toJSONString(processFormInfoSaveDTO.getProcessDTO().getNodeConfig()));
        this.save(processDTO);
        formDTO.setProcessId(processDTO.getId());
        formService.save(formDTO);
        processDTO.setFormId(formDTO.getFormId());
        this.update(processDTO);
        /* 表单用户权限信息保存 */
        List<NodeUserDTO> userList = processFormInfoSaveDTO.getFormSetting().getNodeUserList();
        List<WfFormUserEntity> formUserList = new ArrayList<>();
        for(NodeUserDTO nodeUserDTO:userList){
            WfFormUserEntity formUserDTO = new WfFormUserEntity();
            formUserDTO.setFormId(formDTO.getFormId());
            formUserDTO.setUserName(nodeUserDTO.getName());
            formUserDTO.setUserId(nodeUserDTO.getId());
            formUserDTO.setType(nodeUserDTO.getType());
            formUserList.add(formUserDTO);
        }
        formUserService.insertBatch(formUserList,1000);
        /* 流程节点信息 */
        ProcessSettingInfoDTO processSetting = null;
        if(processFormInfoSaveDTO.getProcessDTO().getNodeConfig() != null){
            processSetting = processFormInfoSaveDTO.getProcessDTO().getNodeConfig();
        }
        if(processSetting == null){
            throw new XuanKunException(10051,"流程信息为空!");
        }
        /* 保存节点信息 */
        WfProcessNodeDTO nodeDTO = saveWfProcessNodeDTO(formDTO, processDTO, processSetting);
        /* 保存节点角色信息 */
        saveNodeUser(processDTO.getId(),formDTO.getFormId(),nodeDTO,processSetting);
        /* 保存条件节点条件信息 */
        saveNodeCondition(processSetting,formDTO.getFormId(),nodeDTO);
        /* 保存节点字段信息 */
        saveNodeFormField(processDTO.getId(),formDTO.getFormId(),nodeDTO,processSetting);
        Integer parentId = nodeDTO.getId();
        Long processId = processDTO.getId();
        if (processSetting.getChildNode() != null
                || processSetting.getConditionNodes() != null) {
            List<ProcessSettingInfoDTO> infoDTO = new ArrayList<>();
            if(processSetting.getChildNode() == null || processSetting.getChildNode().isEmpty()){
                infoDTO = processSetting.getConditionNodes();
                for (ProcessSettingInfoDTO dto:infoDTO) {
                    saveNodeTree(dto,parentId,processId,formDTO.getFormId(),true);
                }
            }else{
                infoDTO = processSetting.getChildNode();
                for (ProcessSettingInfoDTO dto:infoDTO) {
                    saveNodeTree(dto,parentId,processId,formDTO.getFormId(),false);
                }
            }
        }
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<String> updateProcessFormInfo(ProcessFormInfoSaveDTO processFormInfoSaveDTO) throws Exception {
        /* 表单信息 */
        WfFormDTO formDTO = new WfFormDTO();
        formDTO = formService.get(processFormInfoSaveDTO.getFormSetting().getId());
        if(orderService.countWorkOrder(formDTO.getFormId()) > 0){
            return new Result<String>().error("此流程存在未完成的流程，不能修改此流程");
        }
        formDTO.setFormName(processFormInfoSaveDTO.getFormSetting().getName());
        formDTO.setGroupId(processFormInfoSaveDTO.getFormSetting().getGroupId());
        formDTO.setRemark(processFormInfoSaveDTO.getFormSetting().getRemark());
        formDTO.setInCommonUse(processFormInfoSaveDTO.getFormSetting().getInCommonUse());
        formDTO.setContent(processFormInfoSaveDTO.getFormContent());
        formService.update(formDTO);
        /* 表单用户权限信息保存 */
        saveFormUserList(processFormInfoSaveDTO, formDTO);
        /* 流程信息 */
        ProcessSettingInfoDTO processSetting = null;
        if(processFormInfoSaveDTO.getProcessDTO().getNodeConfig() != null){
            processSetting = processFormInfoSaveDTO.getProcessDTO().getNodeConfig();
        }
        if(processSetting == null){
            throw new Exception("流程信息为空!");
        }
        WfProcessDTO processDTO = new WfProcessDTO();
        processDTO = this.get(formDTO.getProcessId());
        processDTO.setFormId(formDTO.getFormId());
        processDTO.setDirectorMaxLevel(processFormInfoSaveDTO.getProcessDTO().getDirectorMaxLevel());
        processDTO.setProcessNode(JSON.toJSONString(processSetting));
        this.update(processDTO);
        /* 流程节点信息 */
        nodeService.deletNodeByProcessIdAndFormId(processDTO.getId(), processDTO.getFormId());
        /* 保存节点信息 */
        WfProcessNodeDTO nodeDTO = saveWfProcessNodeDTO(formDTO,processDTO,processSetting);
        nodeUserService.deletNodeUserByFormId(formDTO.getFormId());
        conditionService.deletNodeConditionByFormId(formDTO.getFormId());
        fieldService.deleteFormFieldByFormId(nodeDTO.getFormId());
        /* 保存节点角色信息 */
        saveNodeUser(processDTO.getId(),formDTO.getFormId(),nodeDTO,processSetting);
        /* 保存条件节点条件信息 */
        saveNodeCondition(processSetting,formDTO.getFormId(),nodeDTO);
        /* 保存节点字段信息 */
        saveNodeFormField(processDTO.getId(),formDTO.getFormId(),nodeDTO,processSetting);
        Integer parentId = nodeDTO.getId();
        Long processId = processDTO.getId();
        if (processSetting.getChildNode() != null
                || processSetting.getConditionNodes() != null) {
            List<ProcessSettingInfoDTO> infoDTO = new ArrayList<>();
            if(processSetting.getChildNode() == null || processSetting.getChildNode().isEmpty()){
                infoDTO = processSetting.getConditionNodes();
                for (ProcessSettingInfoDTO dto:infoDTO) {
                    saveNodeTree(dto,parentId,processId,formDTO.getFormId(),true);
                }
            }else{
                infoDTO = processSetting.getChildNode();
                for (ProcessSettingInfoDTO dto:infoDTO) {
                    saveNodeTree(dto,parentId,processId,formDTO.getFormId(),false);
                }
            }
        }
        return new Result<String>().ok("流程修改成功!");
    }

    private void saveFormUserList(ProcessFormInfoSaveDTO processFormInfoSaveDTO, WfFormDTO formDTO) {
        formUserService.deleteFormUserByFormId(formDTO.getFormId());
        List<NodeUserDTO> userList = processFormInfoSaveDTO.getFormSetting().getNodeUserList();
        List<WfFormUserEntity> formUserList = new ArrayList<>();
        for(NodeUserDTO nodeUserDTO:userList){
            WfFormUserEntity formUserDTO = new WfFormUserEntity();
            formUserDTO.setFormId(formDTO.getFormId());
            formUserDTO.setUserId(nodeUserDTO.getId());
            formUserDTO.setUserName(nodeUserDTO.getName());
            formUserDTO.setType(nodeUserDTO.getType());
            formUserList.add(formUserDTO);
        }
        formUserService.insertBatch(formUserList,1000);
    }

    private int saveNodeTree(ProcessSettingInfoDTO settingInfoDTO,int parentId,Long processId,long formId,boolean isCondition) {
        WfProcessNodeDTO nodeDTO = new WfProcessNodeDTO();
        nodeDTO.setCcSelfSelectFlag(settingInfoDTO.getCcSelfSelectFlag());
        nodeDTO.setDirectorLevel(settingInfoDTO.getDirectorLevel());
        nodeDTO.setError(settingInfoDTO.getError());
        nodeDTO.setType(settingInfoDTO.getType());
        nodeDTO.setNodeCode(settingInfoDTO.getNodeCode());
        nodeDTO.setNodeName(settingInfoDTO.getNodeName());
        nodeDTO.setNoHanderAction(settingInfoDTO.getNoHanderAction());
        nodeDTO.setExamineMode(settingInfoDTO.getExamineMode());
        nodeDTO.setExamineEndDirectorLevel(settingInfoDTO.getExamineEndDirectorLevel());
        nodeDTO.setPriorityLevel(settingInfoDTO.getPriorityLevel());
        nodeDTO.setSelectMode(settingInfoDTO.getSelectMode());
        nodeDTO.setSelectRange(settingInfoDTO.getSelectRange());
        nodeDTO.setSetType(settingInfoDTO.getSetType());
        nodeDTO.setParentId(parentId);
        nodeDTO.setProcessId(processId);
        nodeDTO.setFormId(formId);
        nodeDTO.setRemarkIsRequired(settingInfoDTO.getRemarkIsRequired());
        if(isCondition){
            nodeDTO.setIsConditionNode(1);
        }
        nodeService.save(nodeDTO);
        /* 保存节点角色信息 */
        saveNodeUser(processId,formId,nodeDTO,settingInfoDTO);
        /* 保存条件节点条件信息 */
        saveNodeCondition(settingInfoDTO,formId,nodeDTO);
        /* 保存节点字段信息 */
        saveNodeFormField(processId,formId,nodeDTO,settingInfoDTO);
        List<ProcessSettingInfoDTO> infoDTO = new ArrayList<>();
        if (settingInfoDTO.getChildNode() != null && !settingInfoDTO.getChildNode().isEmpty()) {
            infoDTO = settingInfoDTO.getChildNode();
            for (ProcessSettingInfoDTO dto:infoDTO) {
                saveNodeTree(dto,nodeDTO.getId(),processId,formId,false);
            }
        }else{
            if (settingInfoDTO.getConditionNodes() != null && !settingInfoDTO.getConditionNodes().isEmpty()) {
                infoDTO = settingInfoDTO.getConditionNodes();
            }
            for (ProcessSettingInfoDTO dto:infoDTO) {
                saveNodeTree(dto,nodeDTO.getId(),processId,formId,true);
            }
        }
        return nodeDTO.getId();
    }

    @NotNull
    private WfProcessNodeDTO saveWfProcessNodeDTO(WfFormDTO formDTO, WfProcessDTO processDTO, ProcessSettingInfoDTO processSetting) {
        WfProcessNodeDTO nodeDTO = new WfProcessNodeDTO();
        nodeDTO.setCcSelfSelectFlag(processSetting.getCcSelfSelectFlag());
        nodeDTO.setDirectorLevel(processSetting.getDirectorLevel());
        nodeDTO.setError(processSetting.getError());
        nodeDTO.setType(processSetting.getType());
        nodeDTO.setNodeCode(processSetting.getNodeCode());
        nodeDTO.setNodeName(processSetting.getNodeName());
        nodeDTO.setNoHanderAction(processSetting.getNoHanderAction());
        nodeDTO.setExamineMode(processSetting.getExamineMode());
        nodeDTO.setExamineEndDirectorLevel(processSetting.getExamineEndDirectorLevel());
        nodeDTO.setPriorityLevel(processSetting.getPriorityLevel());
        nodeDTO.setSelectMode(processSetting.getSelectMode());
        nodeDTO.setSelectRange(processSetting.getSelectRange());
        nodeDTO.setSetType(processSetting.getSetType());
        nodeDTO.setParentId(0);
        nodeDTO.setFormId(formDTO.getFormId());
        nodeDTO.setRemarkIsRequired(processSetting.getRemarkIsRequired());
        nodeDTO.setProcessId(processDTO.getId());
        if(processSetting.getNodeName().contains("条件") && !processSetting.getNodeName().contains("分支")){
            nodeDTO.setIsConditionNode(1);
        }
        nodeService.save(nodeDTO);
        return nodeDTO;
    }

    private void saveNodeUser(Long processId, long formId, WfProcessNodeDTO nodeDTO, ProcessSettingInfoDTO dto) {
        List<WfNodeUserEntity> userList;
        userList = new ArrayList<>();
        if(dto.getNodeUserList() != null && !dto.getNodeUserList().isEmpty()){
            if(dto.getSetType() == null){
                for(NodeUserDTO nodeUserDTO: dto.getNodeUserList()){
                    saveNodeUserForNode(nodeUserDTO.getId(), nodeUserDTO.getName(), nodeUserDTO.getType(), processId, nodeDTO, formId, userList);
                }
            }else{
                if(!dto.getSetType().equals(NodeSetTypeEnum.DIRECT_SUPERIOR.value()) && !dto.getSetType().equals(NodeSetTypeEnum.MULTI_SUPERIOR.value())
                        && !dto.getSetType().equals(NodeSetTypeEnum.DEPT_SUPERIOR.value()) && !dto.getSetType().equals(NodeSetTypeEnum.MULTI_DEPT_SUPERIOR.value())
                        && !dto.getSetType().equals(NodeSetTypeEnum.REGION_SUPERIOR.value())){
                    for(NodeUserDTO nodeUserDTO: dto.getNodeUserList()){
                        saveNodeUserForNode(nodeUserDTO.getId(), nodeUserDTO.getName(), nodeUserDTO.getType(), processId, nodeDTO, formId, userList);
                    }
                }
            }

        }
        nodeUserService.insertBatch(userList);
    }

    private static void saveNodeUserForNode(int userId, String userName, int type, Long processId, WfProcessNodeDTO nodeDTO, long formId, List<WfNodeUserEntity> userList) {
        WfNodeUserEntity userDTO = new WfNodeUserEntity();
        userDTO.setRoleId(userId);
        userDTO.setRoleName(userName);
        userDTO.setType(type);
        userDTO.setProcessId(processId);
        userDTO.setNodeId(nodeDTO.getId());
        userDTO.setParentNodeId(nodeDTO.getParentId());
        userDTO.setFormId(formId);
        userList.add(userDTO);
    }

    private void saveNodeFormField(Long processId, long formId, WfProcessNodeDTO nodeDTO, ProcessSettingInfoDTO dto) {
        List<WfFormFieldEntity> fieldList;
        fieldList = new ArrayList<>();
        if(dto.getFormAuthList() != null && !dto.getFormAuthList().isEmpty()){
            for(WfFormFieldDTO fieldDTO: dto.getFormAuthList()){
                WfFormFieldEntity fieldEntity = new WfFormFieldEntity();
                fieldEntity.setField(fieldDTO.getField());
                fieldEntity.setFieldName(fieldDTO.getFieldName());
                fieldEntity.setRequired(fieldDTO.isRequired());
                fieldEntity.setOperation(fieldDTO.getOperation());
                fieldEntity.setProcessId(processId);
                fieldEntity.setNodeId(nodeDTO.getId());
                fieldEntity.setFormId(formId);
                fieldList.add(fieldEntity);
            }
        }
        fieldService.insertBatch(fieldList);
    }

    private void saveNodeCondition(ProcessSettingInfoDTO settingInfoDTO, long formId, WfProcessNodeDTO nodeDTO) {
        List<WfNodeConditionEntity> conditionList = new ArrayList<>();
        if(settingInfoDTO.getConditionList() != null && !settingInfoDTO.getConditionList().isEmpty()){
            for(WfNodeConditionDTO conditionDTO: settingInfoDTO.getConditionList()){
                WfNodeConditionEntity conditionEntity = new WfNodeConditionEntity();
                conditionEntity.setColumnDbname(conditionDTO.getColumnDbname());
                conditionEntity.setColumnType(conditionDTO.getColumnType());
                conditionEntity.setColumnId(conditionDTO.getColumnId());
                conditionEntity.setType(conditionDTO.getType());
                conditionEntity.setFixedDownBoxValue(conditionDTO.getFixedDownBoxValue());
                conditionEntity.setNodeId(nodeDTO.getId());
                conditionEntity.setFormId(formId);
                conditionEntity.setShowName(conditionDTO.getShowName());
                conditionEntity.setShowType(conditionDTO.getShowType());
                conditionEntity.setZdy1(conditionDTO.getZdy1());
                conditionEntity.setZdy2(conditionDTO.getZdy2());
                conditionEntity.setOpt1(conditionDTO.getOpt1());
                conditionEntity.setOpt2(conditionDTO.getOpt2());
                conditionEntity.setOptType(conditionDTO.getOptType());
                conditionList.add(conditionEntity);
            }
        }
        conditionService.insertBatch(conditionList);
    }
}