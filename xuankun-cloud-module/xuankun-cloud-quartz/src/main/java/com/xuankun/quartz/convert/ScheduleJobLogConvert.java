package com.xuankun.quartz.convert;

import com.xuankun.quartz.entity.ScheduleJobLogEntity;
import com.xuankun.quartz.vo.ScheduleJobLogVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 定时任务日志
*
* @author Jimy
*/
@Mapper
public interface ScheduleJobLogConvert {
    ScheduleJobLogConvert INSTANCE = Mappers.getMapper(ScheduleJobLogConvert.class);

    ScheduleJobLogEntity convert(ScheduleJobLogVO vo);

    ScheduleJobLogVO convert(ScheduleJobLogEntity entity);

    List<ScheduleJobLogVO> convertList(List<ScheduleJobLogEntity> list);

}