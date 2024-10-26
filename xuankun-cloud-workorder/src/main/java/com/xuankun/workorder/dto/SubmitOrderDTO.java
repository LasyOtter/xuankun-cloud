package com.xuankun.workorder.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Jimy
 * @Title: SubmitOrderDTO
 * @Package com.xuankun.workorder.dto
 * @Description: 提交工单参数实体类
 * @date 2022/10/12:13:43
 */
@Data
@ApiModel(value = "提交工单参数实体类")
public class SubmitOrderDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "工单ID")
    private int orderId;

    @ApiModelProperty(value = "表单ID")
    private long formId;

    @ApiModelProperty(value = "用户ID")
    private int userId;

    @ApiModelProperty(value = "用户")
    private String userName;

    @ApiModelProperty(value = "角色ID")
    private Integer roleId;

    @ApiModelProperty(value = "角色")
    private String roleName;
}
