package com.xuankun.workorder.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Jimy
 * @Title: ProcessFormSettingInfoDTO
 * @Package com.xuankun.workorder.dto
 * @Description: todo
 * @date 2022/10/11:16:30
 */
@Data
@ApiModel(value = "流程节点设置信息")
public class ProcessSettingInfoDTO {
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "节点名称")
    private String nodeName;

    @ApiModelProperty(value = "节点编码")
    private String nodeCode;

    @ApiModelProperty(value = "审批人为空时:1-自动审批通过;2-转交给审批管理员")
    private Integer noHanderAction;

    @ApiModelProperty(value = "审批人数:1-选一个人;2-选多个人")
    private Integer selectMode;

    @ApiModelProperty(value = "选择范围:1-全公司;2-指定成员;3-指定角色")
    private Integer selectRange;

    @ApiModelProperty(value = "审批人设置:1-指定成员;2-主管;3-发起人自选;4-发起人自己;5-连续多级主管;")
    private Integer setType;

    @ApiModelProperty(value = "节点类型")
    private Integer type;

    @ApiModelProperty(value = "条件优先级")
    private Integer priorityLevel;

    @ApiModelProperty(value = "允许发起人自选抄送人")
    private Integer ccSelfSelectFlag = 0;

    @ApiModelProperty(value = "审批终点--最高层主管数")
    private Integer directorLevel;

    @ApiModelProperty(value = "审批模式:1-依次审批;2-会签")
    private Integer examineMode;

    @ApiModelProperty(value = "审批终点-第N层主管")
    private Integer examineEndDirectorLevel;

    @ApiModelProperty(value = "当前审批是否通过校验")
    private Boolean error;

    @ApiModelProperty(value = "审批意见是否必填")
    private Boolean remarkIsRequired;

    @ApiModelProperty(value = "子节点")
    private List<ProcessSettingInfoDTO> childNode;

    @ApiModelProperty(value = "子条件节点")
    private List<ProcessSettingInfoDTO> conditionNodes;

    @ApiModelProperty(value = "条件节点条件列表")
    private List<WfNodeConditionDTO> conditionList;

    @ApiModelProperty(value = "节点用户列表")
    private List<NodeUserDTO> nodeUserList;

    @ApiModelProperty(value = "节点表单信息列表")
    private List<WfFormFieldDTO> formAuthList;
}
