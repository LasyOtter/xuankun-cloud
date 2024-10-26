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
 * @since 1.0.0 2022-09-17
 */
@Data
@ApiModel(value = "")
public class SchemeProductInfoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "主键")
	private Integer id;

	@ApiModelProperty(value = "方案ID")
	private Integer schemeId;

	@ApiModelProperty(value = "产品型号ID")
	private Integer productModelId;

	@ApiModelProperty(value = "产品型号")
	private String productModel;

	@ApiModelProperty(value = "产品型号名称")
	private String productModelName;

	@ApiModelProperty(value = "创建人")
	private String creator;

	@ApiModelProperty(value = "创建时间")
	private LocalDateTime createDate;

	@ApiModelProperty(value = "修改人")
	private String modifiedBy;

	@ApiModelProperty(value = "修改日期")
	private LocalDateTime modifiedDate;

	@ApiModelProperty(value = "逻辑删除")
	private Integer isDel;


}