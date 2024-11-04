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
public class DsWaverangeEntity extends BaseEntity implements Serializable,Cloneable{
    /** 波段代码 */
    @ApiModelProperty(name = "波段代码",notes = "")
    private String waverangeCode ;
    /** 波段名称 */
    @ApiModelProperty(name = "波段名称",notes = "")
    private String waverangeName ;
    /** 波段描述 */
    @ApiModelProperty(name = "波段描述",notes = "")
    private String waverangeDesc ;
    /** 排序 */
    @ApiModelProperty(name = "排序",notes = "")
    private Integer sort ;
    /** 状态  0：停用   1：正常 */
    @ApiModelProperty(name = "状态  0：停用   1：正常",notes = "")
    private int status ;
}
