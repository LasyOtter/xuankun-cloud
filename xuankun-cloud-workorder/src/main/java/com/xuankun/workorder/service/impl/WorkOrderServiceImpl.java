package com.xuankun.workorder.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.xuankun.common.page.PageData;
import com.xuankun.common.service.impl.CrudServiceImpl;
import com.xuankun.common.utils.ConvertUtils;
import com.xuankun.common.utils.Result;
import com.xuankun.workorder.enums.*;
import com.xuankun.workorder.service.*;
import com.xuankun.workorder.dto.*;
import com.xuankun.workorder.dao.WorkOrderDao;
import com.xuankun.workorder.entity.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-09-15
 */
@Service
//@Transactional(rollbackFor = Exception.class)
public class WorkOrderServiceImpl extends CrudServiceImpl<WorkOrderDao, WorkOrderEntity, WorkOrderDTO> implements WorkOrderService {

    @Resource
    private WfNodeUserService nodeUserService;
    @Resource
    private WfProcessNodeService nodeService;
    @Resource
    private WfProcessUserApprovalService approvalService;
    @Resource
    private WfDeployFormService deployFormService;
    @Resource
    private WoIncrementService woIncrementService;
    @Resource
    private JPAQueryFactory queryFactory;
    @Resource
    private WfDeptUserService deptUserService;
    @Resource
    private WfUserSuperiorService userSuperiorService;

    @Override
    public QueryWrapper<WorkOrderEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");
        String woState = (String)params.get("woState");
        String woCode = (String)params.get("woCode");
        String schemeName = (String)params.get("schemeName");
        String beginDate = (String)params.get("beginDate");
        String endDate = (String)params.get("endDate");
        String executorRole = (String)params.get("executorRole");
        String operationType = (String)params.get("operationType");
        String projectId = (String)params.get("projectId");
        String projectName = (String)params.get("projectName");
        QueryWrapper<WorkOrderEntity> wrapper = new QueryWrapper<>();
        wrapper.exists(StringUtils.isNotBlank(operationType),"select 1 from t_operation_scheme a where a.id=t_work_order.scheme_id and a.operation_type={0}",operationType);
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);
        wrapper.eq(StringUtils.isNotBlank(woState), "wo_state", woState);
        wrapper.eq(StringUtils.isNotBlank(woCode), "wo_code", woCode);
        wrapper.eq(StringUtils.isNotBlank(schemeName), "scheme_name", schemeName);
        wrapper.eq(StringUtils.isNotBlank(executorRole), "executor_role", executorRole);
        wrapper.ge(StringUtils.isNotBlank(beginDate), "planned_execution_time", beginDate);
        wrapper.le(StringUtils.isNotBlank(endDate), "planned_execution_time", endDate);
        wrapper.eq(StringUtils.isNotBlank(projectId), "project_id", projectId);
        wrapper.eq(StringUtils.isNotBlank(projectName), "project_name", projectName);
        wrapper.orderByDesc("id");
        return wrapper;
    }

    /**
     * 工单审批
     * @param approvedDTO
     * @return
     */
    @Override
    public int approvedWoState(WorkOrderApprovedDTO approvedDTO) {
        return this.baseDao.approvedWoState(approvedDTO);
    }

    @Override
    public ProjectInfoDTO getProjectInfo(int projectId) {
        return this.baseDao.getProjectInfo(projectId);
    }

    @Override
    public int getWorkOrderInfo(int schemeId) {
        return this.baseDao.getWorkOrderInfo(schemeId);
    }

    @Override
    public PageData<WorkOrderDTO> selectSelfWorkOrder(Map<String, Object> params) {
        IPage<WorkOrderEntity> page = Page.of(Long.parseLong(params.get("page").toString()) ,Long.parseLong(params.get("limit").toString()));
        QueryWrapper<WorkOrderEntity> queryWrapper = this.getDtoWrapper(params);
        return this.getPageData(this.baseDao.selectSelfWorkOrder(page, queryWrapper), WorkOrderDTO.class);
    }

    @Override
    public OperationSchemeDTO findSchemeByWoId(int id) {
        QOperationSchemeEntity schemeEntity = QOperationSchemeEntity.operationSchemeEntity;
        QWorkOrderEntity workOrderEntity = QWorkOrderEntity.workOrderEntity;
        BooleanBuilder queryBuilder = new BooleanBuilder();
        queryBuilder.and(workOrderEntity.id.eq(id));
        return queryFactory.select(Projections.bean(OperationSchemeDTO.class, schemeEntity))
                .from(schemeEntity)
                .innerJoin(workOrderEntity)
                .on(schemeEntity.id.eq(workOrderEntity.schemeId))
                .where(queryBuilder).fetchOne();
    }

    @Override
    public List<String> getUserRoleInfo(int userId) {
        return this.baseDao.getUserRoleInfo(userId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveAndSublitOrder(WorkOrderDTO dto) throws Exception {
        dto.setWoCode(woIncrementService.getIncrementByWoDate());
        this.save(dto);
        //提交工单
        int orderId = dto.getId();
        int applicantId = dto.getApplicantId();
        long formId = dto.getFormId();
        SubmitOrderDTO submitOrderDTO = new SubmitOrderDTO();
        submitOrderDTO.setOrderId(orderId);
        submitOrderDTO.setFormId(formId);
        submitOrderDTO.setUserId(applicantId);
        submitOrderDTO.setRoleId(dto.getApplicantRoleId());
        submitOrderDTO.setRoleName(dto.getApplicantRoleName());
        this.submitOrder(submitOrderDTO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveAndSublitOrder(SaveWorkOrderAndFormInfoDTO infoDTO) throws Exception {
        WorkOrderDTO dto = infoDTO.getWorkOrderDTO();
        dto.setWoCode(woIncrementService.getIncrementByWoDate());
        this.save(dto);
        //保存表单信息
        WfDeployFormEntity deployFormDTO = new WfDeployFormEntity();
        deployFormDTO.setFormId(dto.getFormId());
        deployFormDTO.setWorkOrderId(dto.getId());
        deployFormDTO.setWorkOrderCode(dto.getWoCode());
        deployFormDTO.setContent(infoDTO.getFormContent());
        deployFormDTO.setInCommonUse(infoDTO.isInCommonUse());
        this.deployFormService.insert(deployFormDTO);
        //提交工单
        int orderId = dto.getId();
        int applicantId = dto.getApplicantId();
        String applicant = dto.getApplicant();
        long formId = dto.getFormId();
        SubmitOrderDTO submitOrderDTO = new SubmitOrderDTO();
        submitOrderDTO.setOrderId(orderId);
        submitOrderDTO.setFormId(formId);
        submitOrderDTO.setUserId(applicantId);
        submitOrderDTO.setUserName(applicant);
        submitOrderDTO.setRoleId(dto.getApplicantRoleId());
        submitOrderDTO.setRoleName(dto.getApplicantRoleName());
        this.submitOrder(submitOrderDTO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<String> submitOrder(SubmitOrderDTO submitOrderDTO) throws Exception {
        List<WfProcessUserApprovalEntity> approvalList = new ArrayList<>();
        /* 开始节点权限是否是所有人 */
        WfNodeUserEntity startNodeUser = nodeService.queryAllStartProcessNodeIdByFormId(submitOrderDTO.getFormId());
        /* 所有人 */
        if(startNodeUser != null){
            doSubmitNode(submitOrderDTO, approvalList, startNodeUser);
            return new Result<String>().ok(submitOrderDTO.getOrderId() + "提交成功");
        }
        /* 特定人 指定用户  */
        startNodeUser = nodeService.queryStartProcessNodeIdByFormId(submitOrderDTO.getFormId());
        if(startNodeUser == null || startNodeUser.getNodeId() == null || startNodeUser.getNodeId() == 0){
            return new Result<String>().error(submitOrderDTO.getOrderId() + "提交失败,没有找到开始节点");
        }
        doSubmitNode(submitOrderDTO, approvalList, startNodeUser);
        return new Result<String>().ok(submitOrderDTO.getOrderId() + "提交成功");
    }

    private void doSubmitNode(SubmitOrderDTO submitOrderDTO, List<WfProcessUserApprovalEntity> approvalList, WfNodeUserEntity startNodeUser) throws Exception {
        int startNodeId = startNodeUser.getNodeId();
        int count = nodeService.countNodeByFormIdAndParentId(submitOrderDTO.getFormId(), startNodeId,1);
        /* 判断下一节点是否为条件节点，为条件节点 */
        if(count > 0){
            WfNodeUserEntity nodeUserEntity = nodeService.queryApplyNodeUserByFormIdAndRoleAndParentId(submitOrderDTO.getFormId(), 2, submitOrderDTO.getRoleId(), startNodeId,1);
            //角色节点
            if(nodeUserEntity == null){
                //非角色节点
                nodeUserEntity = nodeService.queryApplyNodeUserByFormIdAndRoleAndParentId(submitOrderDTO.getFormId(), 1, submitOrderDTO.getUserId(), startNodeId,1);
                if(nodeUserEntity == null){
                    nodeUserEntity = nodeUserService.queryStartNodeUserByParentNodeId(startNodeId,3,0);
                    if (nodeUserEntity == null) {
                        /* 该工单的流程表单未设置好 */
                        throw new Exception("该工单的流程表单的申请人未找到或者未设置好");
                    }else{
                        nodeUserEntity.setType(startNodeUser.getType());
                        nodeUserEntity.setRoleId(startNodeUser.getRoleId());
                        nodeUserEntity.setRoleName(startNodeUser.getRoleName());
                    }
                }
            }

            /*  申请节点，申请信息  */
            WfProcessUserApprovalEntity approvalEntity = new WfProcessUserApprovalEntity();
            approvalEntity.setApprovalState(WorkOrderApprovalStateEnum.REQUESTED.value());
            approvalEntity.setApprovalType(0);
            approvalEntity.setIsApproval(1);
            approvalEntity.setOrderId(submitOrderDTO.getOrderId());
            approvalEntity.setUserId(submitOrderDTO.getUserId());
            approvalEntity.setFormId(nodeUserEntity.getFormId());
            approvalEntity.setProcessId(nodeUserEntity.getProcessId());
            approvalEntity.setNodeId(nodeUserEntity.getNodeId());
            approvalEntity.setParentNodeId(nodeUserEntity.getParentNodeId());
            approvalEntity.setNodeUserId(nodeUserEntity.getId());
            approvalEntity.setRoleId(submitOrderDTO.getRoleId());
            approvalEntity.setRoleName(submitOrderDTO.getRoleName());
            approvalEntity.setNodeType(0);
            approvalEntity.setOperatorType(1);
            approvalList.add(approvalEntity);
            /*  上面获取的第一个审批节点，填写预审批信息  */
            //处理流程节点，节点审批人设置为：直接上级、多级上级、部门上级、多级部门上级
            handleProcessNodeSetType(submitOrderDTO.getUserId(),submitOrderDTO.getOrderId(),nodeUserEntity.getNodeId());
            List<WfNodeUserEntity> nodeUserList = nodeUserService.queryApprovalNodeUserByParentNodeId(nodeUserEntity.getNodeId());
            if (nodeUserList == null ||  nodeUserList.isEmpty()) {
                throw new Exception("该工单的流程表单的审批人未找到或者未设置好");
            }
            for (WfNodeUserEntity nodeUser:nodeUserList){
                //判断节点是否是会签
                Long nodeId = Integer.toUnsignedLong(nodeUser.getNodeId());
                WfProcessNodeDTO processNodeDTO = nodeService.get(nodeId);
                //节点为会签
                List<WfNodeUserEntity> approvalNodeUserList = new ArrayList<>();
                if(processNodeDTO.getExamineMode() != null && processNodeDTO.getExamineMode().equals(ExamineModeEnum.AND_AUDIT.value())){
                    if(nodeUser.getType() == 2){
                        //查询角色下面的用户
                        List<UserDTO> userList = nodeUserService.getUserInfoByRoleId(nodeUser.getRoleId());
                        if(userList != null && !userList.isEmpty()) {
                            for (UserDTO user : userList) {
                                WfNodeUserEntity entity = ConvertUtils.sourceToTarget(nodeUser, WfNodeUserEntity.class);
                                entity.setType(1);
                                entity.setRoleId(user.getUserId());
                                entity.setRoleName(user.getUserName());
                                approvalNodeUserList.add(entity);
                            }
                        }
                    }else{
                        approvalNodeUserList.add(nodeUser);
                    }

                }else{
                    approvalNodeUserList.add(nodeUser);
                }
                for(WfNodeUserEntity entity: approvalNodeUserList){
                    WfProcessUserApprovalEntity newEntity = new WfProcessUserApprovalEntity();
                    newEntity.setOrderId(submitOrderDTO.getOrderId());
                    newEntity.setFormId(entity.getFormId());
                    newEntity.setNodeId(entity.getNodeId());
                    newEntity.setParentNodeId(entity.getParentNodeId());
                    newEntity.setProcessId(entity.getProcessId());
                    newEntity.setNodeUserId(entity.getId());
                    newEntity.setIsApproval(0);
                    newEntity.setApprovalState(WorkOrderApprovalStateEnum.TO_BE_APPROVED.value());
                    newEntity.setUserId(null);
                    newEntity.setRoleId(entity.getRoleId());
                    newEntity.setRoleName(entity.getRoleName());
                    //审批
                    newEntity.setNodeType(1);
                    newEntity.setOperatorType(entity.getType());
                    approvalList.add(newEntity);
                }
            }

            approvalService.insertBatch(approvalList);
            WorkOrderEntity orderEntity = this.baseDao.selectById(submitOrderDTO.getOrderId());
            orderEntity.setWoState(WorkOrderStateEnum.REQUESTED.value());
            this.baseDao.updateById(orderEntity);
        }else{
            /* 判断下一节点是否为条件节点，为非条件节点 */
            WfNodeUserEntity nodeUserEntity = nodeService.queryApplyNodeUserByFormIdAndRoleAndNodeId(submitOrderDTO.getFormId(), 2, submitOrderDTO.getRoleId(), startNodeId,0);
            //角色节点
            if(nodeUserEntity == null){
                //非角色节点
                nodeUserEntity = nodeService.queryApplyNodeUserByFormIdAndRoleAndNodeId(submitOrderDTO.getFormId(), 1, submitOrderDTO.getUserId(), startNodeId,0);
                if(nodeUserEntity == null){
                    nodeUserEntity = nodeUserService.queryStartNodeUserByNodeId(startNodeId,0,0);
                    if(nodeUserEntity == null) {
                        /* 该工单的流程表单未设置好 */
                        throw new Exception("该工单的流程表单的申请人未找到或者未设置好");
                    }
                }
            }
            /*  申请节点，申请信息  */
            WfProcessUserApprovalEntity approvalEntity = new WfProcessUserApprovalEntity();
            approvalEntity.setApprovalState(WorkOrderApprovalStateEnum.REQUESTED.value());
            approvalEntity.setApprovalType(0);
            approvalEntity.setIsApproval(1);
            approvalEntity.setOrderId(submitOrderDTO.getOrderId());
            approvalEntity.setUserId(submitOrderDTO.getUserId());
            approvalEntity.setFormId(nodeUserEntity.getFormId());
            approvalEntity.setProcessId(nodeUserEntity.getProcessId());
            approvalEntity.setNodeId(nodeUserEntity.getNodeId());
            approvalEntity.setParentNodeId(nodeUserEntity.getParentNodeId());
            approvalEntity.setNodeUserId(nodeUserEntity.getId());
            approvalEntity.setRoleId(submitOrderDTO.getRoleId());
            approvalEntity.setRoleName(submitOrderDTO.getRoleName());
            approvalEntity.setNodeType(0);
            approvalEntity.setOperatorType(nodeUserEntity.getType());
            approvalList.add(approvalEntity);
            /*  上面获取的第一个审批节点，填写预审批信息  */
            //处理流程节点，节点审批人设置为：直接上级、多级上级、部门上级、多级部门上级
            handleProcessNodeSetType(submitOrderDTO.getUserId(),submitOrderDTO.getOrderId(),nodeUserEntity.getNodeId());
            List<WfNodeUserEntity> nodeUserList = nodeUserService.queryApprovalNodeUserByParentNodeId(startNodeId);
            if (nodeUserList == null || nodeUserList.isEmpty()) {
                throw new Exception("该工单的流程表单的审批人未找到或者未设置好");
            }
            for (WfNodeUserEntity nodeUser:nodeUserList){
                //判断节点是否是会签
                Long nodeId = Integer.toUnsignedLong(nodeUser.getNodeId());
                WfProcessNodeDTO processNodeDTO = nodeService.get(nodeId);
                //节点为会签
                List<WfNodeUserEntity> approvalNodeUserList = new ArrayList<>();
                if(processNodeDTO.getExamineMode() != null && processNodeDTO.getExamineMode().equals(ExamineModeEnum.AND_AUDIT.value())){
                    if(nodeUser.getType() == 2){
                        //查询角色下面的用户
                        List<UserDTO> userList = nodeUserService.getUserInfoByRoleId(nodeUser.getRoleId());
                        if(userList != null && !userList.isEmpty()) {
                            for (UserDTO user : userList) {
                                WfNodeUserEntity entity = ConvertUtils.sourceToTarget(nodeUser, WfNodeUserEntity.class);
                                entity.setType(1);
                                entity.setRoleId(user.getUserId());
                                entity.setRoleName(user.getUserName());
                                approvalNodeUserList.add(entity);
                            }
                        }
                    }else{
                        approvalNodeUserList.add(nodeUser);
                    }

                }else{
                    approvalNodeUserList.add(nodeUser);
                }
                for(WfNodeUserEntity entity: approvalNodeUserList){
                    WfProcessUserApprovalEntity newEntity = new WfProcessUserApprovalEntity();
                    newEntity.setOrderId(submitOrderDTO.getOrderId());
                    newEntity.setFormId(entity.getFormId());
                    newEntity.setNodeId(entity.getNodeId());
                    newEntity.setParentNodeId(entity.getParentNodeId());
                    newEntity.setProcessId(entity.getProcessId());
                    newEntity.setNodeUserId(entity.getId());
                    newEntity.setIsApproval(0);
                    newEntity.setApprovalState(WorkOrderApprovalStateEnum.TO_BE_APPROVED.value());
                    newEntity.setUserId(null);
                    newEntity.setRoleId(entity.getRoleId());
                    newEntity.setRoleName(entity.getRoleName());
                    //审批
                    newEntity.setNodeType(1);
                    newEntity.setOperatorType(entity.getType());
                    approvalList.add(newEntity);
                }
            }

            approvalService.insertBatch(approvalList);
            WorkOrderEntity orderEntity = this.baseDao.selectById(submitOrderDTO.getOrderId());
            orderEntity.setWoState(WorkOrderStateEnum.REQUESTED.value());
            this.baseDao.updateById(orderEntity);
        }
    }

    /**
     * 第一步：根据用户ID找到该用户审批的单据，然后进行审批操作 new:根据userId或者roleId从WfProcessUserApprovalEntity中找到未审批的单据，进行审批
     * 第二步：找到该用户审核节点的下一步 new:判断是否是会签:是--根据工单ID判断会签节点是否全部签完：1-会签完成流转到下一节点，更新工单状态为进行中,没有下一节点更新工单状态为已完成；2-未完成，更新工单状态为会签中
     * 第二步：否节点走或签 或签完成完成流转到下一节点，更新工单状态为进行中,没有下一节点更新工单状态为已完成；2-未完成，更新工单状态为处理中
     * @param approvalOrderDTO 审核工单参数实体类
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<String> approvalOrder(ApprovalOrderDTO approvalOrderDTO) {
        //根据userId或者roleId从WfProcessUserApprovalEntity中找到未审批的单据，进行审批
        WfProcessUserApprovalEntity processUserApproval = approvalService.getApprovalByOrderIdAndRoleId(approvalOrderDTO.getOrderId()
                ,approvalOrderDTO.getRoleId(),approvalOrderDTO.getUserId());
        if (processUserApproval == null) {
            return new Result<String>().error(approvalOrderDTO.getOrderId() + "审批失败，没有找到审批项");
        }
        processUserApproval.setApprovalState(WorkOrderApprovalStateEnum.APPROVED.value());
        processUserApproval.setApprovalType(approvalOrderDTO.getOperatorType());
        processUserApproval.setIsApproval(1);
        processUserApproval.setUserId(approvalOrderDTO.getUserId());
        processUserApproval.setRemark(approvalOrderDTO.getRemark());
        approvalService.updateById(processUserApproval);
        WfProcessNodeDTO processNodeDTO = nodeService.get(Integer.toUnsignedLong(processUserApproval.getNodeId()));
        if(processNodeDTO.getSetType() != null && (processNodeDTO.getSetType().equals(4)
                || processNodeDTO.getSetType().equals(5)
                || processNodeDTO.getSetType().equals(6)
                || processNodeDTO.getSetType().equals(7)
                || processNodeDTO.getSetType().equals(8)) ){
            nodeUserService.deleteById(processUserApproval.getNodeUserId());
        }
        if(null == processNodeDTO.getExamineMode() || ExamineModeEnum.AND_AUDIT.value() != processNodeDTO.getExamineMode()){
            approvalService.deleteApproveByParentNodeIdIdAndNodeId(processUserApproval.getParentNodeId(),processUserApproval.getNodeId(),processUserApproval.getOrderId());
        }
        //判断是否是会签:是--根据工单ID判断会签节点是否全部签完：1-会签完成流转到下一节点，更新工单状态为进行中,没有下一节点更新工单状态为已完成；2-未完成，更新工单状态为会签中
        //判断是否是会签
        if(null == processNodeDTO.getExamineMode() || ExamineModeEnum.AND_AUDIT.value() != processNodeDTO.getExamineMode()){
            //或签 指定下一级审批
            this.submitNextNode(approvalOrderDTO, processUserApproval,processNodeDTO);
            return new Result<String>().ok(approvalOrderDTO.getOrderId() + "审批成功");
        }
        //会签
        int count = approvalService.countProcessNodeByNodeIdAndIsApproval(approvalOrderDTO.getOrderId(),processUserApproval.getNodeId(),0);
        if(count > 0){
            //会签没有签完
            WorkOrderEntity orderEntity = this.baseDao.selectById(approvalOrderDTO.getOrderId());
            orderEntity.setWoState(WorkOrderStateEnum.PROCESSING.value());
            this.updateById(orderEntity);
            return new Result<String>().ok(approvalOrderDTO.getOrderId() + "审批成功");
        }
        //会签签完 指定下一级审批
        this.submitNextNode(approvalOrderDTO, processUserApproval,processNodeDTO);
        return new Result<String>().ok(approvalOrderDTO.getOrderId() + "审批成功");
    }

    @Transactional(rollbackFor = Exception.class)
    public void submitNextNode(ApprovalOrderDTO approvalOrderDTO, WfProcessUserApprovalEntity processUserApproval,WfProcessNodeDTO processNodeDTO) {
        //处理流程节点，节点审批人设置为：直接上级、多级上级、部门上级、多级部门上级
        handleProcessNodeSetType(approvalOrderDTO.getUserId(),approvalOrderDTO.getOrderId(),processNodeDTO.getId());
        List<WfNodeUserEntity> childNodeList = nodeUserService.getNodeUserInfoByParentId(processUserApproval.getNodeId());
        if(childNodeList == null || childNodeList.isEmpty()){
            if(processNodeDTO.getSetType() != null && (processNodeDTO.getSetType().equals(4)
                    || processNodeDTO.getSetType().equals(5)
                    || processNodeDTO.getSetType().equals(6)
                    || processNodeDTO.getSetType().equals(7)
                    || processNodeDTO.getSetType().equals(8)) ){
                nodeUserService.deleteById(processUserApproval.getNodeUserId());
            }
            WorkOrderEntity orderEntity = this.baseDao.selectById(approvalOrderDTO.getOrderId());
            orderEntity.setWoState(WorkOrderStateEnum.COMPLETED.value());
            this.updateById(orderEntity);
            return;
        }
        List<WfProcessUserApprovalEntity> approvalList = new ArrayList<>();
        for(WfNodeUserEntity childNodeUserEntity : childNodeList){
            WfProcessUserApprovalEntity oldChildApproval = approvalService.getApproveByOrderIdAndNodeId(approvalOrderDTO.getOrderId(),childNodeUserEntity.getNodeId());
            if(oldChildApproval != null){
                oldChildApproval.setApprovalState(WorkOrderApprovalStateEnum.TO_BE_APPROVED.value());
                oldChildApproval.setIsApproval(0);
                oldChildApproval.setUserId(approvalOrderDTO.getUserId());
                approvalService.updateById(oldChildApproval);
                if(null == processNodeDTO.getExamineMode() || ExamineModeEnum.AND_AUDIT.value() != processNodeDTO.getExamineMode()){
                    approvalService.deleteApproveByParentNodeIdIdAndNodeId(oldChildApproval.getParentNodeId(),oldChildApproval.getNodeId(),oldChildApproval.getOrderId());
                }
            }else {
                WfProcessUserApprovalEntity childNodeApprovalEntity = new WfProcessUserApprovalEntity();
                childNodeApprovalEntity.setApprovalState(WorkOrderApprovalStateEnum.TO_BE_APPROVED.value());
                childNodeApprovalEntity.setIsApproval(0);
                childNodeApprovalEntity.setOrderId(approvalOrderDTO.getOrderId());
                childNodeApprovalEntity.setFormId(processUserApproval.getFormId());
                childNodeApprovalEntity.setProcessId(childNodeUserEntity.getProcessId());
                childNodeApprovalEntity.setNodeId(childNodeUserEntity.getNodeId());
                childNodeApprovalEntity.setParentNodeId(childNodeUserEntity.getParentNodeId());
                childNodeApprovalEntity.setRoleId(childNodeUserEntity.getRoleId());
                childNodeApprovalEntity.setRoleName(childNodeUserEntity.getRoleName());
                //审批
                childNodeApprovalEntity.setNodeType(NodeTypeEnum.AND_AUDIT.value());
                childNodeApprovalEntity.setOperatorType(childNodeUserEntity.getType());
                approvalList.add(childNodeApprovalEntity);
            }
        }
        approvalService.insertBatch(approvalList);
        WorkOrderEntity orderEntity = this.baseDao.selectById(approvalOrderDTO.getOrderId());
        orderEntity.setWoState(WorkOrderStateEnum.PROCESSING.value());
        this.updateById(orderEntity);
    }

    @Override
    public Result<String> RejectOrder(ApprovalOrderDTO approvalOrderDTO) {
        List<WfNodeUserEntity> nodeUserList = new ArrayList<>();
        nodeUserList = nodeUserService.getNodeUserInfo(approvalOrderDTO.getOrderId(),approvalOrderDTO.getFormId(), approvalOrderDTO.getRoleName());
        if(nodeUserList == null || nodeUserList.isEmpty()){
            return new Result<String>().error("该工单的流程表单未设置好，请联系相关人员");
        }
        List<WfProcessUserApprovalEntity> approvalList = new ArrayList<>();
        for(WfNodeUserEntity nodeUserEntity : nodeUserList){
            WfProcessUserApprovalEntity oldApproval = approvalService.getOldApprove(approvalOrderDTO.getOrderId(),approvalOrderDTO.getRoleName());
            if(oldApproval != null){
                /* 驳回工单， 是否审批变回 0 */
                oldApproval.setApprovalState(WorkOrderApprovalStateEnum.REJECTED.value());
                oldApproval.setApprovalType(approvalOrderDTO.getOperatorType());
                oldApproval.setIsApproval(0);
                oldApproval.setUserId(approvalOrderDTO.getUserId());
                oldApproval.setRemark(approvalOrderDTO.getRemark());
                approvalService.updateById(oldApproval);
                /* 退回工单， 上一级节点 */
                WfProcessUserApprovalEntity parentApproval = new WfProcessUserApprovalEntity();
                parentApproval = approvalService.getNodeApprovalInfoByParentNodedId(oldApproval.getParentNodeId(), oldApproval.getOrderId(),oldApproval.getFormId());
            }
            //指定下一级审批
            if(oldApproval == null){
                continue;
            }
            List<WfNodeUserEntity> childNodeList = nodeUserService.getNodeUserInfoByParentId(oldApproval.getNodeId());
            if(nodeUserList == null || nodeUserList.isEmpty()){
                continue;
            }
            for(WfNodeUserEntity childNodeUserEntity : childNodeList){
                WfProcessUserApprovalEntity oldChildApproval = approvalService.getApproveByOrderIdAndNodeId(approvalOrderDTO.getOrderId(),childNodeUserEntity.getNodeId());
                if(oldChildApproval != null){
                    oldChildApproval.setApprovalState(0);
                    oldChildApproval.setIsApproval(0);
                    oldChildApproval.setUserId(approvalOrderDTO.getUserId());
                    approvalService.updateById(oldChildApproval);
                }else {
                    WfProcessUserApprovalEntity childNodeApprovalEntity = new WfProcessUserApprovalEntity();
                    childNodeApprovalEntity.setApprovalState(0);
                    childNodeApprovalEntity.setIsApproval(0);
                    childNodeApprovalEntity.setOrderId(approvalOrderDTO.getOrderId());
                    childNodeApprovalEntity.setFormId(nodeUserEntity.getFormId());
                    childNodeApprovalEntity.setProcessId(childNodeUserEntity.getProcessId());
                    childNodeApprovalEntity.setNodeId(childNodeUserEntity.getNodeId());
                    childNodeApprovalEntity.setParentNodeId(childNodeUserEntity.getParentNodeId());
                    childNodeApprovalEntity.setRoleId(childNodeApprovalEntity.getRoleId());
                    childNodeApprovalEntity.setRoleName(childNodeUserEntity.getRoleName());
                    approvalList.add(childNodeApprovalEntity);
                }
            }
        }
        if(approvalList == null || approvalList.isEmpty()){
            WorkOrderEntity orderEntity = this.baseDao.selectById(approvalOrderDTO.getOrderId());
            orderEntity.setWoState(3);
            this.baseDao.updateById(orderEntity);
        }else{
            approvalService.insertBatch(approvalList);
            WorkOrderEntity orderEntity = this.baseDao.selectById(approvalOrderDTO.getOrderId());
            orderEntity.setWoState(2);
            this.baseDao.updateById(orderEntity);
        }

        return new Result<String>().ok(approvalOrderDTO.getOrderId() + "审批成功");
    }

    @Override
    public Long updateOrderById(WorkOrderEntity entity) {
        QWorkOrderEntity qWorkOrderEntity = QWorkOrderEntity.workOrderEntity;
        return queryFactory.update(qWorkOrderEntity)
                .set(qWorkOrderEntity.woState,entity.getWoState())
                .where(qWorkOrderEntity.id.eq(entity.getId()).and(qWorkOrderEntity.delFlag.eq(0))).execute();
    }

    @Override
    public void handleProcessNodeSetType(int userId,int orderId,int parentId) {
        WfProcessNodeDTO processNode = nodeService.queryProcessNodeByParentId(parentId);
        if (processNode == null) {
            return;
        }
        List<WfNodeUserEntity> userList = new ArrayList<>();
        //直接上级
        if(processNode.getSetType().equals(NodeSetTypeEnum.DIRECT_SUPERIOR.value())){
            int orgId = deptUserService.getUserOrgIdByUserId(userId);
            UserDTO dto = userSuperiorService.getSuperiorUserByUserId(userId, orgId);
            if(dto != null) {
                userList.add(saveNodeUserForNode(dto, NodeUserTypeEnum.USER.value(), processNode));
            }
        }
        //多级上级
        if(processNode.getSetType().equals(NodeSetTypeEnum.MULTI_SUPERIOR.value())){
            int orgId = deptUserService.getUserOrgIdByUserId(userId);
            List<UserDTO> userDtoList = userSuperiorService.getSuperiorUserByUserId(userId, orgId, processNode.getExamineEndDirectorLevel());
            if(userDtoList != null && !userDtoList.isEmpty()) {
                for (UserDTO dto : userDtoList) {
                    userList.add(saveNodeUserForNode(dto, NodeUserTypeEnum.USER.value(), processNode));
                }
            }
        }
        //部门上级
        if(processNode.getSetType().equals(NodeSetTypeEnum.DEPT_SUPERIOR.value())){
            UserDTO dto = deptUserService.getLeaderByUserId(userId);
            if(dto != null) {
                userList.add(saveNodeUserForNode(dto, NodeUserTypeEnum.USER.value(), processNode));
            }
        }
        //多级部门上级
        if(processNode.getSetType().equals(NodeSetTypeEnum.MULTI_DEPT_SUPERIOR.value())){
            List<UserDTO> userDtoList = deptUserService.getMultiUserByUserId(userId, processNode.getExamineEndDirectorLevel());
            if(userDtoList != null && !userDtoList.isEmpty()) {
                for (UserDTO dto : userDtoList) {
                    userList.add(saveNodeUserForNode(dto, NodeUserTypeEnum.USER.value(), processNode));
                }
            }
        }
        //区域审批人
        if(processNode.getSetType().equals(NodeSetTypeEnum.REGION_SUPERIOR.value())){
            WorkOrderDTO orderDTO = this.get(Integer.toUnsignedLong(orderId));
            List<UserDTO> userDtoList = deptUserService.getRegionUserByRegionId(orderDTO.getRegionId());
            if(userDtoList != null && !userDtoList.isEmpty()) {
                for (UserDTO dto : userDtoList) {
                    userList.add(saveNodeUserForNode(dto, NodeUserTypeEnum.USER.value(), processNode));
                }
            }
        }
        nodeUserService.insertBatch(userList);
    }

    @Override
    public int countWorkOrder(Long formId) {
        return this.baseDao.countWorkOrder(formId);
    }

    private static WfNodeUserEntity saveNodeUserForNode(UserDTO dto, int type, WfProcessNodeDTO nodeDTO) {
        WfNodeUserEntity userDTO = new WfNodeUserEntity();
        userDTO.setRoleId(dto.getUserId());
        userDTO.setRoleName(dto.getUserName());
        userDTO.setType(type);
        userDTO.setProcessId(nodeDTO.getProcessId());
        userDTO.setNodeId(nodeDTO.getId());
        userDTO.setParentNodeId(nodeDTO.getParentId());
        userDTO.setFormId(nodeDTO.getFormId());
        return userDTO;
    }

    private QueryWrapper<WorkOrderEntity> getDtoWrapper(Map<String, Object> params) {
        String id = params.get("id")==null?"":params.get("id").toString();
        String woState = params.get("woState")==null?"":params.get("woState").toString();
        String woCode = params.get("woCode")==null?"":params.get("woCode").toString();
        String schemeName = params.get("schemeName")==null?"":params.get("schemeName").toString();
        String beginDate = params.get("beginDate")==null?"":params.get("beginDate").toString();
        String endDate = params.get("endDate")==null?"":params.get("endDate").toString();
        String executorRole = params.get("executorRole")==null?"":params.get("executorRole").toString();
        String operationType = params.get("operationType")==null?"":params.get("operationType").toString();
        String projectId = params.get("projectId")==null?"":params.get("projectId").toString();
        String userId = params.get("userId")==null?"":params.get("userId").toString();
        String isApproval = params.get("isApproval")==null?"":params.get("isApproval").toString();
        String projectName = params.get("projectName")==null?"":params.get("projectName").toString();
        QueryWrapper<WorkOrderEntity> wrapper = new QueryWrapper<>();
        wrapper.exists(StringUtils.isNotBlank(operationType),"select 1 from t_operation_scheme a where a.id=t.scheme_id and a.operation_type={0}",operationType);
        wrapper.eq(StringUtils.isNotBlank(id), "t.id", id);
        wrapper.eq(StringUtils.isNotBlank(woState), "t.wo_state", woState);
        wrapper.eq(StringUtils.isNotBlank(woCode), "t.wo_code", woCode);
        wrapper.eq(StringUtils.isNotBlank(schemeName), "t.scheme_name", schemeName);
        wrapper.eq(StringUtils.isNotBlank(executorRole), "t.executor_role", executorRole);
        wrapper.ge(StringUtils.isNotBlank(beginDate), "case when t.planned_execution_time is null then t.create_date else t.planned_execution_time end ", beginDate);
        wrapper.le(StringUtils.isNotBlank(endDate), "case when t.planned_execution_time is null then t.create_date else t.planned_execution_time end", endDate);
        wrapper.eq(StringUtils.isNotBlank(projectId), "t.project_id", projectId);
        wrapper.eq(StringUtils.isNotBlank(projectName), "t.project_name", projectName);
        wrapper.eq(StringUtils.isNotBlank(userId), "t.userId", userId);
        wrapper.eq(StringUtils.isNotBlank(isApproval), "t.isApproval", isApproval);
        wrapper.orderByDesc("t.id");
        return wrapper;
    }
}