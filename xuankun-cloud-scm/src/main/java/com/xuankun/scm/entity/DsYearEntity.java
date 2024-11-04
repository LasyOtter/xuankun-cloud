package com.xuankun.scm.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xuankun.framework.mybatis.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "年份表",description = "")
@TableName("ds_year")
public class DsYearEntity extends BaseEntity implements Serializable,Cloneable{
    /** 年份代码 */
    @ApiModelProperty(name = "年份代码",notes = "")
    private String yearCode ;
    /** 年份名称 */
    @ApiModelProperty(name = "年份名称",notes = "")
    private String yearName ;
    /** 年份描述 */
    @ApiModelProperty(name = "年份描述",notes = "")
    private String yearDesc ;
    /** 排序 */
    @ApiModelProperty(name = "排序",notes = "")
    private Integer sort ;
    /** 状态  0：停用   1：正常 */
    @ApiModelProperty(name = "状态  0：停用   1：正常",notes = "")
    private int status ;
}
