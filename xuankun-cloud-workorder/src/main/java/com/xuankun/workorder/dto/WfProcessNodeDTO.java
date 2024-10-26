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
 * @since 1.0.0 2022-10-11
 */
@Data
@ApiModel(value = "流程节点信息")
public class WfProcessNodeDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "主键")
	private Integer id;

	@ApiModelProperty(value = "表单ID")
	private Long formId;

	@ApiModelProperty(value = "流程主键")
	private Long processId;

	@ApiModelProperty(value = "父节点主键")
	private Integer parentId;

	@ApiModelProperty(value = "节点名称")
	private String nodeName;

	@ApiModelProperty(value = "节点编码")
	private String nodeCode;

	@ApiModelProperty(value = "审批人为空时:1-自动审批通过;2-转交给审批管理员")
	private Integer noHanderAction;

	@ApiModelProperty(value = "审批人数:1-选一个人;2-选多个人")
	private Integer selectMode;

	@ApiModelProperty(value = "选择范围:1-全公司;2-指定成员;3-指定角色")
	private Integer selectRange;

	/**
	 * 审批人设置:1指定成员 2发起人自选 3发起人自己 4直属上级 5连续多级上级 6部门上级 7连续多级部门 8表单内区域控件对应审批人
	 */
	@ApiModelProperty(value = "审批人设置:1指定成员 2发起人自选 3发起人自己 4直属上级 5连续多级上级 6部门上级 7连续多级部门 8表单内区域控件对应审批人")
	private Integer setType;

	@ApiModelProperty(value = "节点类型")
	private Integer type;

	@ApiModelProperty(value = "条件优先级")
	private Integer priorityLevel;

	@ApiModelProperty(value = "允许发起人自选抄送人")
	private Integer ccSelfSelectFlag = 0;

	@ApiModelProperty(value = "审批终点--最高层主管数")
	private Integer directorLevel;

	@ApiModelProperty(value = "审批模式:1-依次审批;2-会签")
	private Integer examineMode;

	@ApiModelProperty(value = "审批终点-第N层主管")
	private Integer examineEndDirectorLevel;

	@ApiModelProperty(value = "当前审批是否通过校验")
	private Boolean error;

	@ApiModelProperty(value = "是否是条件节点")
	private int isConditionNode;

	@ApiModelProperty(value = "审批意见是否必填")
	private Boolean remarkIsRequired;

	@ApiModelProperty(value = "创建人")
	private String creator;

	@ApiModelProperty(value = "创建时间")
	private Date createDate;

	@ApiModelProperty(value = "修改人")
	private String updator;

	@ApiModelProperty(value = "修改时间")
	private Date updateDate;

	@ApiModelProperty(value = "逻辑删除")
	private Integer delFlag;

}