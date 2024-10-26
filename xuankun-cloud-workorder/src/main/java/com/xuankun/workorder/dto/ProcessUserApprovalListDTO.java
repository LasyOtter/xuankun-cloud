package com.xuankun.workorder.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Jimy
 * @Title: ProcessUserApprovalListDTO
 * @Package com.xuankun.workorder.dto
 * @Description: 流程审批信息列表
 * @date 2022/10/18:17:55
 */
@Data
@ApiModel(value = "流程审批信息列表")
public class ProcessUserApprovalListDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "工单ID")
    private int orderId;
    @ApiModelProperty(value = "角色")
    private String roleName;
    @ApiModelProperty(value = "审批状态")
    private String approvalState;
    @ApiModelProperty(value = "审批意见")
    private String remark;
    @ApiModelProperty(value = "审批时间")
    private LocalDateTime approvalDate;
}
