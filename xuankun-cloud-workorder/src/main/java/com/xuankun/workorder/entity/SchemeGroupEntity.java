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
 * @since 1.0.0 2022-09-15
 */
@Data
@TableName("t_scheme_group")
@Entity
@Table(name = "t_scheme_group")
public class SchemeGroupEntity {

    /**
     * 运维方案组别ID
     */
    @Id
    @TableId(type= IdType.AUTO)
	private Integer id;
    /**
     * 运维方案组别
     */
	private String schemeGroup;
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
	private String modifiedBy;
    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime modifiedDate;
    /**
     * 逻辑删除
     */
	private Integer isDel;
}