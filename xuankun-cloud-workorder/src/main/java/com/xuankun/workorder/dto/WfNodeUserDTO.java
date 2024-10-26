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
public class WfNodeUserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "")
	private Integer id;

	@ApiModelProperty(value = "表单ID")
	private Long formId;

	@ApiModelProperty(value = "")
	private Integer parentNodeId;

	@ApiModelProperty(value = "")
	private Integer nodeId;

	@ApiModelProperty(value = "")
	private String roleName;

	@ApiModelProperty(value = "")
	private Integer roleId;

	@ApiModelProperty(value = "")
	private Integer type;

	@ApiModelProperty(value = "")
	private String creator;

	@ApiModelProperty(value = "")
	private Date createDate;

	@ApiModelProperty(value = "")
	private String updator;

	@ApiModelProperty(value = "")
	private Date updateDate;

	@ApiModelProperty(value = "")
	private Integer processId;

	@ApiModelProperty(value = "逻辑删除")
	private Integer delFlag;
}