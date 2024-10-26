package com.xuankun.workorder.service;

import com.xuankun.common.service.CrudService;
import com.xuankun.workorder.dto.WoWorkFlowDTO;
import com.xuankun.workorder.entity.WoWorkFlowEntity;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-09-19
 */
public interface WoWorkFlowService extends CrudService<WoWorkFlowEntity, WoWorkFlowDTO> {
    /**
     * 根据工单ID以及状态获取工单流程信息
     * @param workOrderId 工单ID
     * @param state 状态
     * @return
     */
    WoWorkFlowDTO getWoWorkFlowByWorkOrderId(int workOrderId,int state);

    /**
     * 根据工单号以及状态获取工单流程信息
     * @param workOrderCode 工单号
     * @param state 状态
     * @return
     */
    WoWorkFlowDTO getWoWorkFlowByWorkOrderCode(String workOrderCode,int state);
}