package com.xuankun.system.dao;

import com.xuankun.framework.mybatis.dao.BaseDao;
import com.xuankun.system.entity.SysPostEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 岗位管理
*
* @author Jimy
*/
@Mapper
public interface SysPostDao extends BaseDao<SysPostEntity> {
	
}