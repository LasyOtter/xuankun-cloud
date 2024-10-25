package com.xuankun.flowable.core.model.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuankun.flowable.core.model.entity.BpmModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * 流程模型
 * @author xxm
 * @date 2022-08-23
 */
@Mapper
public interface BpmModelMapper extends BaseMapper<BpmModel> {
}