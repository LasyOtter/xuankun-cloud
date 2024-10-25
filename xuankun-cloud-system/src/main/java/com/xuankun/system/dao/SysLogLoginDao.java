package com.xuankun.system.dao;

import com.xuankun.framework.mybatis.dao.BaseDao;
import com.xuankun.system.entity.SysLogLoginEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 登录日志
 *
 * @author Jimy
 */
@Mapper
public interface SysLogLoginDao extends BaseDao<SysLogLoginEntity> {

}