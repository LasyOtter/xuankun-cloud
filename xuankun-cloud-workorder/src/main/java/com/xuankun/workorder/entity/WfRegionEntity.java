package com.xuankun.workorder.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-30
 */
@Entity
@Table(name = "wf_region")
@Data
@TableName("wf_region")
public class WfRegionEntity {

    /**
     * 主键
     */
    @Id
    @TableId(type= IdType.AUTO)
	private Integer id;
    /**
     * 地区编码
     */
	private String regionCode;
    /**
     * 地区名称
     */
	private String regionName;
    /**
     * 上一级
     */
	private Integer parentId;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
	private LocalDateTime createDate;
    /**
     * 创建人
     */
	private String creator;
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
	private Boolean delFlag;
}