package com.xuankun.workorder.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 流程实例关联表单
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-11
 */
@Entity
@Table(name = "wf_deploy_form")
@Data
@TableName("wf_deploy_form")
public class WfDeployFormEntity {

    /**
     * 流程表单实例主键
     */
    @Id
    @TableId(type= IdType.AUTO)
	private Integer id;
    /**
     * 表单id
     */
	private Long formId;
    /**
     * 节点Key
     */
	private Integer processId;
    /**
     * 节点名称
     */
	private Integer nodeId;
    /**
     * 表单内容
     */
	private String content;
    /**
     * 工单主键
     */
	private Integer workOrderId;
    /**
     * 工单号
     */
	private String workOrderCode;
    /**
     * 是否通用：通用表单不用保存到工单里面去  0：不通用；1：通用
     */
    private boolean inCommonUse;
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
     * 删除标志（0代表存在 1代表删除）
     */
    @TableLogic
    private int delFlag;
}