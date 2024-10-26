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
@ApiModel(value = "方案审核表")
public class SchemeApprovalDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "审核主键")
	private Integer id;

	@ApiModelProperty(value = "方案ID")
	private Integer schemeId;

	@ApiModelProperty(value = "审核状态")
	private Integer approvalState;

	@ApiModelProperty(value = "第一审核人")
	private String firstReviewedBy;

	@ApiModelProperty(value = "第一审核时间")
	private LocalDateTime firstReviewedDate;

	@ApiModelProperty(value = "第一审核人ID")
	private String firstReviewedUserId;

	@ApiModelProperty(value = "第二审核人")
	private String secondReviewedBy;

	@ApiModelProperty(value = "第二审核时间")
	private LocalDateTime secondReviewedDate;

	@ApiModelProperty(value = "第二审核人ID")
	private String secondReviewedUserId;

	@ApiModelProperty(value = "第三审核人")
	private String thirdReviewedBy;

	@ApiModelProperty(value = "第三审核时间")
	private LocalDateTime thirdReviewedDate;

	@ApiModelProperty(value = "第三审核人ID")
	private String thirdReviewedUserId;

	@ApiModelProperty(value = "下一步")
	private int nextStep;

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