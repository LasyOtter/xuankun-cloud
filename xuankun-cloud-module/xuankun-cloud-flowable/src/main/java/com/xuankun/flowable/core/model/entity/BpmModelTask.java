package com.xuankun.flowable.core.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xuankun.flowable.core.model.convert.BpmModelTaskConvert;
import com.xuankun.flowable.dto.model.BpmModelTaskDto;
import com.xuankun.flowable.param.model.BpmModelTaskParam;
import com.xuankun.framework.common.function.EntityBaseFunction;
import com.xuankun.framework.mybatis.base.MpDelEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* 模型任务节点配置
* @author xxm
* @date 2022-08-25
*/
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@TableName("bpm_model_task")
public class BpmModelTask extends MpDelEntity implements EntityBaseFunction<BpmModelTaskDto> {

    /** 关联模型id */
    private Long modelId;
    /** 流程定义id */
    private String defId;
    /** 流程key */
    private String defKey;
    /** 关联表单id */
    private Long formId;
    /** 任务节点id */
    private String taskId;
    /** 任务节点名称 */
    private String taskName;
    /** 是否会签 */
    private boolean multi;
    /** 分配类型 */
    private String assignType;
    /** 分配的用户(固定人) */
    private Long userId;
    /** 分配的用户(固定人) */
    private String userName;

    /** 创建对象 */
    public static BpmModelTask init(BpmModelTaskParam in) {
            return BpmModelTaskConvert.CONVERT.convert(in);
    }

    /** 转换成dto */
    @Override
    public BpmModelTaskDto toDto() {
        return BpmModelTaskConvert.CONVERT.convert(this);
    }
}
