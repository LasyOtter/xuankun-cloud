package com.xuankun.workorder.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 流程实例关联表单
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-11
 */
@Data
@ApiModel(value = "流程实例关联表单")
public class WfDeployFormDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "流程表单实例主键")
	private Integer id;

	@ApiModelProperty(value = "表单ID")
	private Long formId;

	@ApiModelProperty(value = "节点Key")
	private Integer processId;

	@ApiModelProperty(value = "节点名称")
	private Integer nodeId;

	@ApiModelProperty(value = "表单内容")
	private String content;

	@ApiModelProperty(value = "工单主键")
	private Integer workOrderId;

	@ApiModelProperty(value = "工单号")
	private String workOrderCode;
	/**
	 * 是否通用：通用表单不用保存到工单里面去  0：不通用；1：通用
	 */
	@ApiModelProperty(value = "表单是否通用")
	private int inCommonUse;

	@ApiModelProperty(value = "创建人")
	private String creator;

	@ApiModelProperty(value = "创建时间")
	private Date createDate;

	@ApiModelProperty(value = "修改人")
	private String updator;

	@ApiModelProperty(value = "修改时间")
	private Date updateDate;

	@ApiModelProperty(value = "逻辑删除")
	private Integer delFlag;
}