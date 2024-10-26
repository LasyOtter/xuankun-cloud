package com.xuankun.workorder.service;

import com.xuankun.common.service.CrudService;
import com.xuankun.workorder.dto.ProcessUserApprovalListDTO;
import com.xuankun.workorder.dto.WfProcessUserApprovalDTO;
import com.xuankun.workorder.entity.WfProcessUserApprovalEntity;

import java.util.List;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-12
 */
public interface WfProcessUserApprovalService extends CrudService<WfProcessUserApprovalEntity, WfProcessUserApprovalDTO> {

    WfProcessUserApprovalEntity getApproveByOrderIdAndNodeId(int orderId, int nodeId);

    WfProcessUserApprovalEntity getOldApprove(int orderId, List<String> roleName);
    WfProcessUserApprovalEntity getApprovalByOrderIdAndRoleId(int orderId, List<Integer> roleId, int userId);

    List<ProcessUserApprovalListDTO> getApproveListByOrderId(int orderId);

    WfProcessUserApprovalEntity getNodeApprovalInfoByParentNodedId(int parentNodeId,int orderId,long formId);

    /**
     * 计算未会签数量
     * @param nodeId 节点ID
     * @param isApproval 是否审批通过
     * @return 未会签数量
     */
    int countProcessNodeByNodeIdAndIsApproval(int orderId,int nodeId,int isApproval);

    Long updateApprovalById(WfProcessUserApprovalEntity entity);

    void deleteApproveByParentNodeIdIdAndNodeId(int parentNodeId,int nodeId,int orderId);
}