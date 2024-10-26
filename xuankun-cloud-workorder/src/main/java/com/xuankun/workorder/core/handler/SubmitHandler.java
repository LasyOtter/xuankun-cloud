package com.xuankun.workorder.core.handler;

import com.xuankun.workorder.dto.WfProcessNodeDTO;

/**
 * @author Jimy
 * @Title: SubmitHandler
 * @Package com.xuankun.workflow.core.handler
 * @Description: todo
 * @date 2022/10/17:16:46
 */
public abstract class SubmitHandler {
    /**
     * 下一个节点处理
     */
    private ApprovalHandler next;

    /**
     * 提交某个节点
     * @param nodeDTO 提交节点
     * @return
     */
    public abstract boolean submit(WfProcessNodeDTO nodeDTO);

    /**
     * 初始化下一个节点
     * @return
     */
    public abstract boolean applyNexNode();
}
