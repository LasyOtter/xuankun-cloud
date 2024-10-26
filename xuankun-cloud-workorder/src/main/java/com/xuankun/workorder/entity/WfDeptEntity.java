package com.xuankun.workorder.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 部门表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-31
 */
@Entity
@Table(name = "wf_dept")
@Data
@TableName("wf_dept")
public class WfDeptEntity {

    /**
     * 部门id
     */
    @Id
    @TableId(type= IdType.AUTO)
	private Long id;
    /**
     * 部门名称
     */
	private String name;
    /**
     * 父部门id
     */
    @TableField(updateStrategy = FieldStrategy.IGNORED)
	private Long parentId;
    /**
     * 显示顺序
     */
	private Integer sort;
    /**
     * 负责人ID
     */
	private Long leaderUserId;
    /**
     * 负责人
     */
    private String leaderUserName;
    /**
     * 联系电话
     */
	private String phone;
    /**
     * 邮箱
     */
	private String email;
    /**
     * 部门状态（0正常 1停用）
     */
	private Integer status;
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
     * 更新者
     */
	private String updator;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updateDate;
    /**
     * 是否删除
     */
    @TableLogic
	private Boolean delFlag;
    /**
     * 租户编号/组织编号
     */
	private Long tenantId;
}