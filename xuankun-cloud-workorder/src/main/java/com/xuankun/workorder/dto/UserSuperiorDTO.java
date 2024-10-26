package com.xuankun.workorder.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Jimy
 * @Title: UserSuperiorDTO
 * @Package com.xuankun.workorder.dto
 * @Description: todo
 * @date 2022/11/15:12:46
 */
@Data
@ApiModel(value = "上级管理")
public class UserSuperiorDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "用户ID")
    private Integer userId;

    @ApiModelProperty(value = "用户")
    private String userName;

//    @ApiModelProperty(value = "上级ID")
//    private Integer parentUserId;
//
//    @ApiModelProperty(value = "上级")
//    private String parentUserName;

    @ApiModelProperty(value = "组织")
    private String orgName;

    @ApiModelProperty(value = "组织ID")
    private Integer orgId;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    /**
     * 是否直属：0：否；1：是
     */
    @ApiModelProperty(value = "是否直属：0：否；1：是")
    private int isDirectly;

    @ApiModelProperty(value = "创建人")
    private String creator;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "修改人")
    private String updator;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateDate;

    @ApiModelProperty(value = "逻辑删除")
    private Integer delFlag;
}
