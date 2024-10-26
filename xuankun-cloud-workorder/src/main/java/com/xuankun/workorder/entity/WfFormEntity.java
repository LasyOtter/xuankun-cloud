package com.xuankun.workorder.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 流程表单信息表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-11
 */
@Entity
@Table(name = "wf_form")
@Data
@TableName("wf_form")
public class WfFormEntity {

    /**
     * 表单主键
     */
    @Id
    @TableId(type= IdType.AUTO)
	private Long formId;
    /**
     * 流程主键
     */
	private Long processId;
    /**
     * 表单名称
     */
	private String formName;
    /**
     * 表单内容
     */
	private String content;
    /**
     * 表单分组ID
     */
    private Integer groupId;
    /**
     * 是否通用：通用表单不用保存到工单里面去  0：不通用；1：通用
     */
    private int inCommonUse;
    /**
     * 创建者
     */
	private String createBy;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
	private LocalDateTime createTime;
    /**
     * 更新者
     */
	private String updateBy;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updateTime;
    /**
     * 备注
     */
	private String remark;
    /**
     * 删除标志（0代表存在 1代表删除）
     */
    @TableLogic
	private int delFlag;
}