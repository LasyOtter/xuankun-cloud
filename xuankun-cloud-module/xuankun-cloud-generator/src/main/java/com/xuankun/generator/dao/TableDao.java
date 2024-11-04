package com.xuankun.generator.dao;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuankun.generator.entity.TableEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据表
 *
 * @author jimy
 * 
 */
@Mapper
@InterceptorIgnore(tenantLine = "true")
public interface TableDao extends BaseMapper<TableEntity> {

}
