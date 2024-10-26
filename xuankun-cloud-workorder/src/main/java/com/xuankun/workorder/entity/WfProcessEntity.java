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
@Table(name = "wf_process")
@Data
@TableName("wf_process")
public class WfProcessEntity {

    /**
     * 主键
     */
    @Id
    @TableId(type= IdType.AUTO)
	private Long id;
    /**
     * 表单ID
     */
	private Long formId;
    /**
     * 流程深度
     */
	private Integer directorMaxLevel;
    /**
     * 流程节点信息
     */
	private String processNode;
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