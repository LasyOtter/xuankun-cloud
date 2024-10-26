package com.xuankun.workorder.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 部门与用户对照表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-11-07
 */
@Data
@ApiModel(value = "部门与用户对照表")
public class WfDeptUserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "主键")
	private Integer id;

	@ApiModelProperty(value = "部门ID")
	private Integer deptId;

	@ApiModelProperty(value = "用户ID")
	private Integer userId;

	@ApiModelProperty(value = "用户")
	private String userName;

	@ApiModelProperty(value = "区域ID")
	private Integer regionId;

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