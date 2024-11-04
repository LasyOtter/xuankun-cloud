package com.xuankun.scm.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@Schema(description = "品牌表")
@EqualsAndHashCode(callSuper = false)
public class DsBrandVO implements Serializable{

    /** 品牌代码 */
    @Schema(description = "品牌代码")
    private String brandCode ;
    /** 品牌名称 */
    @Schema(description = "品牌名称")
    private String brandName ;
    /** 品牌logo图片地址 */
    @Schema(description = "品牌logo图片地址")
    private String brandLogo ;
    /** 品牌描述 */
    @Schema(description = "品牌描述")
    private String brandDesc ;
    /** 排序 */
    @Schema(description = "排序")
    private Integer sort ;
}
