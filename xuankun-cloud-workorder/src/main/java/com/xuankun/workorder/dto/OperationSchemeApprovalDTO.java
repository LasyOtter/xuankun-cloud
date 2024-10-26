package com.xuankun.workorder.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Jimy
 * @Title: OperationSchemeApprovalDTO
 * @Package com.xuankun.workorder.dto
 * @Description: todo
 * @date 2022/9/16:10:44
 */
@Data
@ApiModel(value = "运维方案审批信息")
public class OperationSchemeApprovalDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "运维方案主键")
    private Integer id;

    @ApiModelProperty(value = "审批级别")
    private String approvalLevel = "一级审批";

    @ApiModelProperty(value = "审批类型:0:审批;1:驳回")
    private int approvalType;

    @ApiModelProperty(value = "审核人ID")
    private String ReviewedUserId;

    @ApiModelProperty(value = "审核人")
    private String ReviewedBy;

    @ApiModelProperty(value = "审批状态:0:未审核;1:第一审核人审批;2:第二审核人审批;3:已审批")
    private int approvalState;
}
