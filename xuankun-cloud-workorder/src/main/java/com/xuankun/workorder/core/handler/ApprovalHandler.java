package com.xuankun.workorder.core.handler;

import com.xuankun.workorder.dto.ApprovalOrderDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Jimy
 * @Title: ApprovalHandler
 * @Package com.xuankun.workflow.core.handler
 * @Description: todo
 * @date 2022/10/17:16:22
 */
public abstract class ApprovalHandler {

    @Getter
    @Setter
    private ApprovalOrderDTO currentNodeInfo;
    /**
     * 下一个节点处理
     */
    @Getter
    @Setter
    private ApprovalHandler next;

    /**
     * 审批通过
     * @return
     */
    public abstract boolean handler();

    /**
     * 初始化下一个节点
     * @return
     */
    public abstract boolean applyNexNode();
}
