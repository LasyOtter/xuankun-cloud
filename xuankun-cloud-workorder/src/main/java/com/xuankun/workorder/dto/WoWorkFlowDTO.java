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
 * @since 1.0.0 2022-09-19
 */
@Data
@ApiModel(value = "工单流程审核")
public class WoWorkFlowDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "主键")
	private Integer id;

	@ApiModelProperty(value = "工单ID")
	private Integer workOrderId;

	@ApiModelProperty(value = "工单号")
	private String workOrderCode;

	@ApiModelProperty(value = "状态")
	private Integer state;

	@ApiModelProperty(value = "状态名称")
	private String stateName;

	@ApiModelProperty(value = "执行时间")
	private LocalDateTime executeTime;

	@ApiModelProperty(value = "原因")
	private String reason;

	@ApiModelProperty(value = "备注")
	private String remark;

	@ApiModelProperty(value = "当前步骤")
	private Integer curStep;

	@ApiModelProperty(value = "下一步骤")
	private Integer nextStep;

	@ApiModelProperty(value = "上一步骤")
	private Integer lastStep;

	@ApiModelProperty(value = "执行人ID")
	private Integer executorUserId;

	@ApiModelProperty(value = "创建人")
	private String creator;

	@ApiModelProperty(value = "创建时间")
	private LocalDateTime createDate;

	@ApiModelProperty(value = "修改人")
	private String modifiedBy;

	@ApiModelProperty(value = "修改时间")
	private LocalDateTime modifiedDate;

	@ApiModelProperty(value = "逻辑删除")
	private String isDel;


}