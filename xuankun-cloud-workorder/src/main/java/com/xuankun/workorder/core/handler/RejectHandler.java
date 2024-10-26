package com.xuankun.workorder.core.handler;

/**
 * @author Jimy
 * @Title: RejectHandler
 * @Package com.xuankun.workflow.core.handler
 * @Description: todo
 * @date 2022/10/17:16:44
 */
public abstract class RejectHandler {
    /**
     * 下一个节点处理
     */
    private ApprovalHandler next;

    /**
     * 驳回
     * @param nodeId
     * @return
     */
    public abstract boolean reject(int nodeId);

    /**
     * 初始化下一个节点
     * @return
     */
    public abstract boolean applyNexNode();
}
