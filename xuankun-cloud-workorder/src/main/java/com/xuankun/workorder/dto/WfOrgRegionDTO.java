package com.xuankun.workorder.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 组织区域对照表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-11-07
 */
@Data
@ApiModel(value = "组织区域对照表")
public class WfOrgRegionDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "主键")
	private Integer id;

	@ApiModelProperty(value = "组织ID")
	private Integer orgId;

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

	@ApiModelProperty(value = "逻辑删除标识")
	private Integer delFlag;


}