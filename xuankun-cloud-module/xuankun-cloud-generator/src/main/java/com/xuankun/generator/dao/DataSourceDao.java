package com.xuankun.generator.dao;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuankun.generator.entity.DataSourceEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据源管理
 *
 * @author jimy
 * 
 */
@Mapper
@InterceptorIgnore(tenantLine = "true")
public interface DataSourceDao extends BaseMapper<DataSourceEntity> {

}