package com.xuankun.workorder.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 表单发起用户表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-20
 */
@Entity
@Table(name = "wf_form_user")
@Data
@TableName("wf_form_user")
public class WfFormUserEntity {

    /**
     * 主键
     */
    @Id
    @TableId(type= IdType.AUTO)
	private Integer id;
    /**
     * 表单ID
     */
	private Long formId;
    /**
     * 用户ID
     */
	private Integer userId;
    /**
     * 用户/角色
     */
    private String userName;
    /**
     * 类型：1：用户；2：角色
     */
    private int type = 1;
    /**
     * 组织ID
     */
	private Integer orgId;
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
     * 逻辑删除标识
     */
    @TableLogic
	private Integer delFlag;
}