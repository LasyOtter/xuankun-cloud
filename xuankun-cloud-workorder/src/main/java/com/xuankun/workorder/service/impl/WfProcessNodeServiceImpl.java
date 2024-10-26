package com.xuankun.workorder.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xuankun.common.service.impl.CrudServiceImpl;
import com.xuankun.common.utils.ConvertUtils;
import com.xuankun.workorder.dto.PorcessNodeFlowInfoDTO;
import com.xuankun.workorder.entity.WfNodeUserEntity;
import com.xuankun.workorder.service.WfProcessNodeService;
import com.xuankun.workorder.dao.WfProcessNodeDao;
import com.xuankun.workorder.dto.WfProcessNodeDTO;
import com.xuankun.workorder.entity.WfProcessNodeEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-11
 */
@Service
public class WfProcessNodeServiceImpl extends CrudServiceImpl<WfProcessNodeDao, WfProcessNodeEntity, WfProcessNodeDTO> implements WfProcessNodeService {

    @Override
    public QueryWrapper<WfProcessNodeEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");
        Long processId = (Long) params.get("processId");
        Long formId = (Long) params.get("formId");
        Integer parentId = (Integer) params.get("parentId");
        String nodeCode = (String)params.get("nodeCode");

        QueryWrapper<WfProcessNodeEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);
        wrapper.eq(processId != null, "process_id", processId);
        wrapper.eq(formId != null, "form_id", formId);
        wrapper.eq(parentId != null, "parent_id", parentId);
        wrapper.eq(StringUtils.isNotBlank(nodeCode), "node_code", nodeCode);
        return wrapper;
    }

    @Override
    public void deletNodeByCodeAndFormId(String nodeCode, Long formId) {
        this.baseDao.deletNodeByCodeAndFormId(nodeCode, formId);
    }

    @Override
    public void deletNodeByProcessIdAndFormId(Long processId, Long formId) {
        Map<String, Object> params = new HashMap<>();
        params.put("processId",processId);
        params.put("formId",formId);
        this.baseDao.delete(getWrapper(params));
//        this.baseDao.deletNodeByProcessIdAndFormId(processId, formId);
    }

    @Override
    public List<PorcessNodeFlowInfoDTO> getNodeFlowInfo(int orderId) {
        return this.baseDao.getNodeFlowInfo(orderId);
    }

    @Override
    public WfNodeUserEntity queryAllStartProcessNodeIdByFormId(Long formId) {
        return this.baseDao.queryAllStartProcessNodeIdByFormId(formId);
    }

    @Override
    public int countNodeByFormIdAndParentId(Long formId, int parentNodeId, int isConditionNode) {
        return this.baseDao.countNodeByFormIdAndParentId(formId, parentNodeId, isConditionNode);
    }

    @Override
    public WfNodeUserEntity queryApplyNodeUserByFormIdAndRoleAndParentId(Long formId, int userType, int roleId, int parentNodeId, int isConditionNode) {
        return this.baseDao.queryApplyNodeUserByFormIdAndRoleAndParentId(formId, userType, roleId, parentNodeId, isConditionNode);
    }

    @Override
    public WfNodeUserEntity queryApplyNodeUserByFormIdAndRoleAndNodeId(Long formId, int userType, int roleId, int nodeId, int isConditionNode) {
        return this.baseDao.queryApplyNodeUserByFormIdAndRoleAndNodeId(formId, userType, roleId, nodeId, isConditionNode);
    }

    @Override
    public WfNodeUserEntity queryStartProcessNodeIdByFormId(Long formId) {
        return this.baseDao.queryStartProcessNodeIdByFormId(formId);
    }

    @Override
    public WfProcessNodeDTO queryProcessNodeByParentId(int parentId) {
        QueryWrapper<WfProcessNodeEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id",parentId);
        WfProcessNodeEntity processNode = this.baseDao.selectOne(wrapper);
        WfProcessNodeDTO processNodeDTO = new WfProcessNodeDTO();
        if(processNodeDTO != null){
            processNodeDTO = ConvertUtils.sourceToTarget(processNode,WfProcessNodeDTO.class);
        }
        return processNodeDTO;
    }
}