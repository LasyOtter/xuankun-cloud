package com.xuankun.scm.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@Schema(description = "品类表")
@EqualsAndHashCode(callSuper = false)
public class DsCategoryVO implements Serializable{
    /** 品类代码 */
    @Schema(description = "品类代码")
    private String categoryCode ;
    /** 品类名称 */
    @Schema(description = "品类名称")
    private String categoryName ;
    /** 品类描述 */
    @Schema(description = "品类描述")
    private String categoryDesc ;
    /** 父品类ID */
    @Schema(description = "父品类ID")
    private Integer pId ;
    /** 父品类CODE */
    @Schema(description = "父品类CODE")
    private String pCode ;
    /** 排序 */
    @Schema(description = "排序")
    private Integer sort ;
    /** 状态  0：停用   1：正常 */
    @Schema(description = "状态  0：停用   1：正常")
    private int status ;
}
