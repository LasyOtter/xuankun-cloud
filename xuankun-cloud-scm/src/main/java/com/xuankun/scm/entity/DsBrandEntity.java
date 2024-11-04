package com.xuankun.scm.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xuankun.framework.mybatis.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@ApiModel(value = "品牌表",description = "")
@EqualsAndHashCode(callSuper = false)
@TableName("ds_brand")
public class DsBrandEntity extends BaseEntity implements Serializable,Cloneable{

    /** 品牌代码 */
    @ApiModelProperty(name = "品牌代码",notes = "")
    private String brandCode ;
    /** 品牌名称 */
    @ApiModelProperty(name = "品牌名称",notes = "")
    private String brandName ;
    /** 品牌logo图片地址 */
    @ApiModelProperty(name = "品牌logo图片地址",notes = "")
    private String brandLogo ;
    /** 品牌描述 */
    @ApiModelProperty(name = "品牌描述",notes = "")
    private String brandDesc ;
    /** 排序 */
    @ApiModelProperty(name = "排序",notes = "")
    private Integer sort ;
}
