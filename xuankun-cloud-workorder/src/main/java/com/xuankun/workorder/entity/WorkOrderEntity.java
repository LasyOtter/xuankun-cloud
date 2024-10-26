package com.xuankun.workorder.entity;

import com.baomidou.mybatisplus.annotation.*;
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
@TableName("t_work_order")
@Entity
@Table(name = "t_work_order")
public class WorkOrderEntity {

    /**
     * 工单ID
     */
    @Id
    @TableId(type= IdType.AUTO)
	private Integer id;
    /**
     * 工单号
     */
	private String woCode;
    /**
     * 工单描述
     */
	private String woDescription;
    /**
     * 工单状态
     */
	private Integer woState = 0;
    /**
     * 运维方案ID
     */
	private int schemeId;
    /**
     * 运维方案
     */
	private String schemeName;
    /**
     * 提交时间
     */
	private LocalDateTime submissionTime;
    /**
     * 计划执行时间
     */
	private LocalDateTime plannedExecutionTime;
    /**
     * 执行角色ID
     */
	private Integer executorRoleId;
    /**
     * 执行角色
     */
	private String executorRole;
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
     * 修改人
     */
	private String modifiedBy;
    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime modifiedDate;
    /**
     * 逻辑删除
     */
    @TableLogic
	private Integer delFlag;
    /**
     * 拓展信息用于保存JSON
     */
    private String schemeExtendInfo;
    /**
     * 执行角色组织id
     */
    private Integer executorOrgId;
    /**
     * 执行人id
     */
    private Integer executorUserId;
    /**
     * 执行人
     */
    private Integer executorUser;
    /**
     * 执行组织类型id
     */
    private Integer executorOrgTypeId;
    /**
     * 执行组织类型
     */
    private Integer executorOrgType;
    /**
     * 验收人ID
     */
    private Integer accepterUserId;
    /**
     * 验收人
     */
    private String accepterUser;
    /**
     * 项目ID
     */
    private Integer projectId;
    /**
     * 项目名称
     */
    private String projectName;

    private Integer deviceId;
    /**
     * 表单id
     */
    private Long formId;
    /**
     * 表单名称
     */
    private String formName;
    /**
     * 申请人id
     */
    private Integer applicantId;
    /**
     * 申请人
     */
    private String applicant;
    /**
     * 区域id
     */
    private Integer regionId;
}