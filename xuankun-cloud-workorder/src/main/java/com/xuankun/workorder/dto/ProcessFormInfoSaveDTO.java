package com.xuankun.workorder.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Jimy
 * @Title: ProcessFormInfoSaveDTO
 * @Package com.xuankun.workorder.dto
 * @Description: 表单设计DTO
 * @date 2022/10/11:16:20
 */
@Data
@ApiModel(value = "流程基础设置信息")
public class ProcessFormInfoSaveDTO {
    /**
     * 基础设置信息
     */
    @ApiModelProperty(value = "基础设置信息")
    private ProcessFormSetting formSetting;
    /**
     * 表单信息
     */
    @ApiModelProperty(value = "表单信息")
    private String formContent;
    /**
     * 流程设计信息
     */
    @ApiModelProperty(value = "流程设计信息")
    private ProcessInfoDTO processDTO;
}
