package com.xuankun.workorder.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 流程表单字段权限表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-19
 */
@Entity
@Table(name = "wf_form_field")
@Data
@TableName("wf_form_field")
public class WfFormFieldEntity {

    /**
     * 主键
     */
    @Id
    @TableId(type= IdType.AUTO)
	private Integer id;
    /**
     * 流程ID
     */
	private long processId;
    /**
     * 节点ID
     */
	private Integer nodeId;
    /**
     * 流程表单ID
     */
	private long formId;
    /**
     * 字段关键字
     */
	private String field;
    /**
     * 字段名称
     */
	private String fieldName;
    /**
     * 是否必填
     */
	private boolean required;
    /**
     * 可选操作：editable：可编辑  readonly：只读  hidden：隐藏
     */
	private String operation;
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