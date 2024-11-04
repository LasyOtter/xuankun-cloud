package com.xuankun.scm.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xuankun.framework.mybatis.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@ApiModel(value = "品类表",description = "")
@EqualsAndHashCode(callSuper = false)
@TableName("ds_category")
public class DsCategoryEntity  extends BaseEntity implements Serializable,Cloneable{
    /** 品类代码 */
    @ApiModelProperty(name = "品类代码",notes = "")
    private String categoryCode ;
    /** 品类名称 */
    @ApiModelProperty(name = "品类名称",notes = "")
    private String categoryName ;
    /** 品类描述 */
    @ApiModelProperty(name = "品类描述",notes = "")
    private String categoryDesc ;
    /** 父品类ID */
    @ApiModelProperty(name = "父品类ID",notes = "")
    private Integer pId ;
    /** 父品类CODE */
    @ApiModelProperty(name = "父品类CODE",notes = "")
    private String pCode ;
    /** 排序 */
    @ApiModelProperty(name = "排序",notes = "")
    private Integer sort ;
    /** 状态  0：停用   1：正常 */
    @ApiModelProperty(name = "状态  0：停用   1：正常",notes = "")
    private int status ;
}
