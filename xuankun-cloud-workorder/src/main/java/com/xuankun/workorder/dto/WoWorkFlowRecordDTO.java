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
@ApiModel(value = "")
public class WoWorkFlowRecordDTO implements Serializable {
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

	@ApiModelProperty(value = "操作时间")
	private LocalDateTime operationTime;

	@ApiModelProperty(value = "创建人")
	private String creator;

	@ApiModelProperty(value = "创建时间")
	private LocalDateTime createDate;

	@ApiModelProperty(value = "修改人")
	private String modifiedBy;

	@ApiModelProperty(value = "修改时间")
	private LocalDateTime modifedDate;

	@ApiModelProperty(value = "逻辑删除")
	private Integer isDel;
	@ApiModelProperty(value = "执行人ID")
	private Integer executorUserId;
	@ApiModelProperty(value = "原因")
	private String reason;
	@ApiModelProperty(value = "备注")
	private String remark;
}