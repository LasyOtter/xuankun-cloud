package com.xuankun.workorder.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-12
 */
@Data
@ApiModel(value = "")
public class WfProcessUserApprovalDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "ID")
	private Integer id;

	@ApiModelProperty(value = "流程ID")
	private Long processId;

	@ApiModelProperty(value = "表单ID")
	private Long formId;

	@ApiModelProperty(value = "父节点ID")
	private Integer parentNodeId;

	@ApiModelProperty(value = "节点ID")
	private Integer nodeId;
	@ApiModelProperty(value = "工单ID")
	private Integer orderId;
	@ApiModelProperty(value = "角色/用户ID")
	private Integer roleId;

	@ApiModelProperty(value = "角色/用户")
	private String roleName;

	@ApiModelProperty(value = "审批用户ID")
	private Integer userId;

	@ApiModelProperty(value = "是否审批/申请:0:否；1：是")
	private Integer isApproval;

	@ApiModelProperty(value = "0：已申请/待审批；1：已审批/已申请")
	private Integer approvalState;

	@ApiModelProperty(value = "审批操作类型：0：通过；1：驳回；2：退回；3：作废；4：取消")
	private Integer approvalType;

	@ApiModelProperty(value = "备注")
	private String remark;

	/**
	 * 审批节点用户ID
	 */
	@ApiModelProperty(value = "审批节点用户ID")
	private Integer nodeUserId;

	@ApiModelProperty(value = "")
	private String creator;

	@ApiModelProperty(value = "")
	private Date createDate;

	@ApiModelProperty(value = "")
	private String updator;

	@ApiModelProperty(value = "")
	private Date updateDate;

	@ApiModelProperty(value = "逻辑删除")
	private Integer delFlag;

	@ApiModelProperty(value = "节点类型：0：申请；1：审批")
	private int nodeType;
	@ApiModelProperty(value = "操作人类型：0：用户；2：角色")
	private Integer operatorType;
}