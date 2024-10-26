package com.xuankun.workorder.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-11-15
 */
@Data
@TableName("wf_user_superior")
public class WfUserSuperiorEntity {

    /**
     * 主键
     */
    @TableId(type= IdType.AUTO)
	private Integer id;
    /**
     * 用户ID
     */
	private Integer userId;
    /**
     * 上级ID
     */
	private Integer parentUserId;
    /**
     * 组织ID
     */
	private Integer orgId;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 是否直属：0：否；1：是
     */
    private int isDirectly;
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