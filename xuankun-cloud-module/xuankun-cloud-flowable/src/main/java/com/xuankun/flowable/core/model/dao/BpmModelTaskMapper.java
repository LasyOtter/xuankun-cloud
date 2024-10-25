package com.xuankun.flowable.core.model.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuankun.flowable.core.model.entity.BpmModelTask;
import org.apache.ibatis.annotations.Mapper;

/**
 * 模型任务节点配置
 * @author xxm
 * @date 2022-08-25
 */
@Mapper
public interface BpmModelTaskMapper extends BaseMapper<BpmModelTask> {
}