package com.xuankun.workorder.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 组织区域对照表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-11-07
 */
@Data
@TableName("wf_org_region")
public class WfOrgRegionEntity {

    /**
     * 主键
     */
    @TableId(type= IdType.AUTO)
	private Integer id;
    /**
     * 组织ID
     */
	private Integer orgId;
    /**
     * 区域ID
     */
	private Integer regionId;
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