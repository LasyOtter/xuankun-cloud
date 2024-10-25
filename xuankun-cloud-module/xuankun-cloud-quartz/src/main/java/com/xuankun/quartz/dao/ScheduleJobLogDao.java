package com.xuankun.quartz.dao;

import com.xuankun.framework.mybatis.dao.BaseDao;
import com.xuankun.quartz.entity.ScheduleJobLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 定时任务日志
*
* @author Jimy
*/
@Mapper
public interface ScheduleJobLogDao extends BaseDao<ScheduleJobLogEntity> {
	
}