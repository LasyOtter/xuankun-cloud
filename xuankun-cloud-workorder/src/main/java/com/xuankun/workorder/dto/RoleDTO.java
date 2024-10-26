package com.xuankun.workorder.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Jimy
 * @Title: RoleDTO
 * @Package com.xuankun.workorder.dto
 * @Description: 角色
 * @date 2022/11/10:10:02
 */
@Data
@ApiModel("角色")
public class RoleDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("角色ID")
    private int roleId;
    @ApiModelProperty("角色")
    private String roleName;
}
