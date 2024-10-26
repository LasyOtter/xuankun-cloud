package com.xuankun.workorder.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author Jimy
 * @Title: RegionUserRoleDTO
 * @Package com.xuankun.workorder.dto
 * @Description: 区域角色用户对照
 * @date 2022/11/8:9:03
 */
@Data
@ApiModel(value = "区域角色用户对照")
public class RegionUserRoleDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "列头-权限")
    private List<RoleDTO> roleList;

    @ApiModelProperty(value = "用户数据")
    private List<Map<String,Object>> userNameList;

    @ApiModelProperty(value = "用户ID数据")
    private List<Map<String,Object>> userIdList;
}
