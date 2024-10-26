package com.xuankun.workorder.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 表单分组
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-14
 */
@Data
@ApiModel(value = "表单分组")
public class WfFormGroupDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "表单分组主键")
	private Integer id;

	@ApiModelProperty(value = "表单分组名称")
	private String groupName;

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