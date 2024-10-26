package com.xuankun.workorder.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-11
 */
@Data
@ApiModel(value = "")
public class WfNodeConditionDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "主键")
	private Integer id;

	@ApiModelProperty(value = "表单ID")
	private Long formId;

	@ApiModelProperty(value = "所属节点主键")
	private Integer nodeId;

	@ApiModelProperty(value = "发起人")
	private Integer columnId;

	@ApiModelProperty(value = "1:发起人;2其他")
	private Integer type;

	@ApiModelProperty(value = "操作符")
	private String optType;

	@ApiModelProperty(value = "左侧自定义内容")
	private String zdy1;

	@ApiModelProperty(value = "右侧自定义内容")
	private String zdy2;

	@ApiModelProperty(value = "左侧操作符")
	private String opt1;

	@ApiModelProperty(value = "右侧操作符")
	private String opt2;

	@ApiModelProperty(value = "条件字段名称")
	private String columnDbname;

	@ApiModelProperty(value = "条件字段类型")
	private Integer columnType;

	@ApiModelProperty(value = "展示类型")
	private Integer showType;

	@ApiModelProperty(value = "展示名称")
	private String showName;

	@ApiModelProperty(value = "多选数组")
	private String fixedDownBoxValue;

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