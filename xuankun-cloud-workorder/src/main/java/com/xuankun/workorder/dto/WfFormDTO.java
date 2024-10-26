package com.xuankun.workorder.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 流程表单信息表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-11
 */
@Data
@ApiModel(value = "流程表单信息表")
public class WfFormDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "表单主键")
	private Long formId;

	@ApiModelProperty(value = "流程主键")
	private Long processId;

	@ApiModelProperty(value = "表单名称")
	private String formName;

	@ApiModelProperty(value = "表单内容")
	private String content;

	@ApiModelProperty(value = "表单分组ID")
	private Integer groupId;

	/**
	 * 是否通用：通用表单不用保存到工单里面去  0：不通用；1：通用
	 */
	@ApiModelProperty(value = "表单是否通用")
	private int inCommonUse;

	@ApiModelProperty(value = "创建者")
	private String createBy;

	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	@ApiModelProperty(value = "更新者")
	private String updateBy;

	@ApiModelProperty(value = "更新时间")
	private Date updateTime;

	@ApiModelProperty(value = "备注")
	private String remark;

	@ApiModelProperty(value = "删除标志（0代表存在 1代表删除）")
	private int delFlag;


}