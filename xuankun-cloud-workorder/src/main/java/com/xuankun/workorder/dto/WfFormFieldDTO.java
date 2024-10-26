package com.xuankun.workorder.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;


/**
 * 流程表单字段权限表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-19
 */
@Data
@ApiModel(value = "流程表单字段权限表")
public class WfFormFieldDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "主键")
	private Integer id;

	@ApiModelProperty(value = "流程ID")
	private long processId;

	@ApiModelProperty(value = "节点ID")
	private Integer nodeId;

	@ApiModelProperty(value = "流程表单ID")
	private long formId;

	@ApiModelProperty(value = "字段关键字")
	private String field;

	@ApiModelProperty(value = "字段名称")
	private String fieldName;

	@ApiModelProperty(value = "是否必填")
	private boolean required;

	@ApiModelProperty(value = "可选操作：editable：可编辑  readonly：只读  hidden：隐藏")
	private String operation;

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