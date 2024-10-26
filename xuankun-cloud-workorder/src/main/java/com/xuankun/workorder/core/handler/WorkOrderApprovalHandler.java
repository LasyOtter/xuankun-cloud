package com.xuankun.workorder.core.handler;

import com.xuankun.workorder.dto.ApprovalOrderDTO;
import com.xuankun.workorder.entity.WfNodeUserEntity;
import com.xuankun.workorder.service.WfNodeUserService;
import com.xuankun.workorder.service.WfProcessNodeService;
import com.xuankun.workorder.service.WfProcessUserApprovalService;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jimy
 * @Title: WorkOrderApprovalHandler
 * @Package com.xuankun.workorder.handler
 * @Description: 节点审批通过
 * @date 2022/10/17:17:04
 */
@Slf4j
public class WorkOrderApprovalHandler extends ApprovalHandler {

    @Resource
    private WfProcessNodeService nodeService;
    @Resource
    private WfProcessUserApprovalService approvalService;
    @Resource
    private WfNodeUserService nodeUserService;


    @Override
    public boolean handler() {
        ApprovalOrderDTO approvalOrderDTO = this.getCurrentNodeInfo();
        List<WfNodeUserEntity> nodeUserList = new ArrayList<>();
        nodeUserList = nodeUserService.getNodeUserInfo(approvalOrderDTO.getOrderId(),approvalOrderDTO.getFormId(), approvalOrderDTO.getRoleName());
        if(nodeUserList == null || nodeUserList.size() == 0){
            log.error("该工单的流程表单未设置好，请联系相关人员");
            return false;
        }
        return false;
    }

    @Override
    public boolean applyNexNode() {
        return false;
    }
}
