package com.xuankun.flowable.core.instance.service;

import com.xuankun.flowable.core.instance.dao.BpmTaskManager;
import com.xuankun.flowable.core.instance.entity.BpmTask;
import com.xuankun.flowable.handler.TaskRejectHandler;
import com.xuankun.flowable.local.BpmContext;
import com.xuankun.flowable.local.BpmContextLocal;
import com.xuankun.flowable.param.task.TaskApproveParam;
import com.xuankun.flowable.param.task.TaskReturnParam;
import com.xuankun.framework.common.exception.DataNotExistException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * 流程任务接口
 * @author xxm
 * @date 2022/8/24 
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BpmTaskOperateService {
    private final TaskService taskService;
    private final BpmTaskManager bpmTaskManager;

    private final TaskRejectHandler taskRejectHandler;


    /**
     * 通过
     */
    @Transactional(rollbackFor = Exception.class)
    public void pass(TaskApproveParam param){
        BpmTask bpmTask = bpmTaskManager.findByTaskId(param.getTaskId()).orElseThrow(() -> new DataNotExistException("任务不存在"));
        // 查询到任务和扩展属性
        Task task = taskService.createTaskQuery().taskId(param.getTaskId()).singleResult();
        BpmContext bpmContext = BpmContextLocal.get();
        bpmContext.setReason(param.getReason())
                .setFormVariables(param.getFormVariables());
        BpmContextLocal.put(bpmContext);
        taskService.complete(task.getId());
        bpmTask.setReason(param.getReason())
                .setEndTime(LocalDateTime.now());
        bpmTaskManager.updateById(bpmTask);
    }
    /**
     * 驳回
     */
    @Transactional(rollbackFor = Exception.class)
    public void reject(TaskApproveParam param){
        BpmTask bpmTask = bpmTaskManager.findByTaskId(param.getTaskId()).orElseThrow(() -> new DataNotExistException("任务不存在"));
        BpmContext bpmContext = BpmContextLocal.get();
        bpmContext.setReason(param.getReason())
                .setFormVariables(param.getFormVariables());
        BpmContextLocal.put(bpmContext);
        taskRejectHandler.flowTalkBack(param.getTaskId());
        bpmTask.setReason(param.getReason())
                .setEndTime(LocalDateTime.now());
        bpmTaskManager.updateById(bpmTask);
    }

    /**
     * 流程回退
     */
    public void flowReturn(TaskReturnParam param){
        taskRejectHandler.flowReturn(param.getTaskId(),param.getTargetKey());
    }

    /**
     * 重新分配人员
     */
    public void assignee(String taskId, Long userId){
        taskService.setAssignee(taskId, String.valueOf(userId));
    }

}
