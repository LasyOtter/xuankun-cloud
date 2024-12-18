package com.xuankun.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 字段类型管理
 *
 * @author jimy
 * 
 */
@Data
@TableName("gen_field_type")
public class FieldTypeEntity {
    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 字段类型
     */
    private String columnType;
    /**
     * 属性类型
     */
    private String attrType;
    /**
     * 属性包名
     */
    private String packageName;
    /**
     * 创建时间
     */
    private Date createTime;
}