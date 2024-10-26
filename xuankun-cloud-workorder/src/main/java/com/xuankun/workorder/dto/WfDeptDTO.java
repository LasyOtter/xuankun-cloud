package com.xuankun.workorder.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 部门表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-31
 */
@Data
@ApiModel(value = "部门表")
public class WfDeptDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "部门id")
	private Long id;

	@ApiModelProperty(value = "部门名称")
	private String name;

	@ApiModelProperty(value = "父部门id")
	private Long parentId;

	@ApiModelProperty(value = "显示顺序")
	private Integer sort;

	@ApiModelProperty(value = "负责人ID")
	private Long leaderUserId;

	/**
	 * 负责人
	 */
	@ApiModelProperty(value = "负责人")
	private String leaderUserName;

	@ApiModelProperty(value = "联系电话")
	private String phone;

	@ApiModelProperty(value = "邮箱")
	private String email;

	@ApiModelProperty(value = "部门状态（0正常 1停用）")
	private Integer status;

	@ApiModelProperty(value = "创建者")
	private String creator;

	@ApiModelProperty(value = "创建时间")
	private LocalDateTime createDate;

	@ApiModelProperty(value = "更新者")
	private String updator;

	@ApiModelProperty(value = "更新时间")
	private LocalDateTime updateDate;

	@ApiModelProperty(value = "是否删除")
	private boolean delFlag;

	@ApiModelProperty(value = "租户编号/组织编号")
	private Long tenantId;


}