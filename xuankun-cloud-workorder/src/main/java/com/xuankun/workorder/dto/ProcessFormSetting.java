package com.xuankun.workorder.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Jimy
 * @Title: ProcessFormSetting
 * @Package com.xuankun.workorder.dto
 * @Description: 基础设置
 * @date 2022/10/11:16:22
 */
@Data
public class ProcessFormSetting {
    @ApiModelProperty(value = "表单id")
    private Long id;
    /**
     * 表单名称
     */
    @ApiModelProperty(value = "表单名称")
    private String name;
    /**
     * 表单分组ID
     */
    @ApiModelProperty(value = "表单分组ID")
    private int groupId;
    /**
     * 表单说明
     */
    @ApiModelProperty(value = "表单说明")
    private String remark;
    /**
     * 是否通用：通用表单不用保存到工单里面去  0：不通用；1：通用
     */
    @ApiModelProperty(value = "表单是否通用")
    private int inCommonUse;
    /**
     * 谁可以发起
     */
    @ApiModelProperty(value = "谁可以发起")
    private List<NodeUserDTO> nodeUserList;
}
