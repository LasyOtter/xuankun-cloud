package com.xuankun.flowable.core.instance.dao;

import com.xuankun.flowable.core.instance.entity.BpmTask;
import com.xuankun.framework.mybatis.base.MpIdEntity;
import com.xuankun.framework.mybatis.dao.BaseManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 流程任务扩展
 * @author xxm
 * @date 2022-08-27
 */
@Repository
@RequiredArgsConstructor
public class BpmTaskManager extends BaseManager<BpmTaskMapper, BpmTask> {


    /**
     * 根据任务id查询
     */
    public Optional<BpmTask> findByTaskId(String taskId){
        return findByField(BpmTask::getTaskId,taskId);
    }

    /**
     * 根据任务id查询
     */
    public List<BpmTask> findAllByTaskIds(List<String> taskIds){
        return findAllByFields(BpmTask::getTaskId,taskIds);
    }


    /**
     * 根据实例id和任务id查询
     */
    public Optional<BpmTask> findByInstanceIdAndTaskId(String instanceId,String taskId){
        return lambdaQuery()
                .eq(BpmTask::getInstanceId,instanceId)
                .eq(BpmTask::getTaskId,taskId)
                .oneOpt();
    }

    public List<BpmTask> findAllByInstanceId(String instanceId) {
        return lambdaQuery()
                .eq(BpmTask::getInstanceId,instanceId)
                .orderByDesc(MpIdEntity::getId)
                .list();
    }
}