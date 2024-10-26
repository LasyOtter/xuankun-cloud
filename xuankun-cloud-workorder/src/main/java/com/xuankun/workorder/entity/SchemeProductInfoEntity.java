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
 * @since 1.0.0 2022-09-17
 */
@Data
@TableName("t_scheme_product_info")
@Entity
@Table(name = "t_scheme_product_info")
public class SchemeProductInfoEntity {

    /**
     * 主键
     */
    @Id
    @TableId(type= IdType.AUTO)
	private Integer id;
    /**
     * 方案ID
     */
	private Integer schemeId;
    /**
     * 产品型号ID
     */
	private Integer productModelId;
    /**
     * 产品型号
     */
	private String productModel;
    /**
     * 产品型号名称
     */
    private String productModelName;
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
     * 修改日期
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime modifiedDate;
    /**
     * 逻辑删除
     */
	private Integer isDel;
}