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
 * @since 1.0.0 2022-10-11
 */
@Entity
@Table(name = "wf_process_node")
@Data
@TableName("wf_process_node")
public class WfProcessNodeEntity {

    /**
     * 主键
     */
    @Id
    @TableId(type= IdType.AUTO)
	private Integer id;
    /**
     * 表单id
     */
    private Long formId;
    /**
     * 流程主键
     */
	private Long processId;
    /**
     * 父节点主键
     */
	private Integer parentId;
    /**
     * 节点名称
     */
	private String nodeName;
    /**
     * 节点编码
     */
	private String nodeCode;
    /**
     * 审批人为空时:1-自动审批通过;2-转交给审批管理员
     */
	private Integer noHanderAction;
    /**
     * 审批人数:1-选一个人;2-选多个人
     */
	private Integer selectMode;
    /**
     * 选择范围:1-全公司;2-指定成员;3-指定角色
     */
	private Integer selectRange;
    /**
     * 审批人设置:1-指定成员;2-主管;3-发起人自选;4-发起人自己;5-连续多级主管;
     */
	private Integer setType;
    /**
     * 节点类型
     */
	private Integer type;
    /**
     * 条件优先级
     */
	private Integer priorityLevel;
    /**
     * 允许发起人自选抄送人
     */
	private Integer ccSelfSelectFlag;
    /**
     * 审批终点--最高层主管数
     */
	private Integer directorLevel;
    /**
     * 审批模式:1-依次审批;2-会签
     */
	private Integer examineMode;
    /**
     * 审批终点-第N层主管
     */
	private Integer examineEndDirectorLevel;
    /**
     * 当前审批是否通过校验
     */
	private Integer error;
    /**
     * 是否是条件节点
     */
	private Integer isConditionNode;
    /**
     * 审批意见是否必填
     */
    private Boolean remarkIsRequired;
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
	private String updator;
    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updateDate;
    /**
     * 逻辑删除
     */
    @TableLogic
    private Integer delFlag;
}