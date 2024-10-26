package com.xuankun.workorder.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 表单分组
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-14
 */
@Entity
@Table(name = "wf_form_group")
@Data
@TableName("wf_form_group")
public class WfFormGroupEntity {

    /**
     * 表单分组主键
     */
    @Id
    @TableId(type= IdType.AUTO)
	private Integer id;
    /**
     * 表单分组名称
     */
	private String groupName;
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