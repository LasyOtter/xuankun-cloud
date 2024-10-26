package com.xuankun.workorder.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Jimy
 * @Title: ProcessInfoDTO
 * @Package com.xuankun.workorder.dto
 * @Description: 流程以及表单信息
 * @date 2022/10/11:16:28
 */
@Data
@ApiModel(value = "流程以及表单信息")
public class ProcessInfoDTO {
    @ApiModelProperty(value = "流程ID")
    private Long id;

    @ApiModelProperty(value = "表单ID")
    private Long formId;

    @ApiModelProperty(value = "流程深度")
    private Integer directorMaxLevel;

//    @ApiModelProperty(value = "流程节点信息")
//    private ProcessSettingInfoDTO nodeConfig;
    @ApiModelProperty(value = "流程节点信息")
    private ProcessSettingInfoDTO nodeConfig;
}
