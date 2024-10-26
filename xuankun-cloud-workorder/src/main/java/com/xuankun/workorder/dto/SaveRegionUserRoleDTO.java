package com.xuankun.workorder.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Jimy
 * @Title: SaveRegionUserDTO
 * @Package com.xuankun.workorder.dto
 * @Description: todo
 * @date 2022/11/8:18:12
 */
@Data
@ApiModel("保存区域用户信息")
public class SaveRegionUserRoleDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "派单系统用户ID")
    private Integer userId;

    @ApiModelProperty(value = "派单系统角色")
    private RoleDTO roleDTO;

    @ApiModelProperty(value = "派单系统区域ID")
    private Integer regionId;

    @ApiModelProperty(value = "组织ID")
    private Integer orgId;
}
