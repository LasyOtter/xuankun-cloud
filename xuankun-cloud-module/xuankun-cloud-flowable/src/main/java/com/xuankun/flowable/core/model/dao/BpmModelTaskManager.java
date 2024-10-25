package com.xuankun.flowable.core.model.dao;

import com.xuankun.flowable.core.model.entity.BpmModelTask;
import com.xuankun.framework.mybatis.dao.BaseManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 模型任务节点配置
 * @author xxm
 * @date 2022-08-25
 */
@Repository
@RequiredArgsConstructor
public class BpmModelTaskManager extends BaseManager<BpmModelTaskMapper, BpmModelTask> {


    /**
     * 根据ModelId查询
     */
    public List<BpmModelTask> findAllByModelId(Long modelId) {
        return findAllByField(BpmModelTask::getModelId,modelId);
    }

    /**
     * 查询任务节点配置项
     *
     * @param defId  定义id
     * @param taskId 任务节点id
     */
    public BpmModelTask findByDefIdAndTaskId(String defId, String taskId){
        return lambdaQuery()
                .eq(BpmModelTask::getDefId,defId)
                .eq(BpmModelTask::getTaskId,taskId)
                .one();
    }
}