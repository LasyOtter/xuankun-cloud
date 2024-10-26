package com.xuankun.workorder.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


/**
 * 
 * 运维方案
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-09-15
 */
@Data
@ApiModel(value = "运维方案")
public class OperationSchemeDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "运维方案主键")
	private Integer id;

	@ApiModelProperty(value = "运维方案名称")
	private String schemeName;

	@ApiModelProperty(value = "运维类型")
	private String operationType;

	@ApiModelProperty(value = "运维说明")
	private String schemeDescription;

	@ApiModelProperty(value = "创建人")
	private String creator;

	@ApiModelProperty(value = "创建时间")
	private LocalDateTime createDate;

	@ApiModelProperty(value = "方案图示")
	private String schemeLllustration;

	@ApiModelProperty(value = "组织类型id")
	private Integer organizationTypeId;

	@ApiModelProperty(value = "组织类型")
	private String organizationType;

	@ApiModelProperty(value = "运维执行组织id")
	private Integer executorOfOrganizationId;

	@ApiModelProperty(value = "运维执行组织")
	private String executorOfOrganization;

	/**
	 * 使用产品型号id
	 */
	@ApiModelProperty(value = "使用产品型号id")
	private Integer productModelId;

	@ApiModelProperty(value = "使用产品型号列表")
	private List<SchemeProductInfoDTO> productInfos;

	@ApiModelProperty(value = "审批级别")
	private String approvalLevel = "一级审批";

	/**
	 * 第一审批组织类型id
	 */
	@ApiModelProperty(value = "第一审批组织类型id")
	private Integer firstOrgTypeId;

	@ApiModelProperty(value = "第一审批角色id")
	private Integer firstApprovalRoleId;

	@ApiModelProperty(value = "第一审批角色组织id")
	private Integer firstOrganizationId;

	@ApiModelProperty(value = "第一审批角色组织")
	private String firstOrganization;

	@ApiModelProperty(value = "第一审批角色")
	private String firstApprovalRole;

	/**
	 * 第二审批组织类型id
	 */
	@ApiModelProperty(value = "第二审批组织类型id")
	private Integer secondOrgTypeId;

	@ApiModelProperty(value = "第二审批角色id")
	private Integer secondApprovalRoleId;

	@ApiModelProperty(value = "第二审批角色组织id")
	private Integer secondOrganizationId;

	@ApiModelProperty(value = "第二审批角色组织")
	private String secondOrganization;

	@ApiModelProperty(value = "第二审批角色")
	private String secondApprovalRole;

	/**
	 * 第三审批组织类型id
	 */
	@ApiModelProperty(value = "第三审批组织类型id")
	private Integer thirdOrgTypeId;

	@ApiModelProperty(value = "第三审批角色id")
	private Integer thirdApprovalRoleId;

	@ApiModelProperty(value = "第三审批角色组织id")
	private Integer thirdOrganizationId;

	@ApiModelProperty(value = "第三审批组织")
	private String thirdOrganization;

	@ApiModelProperty(value = "第三审批角色")
	private String thirdApprovalRole;

	@ApiModelProperty(value = "审批状态:0:未审核;1:第一审核人审批;2:第二审核人审批;3:第三审核人审批;4:已审批")
	private int approvalState;

	@ApiModelProperty(value = "是否需要验收")
	private Integer isCheck;

	@ApiModelProperty(value = "验收方式")
	private String acceptanceMethod;

	@ApiModelProperty(value = "自动验收设置")
	private String autoAcceptanceSettings;

	@ApiModelProperty(value = "方案启用:0:禁用 1:启用")
	private int enableCheme = 0;

	@ApiModelProperty(value = "方案生效日期")
	private String effectiveDate;

	@ApiModelProperty(value = "方案有效期")
	private String termOfValidity;

	@ApiModelProperty(value = "修改人")
	private String modifiedBy;

	@ApiModelProperty(value = "修改日期")
	private LocalDateTime modifiedDate;

	@ApiModelProperty(value = "逻辑删除")
	private Integer isDel;

	/**
	 * 方案组ID
	 */
	@ApiModelProperty(value = "方案组ID")
	private Integer schemeGroupId;
	/**
	 * 拓展信息用于保存JSON
	 */
	@ApiModelProperty(value = "拓展信息用于保存JSON")
	private String schemeExtendInfo;

	@ApiModelProperty(value = "执行角色ID")
	private Integer executorRoleId;

	@ApiModelProperty(value = "执行角色")
	private String executorRole;
	/**
	 * 验收组织类型ID
	 */
	@ApiModelProperty(value = "验收组织类型ID")
	private Integer accepterOrgTypeId;
	/**
	 * 验收组织ID
	 */
	@ApiModelProperty(value = "验收组织ID")
	private Integer accepterOrgId;
	/**
	 * 验收组织
	 */
	@ApiModelProperty(value = "验收组织")
	private String accepterOrg;
	/**
	 * 验收角色id
	 */
	@ApiModelProperty(value = "验收角色id")
	private Integer accepterRoleId;
	/**
	 * 验收角色
	 */
	@ApiModelProperty(value = "验收角色")
	private String accepterRole;
}