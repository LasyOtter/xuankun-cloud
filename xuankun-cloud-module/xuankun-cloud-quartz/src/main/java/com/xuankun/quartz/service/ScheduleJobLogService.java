package com.xuankun.quartz.service;

import com.xuankun.framework.common.page.PageResult;
import com.xuankun.framework.mybatis.service.BaseService;
import com.xuankun.quartz.entity.ScheduleJobLogEntity;
import com.xuankun.quartz.query.ScheduleJobLogQuery;
import com.xuankun.quartz.vo.ScheduleJobLogVO;

/**
 * 定时任务日志
 *
 * @author Jimy
 */
public interface ScheduleJobLogService extends BaseService<ScheduleJobLogEntity> {

    PageResult<ScheduleJobLogVO> page(ScheduleJobLogQuery query);

}