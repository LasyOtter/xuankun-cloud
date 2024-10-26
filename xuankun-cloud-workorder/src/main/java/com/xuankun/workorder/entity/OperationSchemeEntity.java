package com.xuankun.workorder.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-09-15
 */
@Data
@TableName("t_operation_scheme")
@Entity
@Table(name = "t_operation_scheme")
public class OperationSchemeEntity {

    /**
     * 运维方案主键
     */
    @Id
    @TableId(type= IdType.AUTO)
	private Integer id;
    /**
     * 运维方案名称
     */
	private String schemeName;
    /**
     * 运维类型
     */
	private String operationType;
    /**
     * 运维说明
     */
	private String schemeDescription;
    /**
     * 创建人
     */
	private String creator;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
	private LocalDateTime createDate;
    /**
     * 方案图示
     */
	private String schemeLllustration;
    /**
     * 组织类型id
     */
    private Integer organizationTypeId;
    /**
     * 组织类型
     */
	private String organizationType;
    /**
     * 运维执行组织id
     */
    private Integer executorOfOrganizationId;
    /**
     * 运维执行组织
     */
	private String executorOfOrganization;
    /**
     * 运维执行角色ID
     */
    private Integer executorRoleId;
    /**
     * 运维执行角色
     */
    private String executorRole;
    /**
     * 使用产品型号id
     */
    private Integer productModelId;
    /**
     * 使用产品型号
     */
	private String productModel;
    /**
     * 审批级别
     */
	private String approvalLevel;
    /**
     * 第一审批组织类型id
     */
    private Integer firstOrgTypeId;
    /**
     * 第一审批角色id
     */
    private Integer firstApprovalRoleId;
    /**
     * 第一审批组织id
     */
    private Integer firstOrganizationId;
    /**
     * 第一审批角色
     */
    private String firstApprovalRole;
    /**
     * 第二审批组织类型id
     */
    private Integer secondOrgTypeId;
    /**
     * 第二审批角色id
     */
    private Integer secondApprovalRoleId;
    /**
     * 第二审批角色组织id
     */
    private Integer secondOrganizationId;
    /**
     * 第二审批角色
     */
    private String secondApprovalRole;
    /**
     * 第三审批组织类型id
     */
    private Integer thirdOrgTypeId;
    /**
     * 第三审批角色id
     */
    private Integer thirdApprovalRoleId;
    /**
     * 第三审批角色组织id
     */
    private Integer thirdOrganizationId;
    /**
     * 第三审批角色
     */
    private String thirdApprovalRole;
    /**
     * 审核状态
     *
     */
    private int approvalState;
    /**
     * 是否需要验收
     */
	private Integer isCheck;
    /**
     * 验收方式
     */
	private String acceptanceMethod;
    /**
     * 自动验收设置
     */
	private String autoAcceptanceSettings;
    /**
     * 方案启用:0:禁用 1:启用
     */
	private int enableCheme = 1;
    /**
     * 方案生效日期
     */
	private String effectiveDate;
    /**
     * 方案有效期
     */
	private String termOfValidity;
    /**
     * 修改人
     */
	private String modifiedBy;
    /**
     * 修改日期
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime modifiedDate;
    /**
     * 逻辑删除
     */
	private Integer isDel;
    /**
     * 方案组ID
     */
    private Integer schemeGroupId;
    /**
     * 拓展信息用于保存JSON
     */
    private String schemeExtendInfo;
    /**
     * 验收组织类型ID
     */
    private Integer accepterOrgTypeId;
    /**
     * 验收组织ID
     */
    private Integer accepterOrgId;
    /**
     * 验收角色id
     */
    private Integer accepterRoleId;
}