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
 * @since 1.0.0 2022-10-12
 */
@Entity
@Table(name = "wf_process_user_approval")
@Data
@TableName("wf_process_user_approval")
public class WfProcessUserApprovalEntity {

    /**
     * ID
     */
    @Id
    @TableId(type= IdType.AUTO)
	private Integer id;
    /**
     * 流程ID
     */
	private Long processId;
    /**
     * 表单ID
     */
	private Long formId;
    /**
     * 父节点ID
     */
	private Integer parentNodeId;
    /**
     * 节点ID
     */
	private Integer nodeId;
    /**
     * 工单ID
     */
    private Integer orderId;
    /**
     * 角色/用户ID
     */
	private Integer roleId;
    /**
     * 角色/用户
     */
	private String roleName;
    /**
     * 审批用户ID
     */
	private Integer userId;
    /**
     * 是否审批/申请:0:否；1：是
     */
	private Integer isApproval;
    /**
     * 0：已申请/待审批；1：已审批/已申请
     */
	private Integer approvalState;
    /**
     * 审批操作类型：0：通过；1：驳回；2：退回；3：作废；4：取消
     */
	private Integer approvalType;
    /**
     * 节点类型：0：申请；1：审批
     */
    private Integer nodeType;
    /**
     * 操作人类型：0:所有人;1：用户；2：角色
     */
    private Integer operatorType;
    /*
     * 备注
     */
    private String remark;
    /**
     * 审批节点用户ID
     */
    private Integer nodeUserId;
    /**
     * 
     */
	private String creator;
    /**
     * 
     */
    @TableField(fill = FieldFill.INSERT)
	private LocalDateTime createDate;
    /**
     * 
     */
	private String updator;
    /**
     * 
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updateDate;

    /**
     * 逻辑删除
     */
    @TableLogic
    private Integer delFlag;
}