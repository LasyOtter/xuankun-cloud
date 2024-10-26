package com.xuankun.workorder.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Jimy
 * @Title: PorcessNodeFlowInfoDTO
 * @Package com.xuankun.workorder.dto
 * @Description: 流程节点审批信息
 * @date 2022/11/4:16:27
 */
@Data
@ApiModel(value = "流程节点审批信息")
public class PorcessNodeFlowInfoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "节点编码")
    private String nodeCode;

    @ApiModelProperty(value = "是否审批")
    private int isApproval;
}
