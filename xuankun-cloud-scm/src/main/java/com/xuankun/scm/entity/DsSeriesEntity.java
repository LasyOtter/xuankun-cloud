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
@ApiModel(value = "系列表",description = "")
@TableName("ds_series")
public class DsSeriesEntity extends BaseEntity implements Serializable,Cloneable{
    /** 系列代码 */
    @ApiModelProperty(name = "系列代码",notes = "")
    private String seriesCode ;
    /** 系列名称 */
    @ApiModelProperty(name = "系列名称",notes = "")
    private String seriesName ;
    /** 系列描述 */
    @ApiModelProperty(name = "系列描述",notes = "")
    private String seriesDesc ;
    /** 排序 */
    @ApiModelProperty(name = "排序",notes = "")
    private Integer sort ;
    /** 状态  0：停用   1：正常 */
    @ApiModelProperty(name = "状态  0：停用   1：正常",notes = "")
    private int status ;
}
