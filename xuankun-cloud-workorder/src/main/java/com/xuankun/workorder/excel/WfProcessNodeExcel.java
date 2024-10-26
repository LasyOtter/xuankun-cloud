package com.xuankun.workorder.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-11
 */
@Data
public class WfProcessNodeExcel {
    @Excel(name = "主键")
    private Integer id;
    @Excel(name = "流程主键")
    private Integer processId;
    @Excel(name = "父节点主键")
    private Integer parentId;
    @Excel(name = "节点名称")
    private String nodeName;
    @Excel(name = "节点编码")
    private String nodeCode;
    @Excel(name = "审批人为空时:1-自动审批通过;2-转交给审批管理员")
    private Integer noHanderAction;
    @Excel(name = "审批人数:1-选一个人;2-选多个人")
    private Integer selectMode;
    @Excel(name = "选择范围:1-全公司;2-指定成员;3-指定角色")
    private Integer selectRange;
    @Excel(name = "审批人设置:1-指定成员;2-主管;3-发起人自选;4-发起人自己;5-连续多级主管;")
    private Integer setType;
    @Excel(name = "节点类型")
    private Integer type;
    @Excel(name = "条件优先级")
    private Integer priorityLevel;
    @Excel(name = "允许发起人自选抄送人")
    private Integer ccSelfSelectFlag;
    @Excel(name = "审批终点--最高层主管数")
    private Integer directorLevel;
    @Excel(name = "审批模式:1-依次审批;2-会签")
    private Integer examineMode;
    @Excel(name = "审批终点-第N层主管")
    private Integer examineEndDirectorLevel;
    @Excel(name = "当前审批是否通过校验")
    private Integer error;
    @Excel(name = "是否是条件节点")
    private Integer isConditionNode;
    @Excel(name = "创建人")
    private String creator;
    @Excel(name = "创建时间")
    private Date createDate;
    @Excel(name = "修改人")
    private String updator;
    @Excel(name = "修改时间")
    private Date updateDate;

}