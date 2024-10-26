package com.xuankun.workorder.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Jimy
 * @Title: QueryFormDTO
 * @Package com.xuankun.workorder.dto
 * @Description: 查询表单实体类
 * @date 2022/11/11:13:02
 */
@Data
@ApiModel("查询表单实体类")
public class QueryFormDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户ID")
    private List<Integer> userIds;
    @ApiModelProperty("角色ID")
    private List<Integer> roleIds;
}
