package com.xuankun.message.dao;

import com.xuankun.framework.mybatis.dao.BaseDao;
import com.xuankun.message.entity.SmsPlatformEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 短信平台
*
* @author Jimy
*/
@Mapper
public interface SmsPlatformDao extends BaseDao<SmsPlatformEntity> {
	
}