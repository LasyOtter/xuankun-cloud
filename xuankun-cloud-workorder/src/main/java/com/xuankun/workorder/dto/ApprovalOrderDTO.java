package com.xuankun.workorder.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Jimy
 * @Title: ApprovalOrderDTO
 * @Package com.xuankun.workorder.dto
 * @Description: 审核工单参数实体类 t2.id as approvalId,
 * @date 2022/10/12:13:47
 */
@Data
@ApiModel(value = "审核工单参数实体类")
public class ApprovalOrderDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "工单ID")
    private int orderId;

    @ApiModelProperty(value = "表单ID")
    private Long formId;

    @ApiModelProperty(value = "用户ID")
    private int userId;

    @ApiModelProperty(value = "角色")
    private List<String> roleName;

    @ApiModelProperty(value = "角色ID")
    private List<Integer> roleId;

    @ApiModelProperty(value = "操作类型：1：通过、2：退回、3：作废")
    private int operatorType;

    @ApiModelProperty(value = "审批意见")
    private String remark;

    @ApiModelProperty(value = "流程审批ID")
    private Integer approvalId;
}
