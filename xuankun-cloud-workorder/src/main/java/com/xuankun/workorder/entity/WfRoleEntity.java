package com.xuankun.workorder.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 角色表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-31
 */
@Entity
@Table(name = "wf_role")
@Data
@TableName("wf_role")
public class WfRoleEntity {

    /**
     * 主键
     */
    @Id
    @TableId(type= IdType.AUTO)
	private Integer id;
    /**
     * 角色名称
     */
	private String roleName;
    /**
     * 创建者
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