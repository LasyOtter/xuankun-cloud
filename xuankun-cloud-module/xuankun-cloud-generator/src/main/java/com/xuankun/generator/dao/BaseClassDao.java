package com.xuankun.generator.dao;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuankun.generator.entity.BaseClassEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 基类管理
 *
 * @author jimy
 * 
 */
@Mapper
@InterceptorIgnore(tenantLine = "true")
public interface BaseClassDao extends BaseMapper<BaseClassEntity> {

}