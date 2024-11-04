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
@ApiModel(value = "季节表",description = "")
@TableName("ds_season")
public class DsSeasonEntity  extends BaseEntity implements Serializable,Cloneable{
    /** 季节代码 */
    @ApiModelProperty(name = "季节代码",notes = "")
    private String seasonCode ;
    /** 季节名称 */
    @ApiModelProperty(name = "季节名称",notes = "")
    private String seasonName ;
    /** 季节描述 */
    @ApiModelProperty(name = "季节描述",notes = "")
    private String seasonDesc ;
    /** 排序 */
    @ApiModelProperty(name = "排序",notes = "")
    private Integer sort ;
    /** 状态  0：停用   1：正常 */
    @ApiModelProperty(name = "状态  0：停用   1：正常",notes = "")
    private int status ;
}
