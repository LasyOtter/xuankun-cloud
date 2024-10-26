package com.xuankun.workorder.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Jimy
 * @Title: NodeUserDTO
 * @Package com.xuankun.workorder.dto
 * @Description: todo
 * @date 2022/10/18:11:21
 */
@Data
@ApiModel(value = "流程节点用户或者角色权限")
public class NodeUserDTO {

    @ApiModelProperty(value = "用户或者角色id")
    private Integer id;

    @ApiModelProperty(value = "用户或者角色")
    private String name;

    @ApiModelProperty(value = "1:用户；2：角色")
    private int type;
}
