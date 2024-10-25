package com.xuankun.flowable.core.instance.convert;

import com.xuankun.flowable.core.instance.entity.BpmTask;
import com.xuankun.flowable.dto.task.BpmTaskDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 流程任务扩展
 * @author xxm
 * @date 2022-09-01
 */
@Mapper
public interface BpmTaskConvert {
    BpmTaskConvert CONVERT = Mappers.getMapper(BpmTaskConvert.class);

    BpmTaskDto convert(BpmTask in);

}