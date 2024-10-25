package com.xuankun.flowable.core.instance.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.xuankun.flowable.core.instance.convert.BpmTaskConvert;
import com.xuankun.flowable.dto.task.BpmTaskDto;
import com.xuankun.framework.common.function.EntityBaseFunction;
import com.xuankun.framework.mybatis.base.MpDelEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * 任务扩展存储
 * @author xxm
 * @date 2022/8/23
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@TableName(value = "bpm_task",autoResultMap = true)
public class BpmTask extends MpDelEntity implements EntityBaseFunction<BpmTaskDto> {

    /** 任务id */
    private String taskId;

    /** 任务节点id */
    private String taskNodeId;

    /** 任务节点名称 */
    private String taskName;

    /** 执行 ID */
    private String executionId;

    /** 流程id */
    private String instanceId;

    /** 流程标题(业务标题) */
    private String instanceName;

    /** 流程名称(流程定义标题) */
    private String defName;

    /** 流程实例的状态 */
    private String state;

    /** 开始时间 */
    private LocalDateTime startTime;

    /** 结束时间 */
    private LocalDateTime endTime;

    /** 处理意见 */
    private String reason;

    /** 提交的表单值 */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Map<String,Object> formVariables;

    /** 当前处理人 */
    private Long userId;

    /** 当前处理人 */
    private String userName;

    /** 流程发起人id */
    private Long startUserId;

    /** 流程发起人名称 */
    private String startUserName;

    /** 转换成dto */
    @Override
    public BpmTaskDto toDto() {
        return BpmTaskConvert.CONVERT.convert(this);
    }
}
