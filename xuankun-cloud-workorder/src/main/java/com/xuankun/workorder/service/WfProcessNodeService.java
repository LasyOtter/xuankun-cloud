package com.xuankun.workorder.service;

import com.xuankun.common.service.CrudService;
import com.xuankun.workorder.dto.PorcessNodeFlowInfoDTO;
import com.xuankun.workorder.dto.WfProcessNodeDTO;
import com.xuankun.workorder.entity.WfNodeUserEntity;
import com.xuankun.workorder.entity.WfProcessNodeEntity;

import java.util.List;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-11
 */
public interface WfProcessNodeService extends CrudService<WfProcessNodeEntity, WfProcessNodeDTO> {
    void deletNodeByCodeAndFormId(String nodeCode, Long formId);

    void deletNodeByProcessIdAndFormId(Long processId, Long formId);

    List<PorcessNodeFlowInfoDTO> getNodeFlowInfo(int orderId);

    WfNodeUserEntity queryAllStartProcessNodeIdByFormId(Long formId);

    int countNodeByFormIdAndParentId(Long formId,int parentNodeId,int isConditionNode);

    WfNodeUserEntity queryApplyNodeUserByFormIdAndRoleAndParentId(Long formId, int userType, int roleId, int parentNodeId, int isConditionNode);

    WfNodeUserEntity queryApplyNodeUserByFormIdAndRoleAndNodeId(Long formId,int userType,int roleId,int nodeId,int isConditionNode);

    WfNodeUserEntity queryStartProcessNodeIdByFormId(Long formId);

    /**
     * 根据父节点ID查询流程节点信息
     * @param parentId
     * @return 流程节点信息
     */
    WfProcessNodeDTO queryProcessNodeByParentId(int parentId);
}