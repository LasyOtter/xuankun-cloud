package com.xuankun.quartz.dao;

import com.xuankun.framework.mybatis.dao.BaseDao;
import com.xuankun.quartz.entity.ScheduleJobEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 定时任务
*
* @author Jimy
*/
@Mapper
public interface ScheduleJobDao extends BaseDao<ScheduleJobEntity> {
	
}