package com.xuankun.workorder.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Jimy
 * @Title: RegionUserDTO
 * @Package com.xuankun.workorder.dto
 * @Description: todo
 * @date 2022/11/8:9:15
 */
@Data
@ApiModel(value = "区域用户对照")
public class RegionUserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "区域ID")
    private int regionId;
    @ApiModelProperty(value = "区域")
    private String regionName;
    @ApiModelProperty(value = "用户ID")
    private int userId;
    @ApiModelProperty(value = "用户")
    private String userName;
}
