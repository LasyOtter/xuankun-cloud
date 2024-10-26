package com.xuankun.workorder.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Jimy
 * @Title: SaveWorkOrderAndFormInfoDTO
 * @Package com.xuankun.workorder.dto
 * @Description: 保存工单以及表单信息
 * @date 2022/10/27:10:36
 */
@Data
@ApiModel(value = "保存工单以及表单信息")
public class SaveWorkOrderAndFormInfoDTO {
    /**
     * 工单信息
     */
    @ApiModelProperty(value = "工单信息")
    private WorkOrderDTO workOrderDTO;
    /**
     * 是否通用：通用表单不用保存到工单里面去  0：不通用；1：通用
     */
    @ApiModelProperty(value = "是否通用：通用表单不用保存到工单里面去  0：不通用；1：通用")
    private boolean inCommonUse;

    /**
     * 表单信息
     */
    @ApiModelProperty(value = "表单信息")
    private String formContent;
}
