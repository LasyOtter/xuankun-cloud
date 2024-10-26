package com.xuankun.workorder.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户权限表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-11-07
 */
@Data
@TableName("wf_user_role")
public class WfUserRoleEntity {

    /**
     * 主键
     */
    @TableId(type= IdType.AUTO)
	private Integer id;
    /**
     * 派单系统用户ID
     */
	private Integer userId;
    /**
     * 派单系统角色ID
     */
	private Integer roleId;
    /**
     * 派单系统区域ID
     */
    private Integer regionId;
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
     * 逻辑删除标志
     */
    @TableLogic
	private Integer delFlag;
}