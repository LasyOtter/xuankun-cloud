package com.xuankun.workorder.dto;

import com.xuankun.workorder.enums.WorkOrderApprovalTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Jimy
 * @Title: WorkOrderApprovedDTO
 * @Package com.xuankun.workorder.dto
 * @Description: todo
 * @date 2022/9/15:10:52
 */
@Data
@ApiModel(value = "工单审核")
public class WorkOrderApprovedDTO {
    @ApiModelProperty(value = "工单ID")
    private int woId;
    @ApiModelProperty(value = "工单号")
    private String woCode;
    @ApiModelProperty(value = "工单状态")
    private int woState;
    @ApiModelProperty(value = "操作类型:审批:0 驳回:1 提交:2 取消:3")
    private int orderApprovalTypeEnum;
    @ApiModelProperty(value = "操作人")
    private int executorUserId;
    @ApiModelProperty(value = "原因")
    private String reason;
    @ApiModelProperty(value = "备注")
    private String remark;
}
