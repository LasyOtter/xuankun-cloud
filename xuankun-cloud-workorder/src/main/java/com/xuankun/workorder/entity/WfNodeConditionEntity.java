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
@Table(name = "wf_node_condition")
@Data
@TableName("wf_node_condition")
public class WfNodeConditionEntity {

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
     * 所属节点主键
     */
	private Integer nodeId;
    /**
     * 发起人
     */
	private Integer columnId;
    /**
     * 1:发起人;2其他
     */
	private Integer type;
    /**
     * 操作符
     */
	private String optType;
    /**
     * 左侧自定义内容
     */
	private String zdy1;
    /**
     * 右侧自定义内容
     */
	private String zdy2;
    /**
     * 左侧操作符
     */
	private String opt1;
    /**
     * 右侧操作符
     */
	private String opt2;
    /**
     * 条件字段名称
     */
	private String columnDbname;
    /**
     * 条件字段类型
     */
	private Integer columnType;
    /**
     * 展示类型
     */
	private Integer showType;
    /**
     * 展示名称
     */
	private String showName;
    /**
     * 多选数组
     */
	private String fixedDownBoxValue;
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