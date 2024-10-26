package com.xuankun.workorder.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;


/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-09-15
 */
@Data
@ApiModel(value = "")
public class SchemeGroupDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "运维方案组别ID")
	private Integer id;

	@ApiModelProperty(value = "运维方案组别")
	private String schemeGroup;

	@ApiModelProperty(value = "创建人")
	private String creator;

	@ApiModelProperty(value = "创建时间")
	private LocalDateTime createDate;

	@ApiModelProperty(value = "修改人")
	private String modifiedBy;

	@ApiModelProperty(value = "修改时间")
	private LocalDateTime modifiedDate;

	@ApiModelProperty(value = "逻辑删除")
	private Integer isDel;


}