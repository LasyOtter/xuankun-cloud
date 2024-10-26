package com.xuankun.workorder.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xuankun.workorder.enums.WorkOrderStateEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;


/**
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-09-15
 */
@ApiModel(value = "工单")
public class WorkOrderDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "工单ID")
	private Integer id;

	@ApiModelProperty(value = "工单号")
	private String woCode;

	@ApiModelProperty(value = "工单描述")
	private String woDescription;

	@ApiModelProperty(value = "工单状态:0:待修改 1:待申请审批 2:待接单 3:待填单  4:待执行审批 5:待执行 6:执行中 7:待验收 8:已完成 9:已取消 10:已失败 11:待评价")
	private Integer woState;

	@ApiModelProperty(value = "工单状态::0:待修改 1:待申请审批 2:待接单 3:待填单  4:待执行审批 5:待执行 6:执行中 7:待验收 8:已完成 9:已取消 10:已失败 11:待评价")
	private String woStateName;

	@ApiModelProperty(value = "运维方案ID")
	private int schemeId;

	@ApiModelProperty(value = "运维方案")
	private String schemeName;

	@ApiModelProperty(value = "提交时间")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime submissionTime;

	@ApiModelProperty(value = "计划执行时间")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm")
	private LocalDateTime plannedExecutionTime;

	@ApiModelProperty(value = "执行角色ID")
	private Integer executorRoleId;

	@ApiModelProperty(value = "执行角色")
	private String executorRole;

	@ApiModelProperty(value = "创建人")
	private String creator;

	@ApiModelProperty(value = "创建时间")
	private LocalDateTime createDate;

	@ApiModelProperty(value = "修改人")
	private String modifiedBy;

	@ApiModelProperty(value = "修改时间")
	private LocalDateTime modifiedDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWoCode() {
		return woCode;
	}

	public void setWoCode(String woCode) {
		this.woCode = woCode;
	}

	public String getWoDescription() {
		return woDescription;
	}

	public void setWoDescription(String woDescription) {
		this.woDescription = woDescription;
	}

	public Integer getWoState() {
		return woState;
	}

	public void setWoState(Integer woState) {
		this.woState = woState;
	}

	public String getWoStateName() {
		if(woState != null && woState > 0){
			return WorkOrderStateEnum.getEnumName(this.woState);
		}
		return woStateName;
	}

	public void setWoStateName(String woStateName) {
		if(woState != null && woState > 0){
			this.woStateName = WorkOrderStateEnum.getEnumName(this.woState);
		}else {
			this.woStateName = woStateName;
		}
	}

	public int getSchemeId() {
		return schemeId;
	}

	public void setSchemeId(int schemeId) {
		this.schemeId = schemeId;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public LocalDateTime getSubmissionTime() {
		return submissionTime;
	}

	public void setSubmissionTime(LocalDateTime submissionTime) {
		this.submissionTime = submissionTime;
	}

	public LocalDateTime getPlannedExecutionTime() {
		return plannedExecutionTime;
	}

	public void setPlannedExecutionTime(LocalDateTime plannedExecutionTime) {
		this.plannedExecutionTime = plannedExecutionTime;
	}

	public Integer getExecutorRoleId() {
		return executorRoleId;
	}

	public void setExecutorRoleId(Integer executorRoleId) {
		this.executorRoleId = executorRoleId;
	}

	public String getExecutorRole() {
		return executorRole;
	}

	public void setExecutorRole(String executorRole) {
		this.executorRole = executorRole;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	@ApiModelProperty(value = "逻辑删除")
	private Integer delFlag;

	public String getSchemeExtendInfo() {
		return schemeExtendInfo;
	}

	public void setSchemeExtendInfo(String schemeExtendInfo) {
		this.schemeExtendInfo = schemeExtendInfo;
	}

	@ApiModelProperty(value = "拓展信息用于保存JSON")
	private String schemeExtendInfo;

	/**
	 * 执行角色组织id
	 */
	@ApiModelProperty(value = "执行角色组织id")
	private Integer executorOrgId;

	public Integer getExecutorOrgId() {
		return executorOrgId;
	}

	public void setExecutorOrgId(Integer executorOrgId) {
		this.executorOrgId = executorOrgId;
	}

	public Integer getExecutorUserId() {
		return executorUserId;
	}

	public void setExecutorUserId(Integer executorUserId) {
		this.executorUserId = executorUserId;
	}

	public Integer getExecutorUser() {
		return executorUser;
	}

	public void setExecutorUser(Integer executorUser) {
		this.executorUser = executorUser;
	}

	public Integer getExecutorOrgTypeId() {
		return executorOrgTypeId;
	}

	public void setExecutorOrgTypeId(Integer executorOrgTypeId) {
		this.executorOrgTypeId = executorOrgTypeId;
	}

	public Integer getExecutorOrgType() {
		return executorOrgType;
	}

	public void setExecutorOrgType(Integer executorOrgType) {
		this.executorOrgType = executorOrgType;
	}

	/**
	 * 执行人id
	 */
	@ApiModelProperty(value = "执行人id")
	private Integer executorUserId;
	/**
	 * 执行人
	 */
	@ApiModelProperty(value = "执行人")
	private Integer executorUser;
	/**
	 * 执行组织类型id
	 */
	@ApiModelProperty(value = "执行组织类型id")
	private Integer executorOrgTypeId;
	/**
	 * 执行组织类型
	 */
	@ApiModelProperty(value = "执行组织类型")
	private Integer executorOrgType;

	@ApiModelProperty(value = "验收人ID")
	private Integer accepterUserId;

	public Integer getAccepterUserId() {
		return accepterUserId;
	}

	public void setAccepterUserId(Integer accepterUserId) {
		this.accepterUserId = accepterUserId;
	}

	public String getAccepterUser() {
		return accepterUser;
	}

	public void setAccepterUser(String accepterUser) {
		this.accepterUser = accepterUser;
	}

	@ApiModelProperty(value = "验收人")
	private String accepterUser;

	/**
	 * 项目ID
	 */
	@Getter
	@Setter
	@ApiModelProperty(value = "项目ID")
	private Integer projectId;
	/**
	 * 项目名称
	 */
	@Getter
	@Setter
	@ApiModelProperty(value = "项目名称")
	private String projectName;
	@Getter
	@Setter
	@ApiModelProperty(value = "设备ID")
	private Integer deviceId;
	@Getter
	@Setter
	@ApiModelProperty(value = "表单ID")
	private Long formId;
	@Getter
	@Setter
	@ApiModelProperty(value = "表单名称")
	private String formName;
	/**
	 * 申请人id
	 */
	@Getter
	@Setter
	@ApiModelProperty(value = "申请人id")
	private Integer applicantId;
	/**
	 * 申请人
	 */
	@Getter
	@Setter
	@ApiModelProperty(value = "申请人")
	private String applicant;

	/**
	 * 申请人角色id
	 */
	@Getter
	@Setter
	@ApiModelProperty(value = "申请人角色id")
	private Integer applicantRoleId;
	/**
	 * 申请人角色
	 */
	@Getter
	@Setter
	@ApiModelProperty(value = "申请人角色")
	private String applicantRoleName;

	@Getter
	@Setter
	@ApiModelProperty(value = "用户ID")
    private int userId;

	@Getter
	@Setter
	@ApiModelProperty(value = "是否审批：0-未审批;1-已审批;")
	private int isApproval;

	@Getter
	@Setter
	@ApiModelProperty(value = "审批意见是否必填")
	private boolean remarkIsRequired;

	@Getter
	@Setter
	@ApiModelProperty(value = "单据状态")
	private String orderState;

	@Getter
	@Setter
	@ApiModelProperty(value = "区域ID")
	private Integer regionId;

	@Getter
	@Setter
	@ApiModelProperty(value = "流程审批ID")
	private Integer approvalId;
}