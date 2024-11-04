package com.xuankun.generator.dao;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.xuankun.framework.mybatis.dao.BaseDao;
import com.xuankun.generator.entity.ProjectModifyEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 项目名变更
 *
 * @author jimy
 * 
 */
@Mapper
@InterceptorIgnore(tenantLine = "true")
public interface ProjectModifyDao extends BaseDao<ProjectModifyEntity> {

}