package com.xuankun.flowable.core.instance.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuankun.flowable.core.instance.entity.BpmInstance;
import org.apache.ibatis.annotations.Mapper;

/**
 * 流程实例扩展
 * @author xxm
 * @date 2022-08-23
 */
@Mapper
public interface BpmInstanceMapper extends BaseMapper<BpmInstance> {
}