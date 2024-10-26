package com.xuankun.workorder.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Jimy
 * @Title: SchemeOrderDTO
 * @Package com.xuankun.workorder.dto
 * @Description: todo
 * @date 2022/9/15:16:36
 */
@Data
@ApiModel(value = "工单信息实体类")
public class SchemeOrderDTO {
    /**
     * 工单
     */
    @ApiModelProperty(value = "工单")
    private WorkOrderDTO workOrderDTO;
    /**
     * 运维单
     */
    @ApiModelProperty(value = "运维单")
    private OperationSchemeDTO operSchemeDTO;
    /**
     * 保存的表单信息
     */
    @ApiModelProperty(value = "保存的表单信息")
    private WfDeployFormDTO deployFormDTO;
}
