package com.xuankun.workorder.core.handler;

/**
 * @author Jimy
 * @Title: RollBackHandler
 * @Package com.xuankun.workflow.core.handler
 * @Description: todo
 * @date 2022/10/17:16:40
 */
public abstract class RollBackHandler {

    /**
     * 下一个节点处理
     */
    private ApprovalHandler next;

    /**
     * 退回到某个节点
     * @param nodeId
     * @return
     */
    public abstract boolean rollBack(int nodeId);

    /**
     * 初始化下一个节点
     * @return
     */
    public abstract boolean applyNexNode();
}
