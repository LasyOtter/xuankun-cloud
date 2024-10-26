package com.xuankun.workorder.service;

import com.xuankun.workorder.dto.WorkOrderApprovedDTO;

/**
 * @author Jimy
 * @Title: DroolsService
 * @Package com.xuankun.workorder.service
 * @Description: todo
 * @date 2022/9/21:10:19
 */
public interface DroolsService {

    void testPersonRule();

    void testWoRule(WorkOrderApprovedDTO approvedDTO,WoWorkFlowService woWorkFlowService,WoWorkFlowRecordService recordService,WorkOrderService workOrderService);
}
