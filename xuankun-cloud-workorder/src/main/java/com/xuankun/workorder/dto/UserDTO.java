package com.xuankun.workorder.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Jimy
 * @Title: UserDTO
 * @Package com.xuankun.workorder.dto
 * @Description: 用户信息
 * @date 2022/11/4:15:27
 */
@Data
@ApiModel(value = "用户信息")
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    private int userId;
    @ApiModelProperty(value = "用户")
    private String userName;
}
