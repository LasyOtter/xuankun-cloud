package com.xuankun.workorder.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 表单发起用户表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-20
 */
@Data
@ApiModel(value = "表单发起用户表")
public class WfFormUserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "主键")
	private Integer id;

	@ApiModelProperty(value = "表单ID")
	private Long formId;

	@ApiModelProperty(value = "用户/角色ID")
	private Integer userId;

	@ApiModelProperty(value = "用户/角色")
	private Integer userName;

	@ApiModelProperty(value = "类型：1：用户；2：角色")
	private int type = 1;

	@ApiModelProperty(value = "组织ID")
	private Integer orgId;

	@ApiModelProperty(value = "创建人")
	private String creator;

	@ApiModelProperty(value = "创建时间")
	private LocalDateTime createDate;

	@ApiModelProperty(value = "修改人")
	private String updator;

	@ApiModelProperty(value = "修改时间")
	private LocalDateTime updateDate;

	@ApiModelProperty(value = "逻辑删除标识")
	private Integer delFlag;


}