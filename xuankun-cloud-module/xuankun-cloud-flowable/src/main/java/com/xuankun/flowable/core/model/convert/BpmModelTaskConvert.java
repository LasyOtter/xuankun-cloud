package com.xuankun.flowable.core.model.convert;

import com.xuankun.flowable.core.model.entity.BpmModelTask;
import com.xuankun.flowable.dto.model.BpmModelTaskDto;
import com.xuankun.flowable.param.model.BpmModelTaskParam;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 模型任务节点配置
 * @author xxm
 * @date 2022-08-25
 */
@Mapper
public interface BpmModelTaskConvert {
    BpmModelTaskConvert CONVERT = Mappers.getMapper(BpmModelTaskConvert.class);

    BpmModelTask convert(BpmModelTaskParam in);

    BpmModelTaskDto convert(BpmModelTask in);

}