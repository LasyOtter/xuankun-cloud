package com.xuankun.message.dao;

import com.xuankun.framework.mybatis.dao.BaseDao;
import com.xuankun.message.entity.SmsLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 短信日志
*
* @author Jimy
*/
@Mapper
public interface SmsLogDao extends BaseDao<SmsLogEntity> {
	
}