package com.xuankun.workorder.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-09-19
 */
@Data
public class WoWorkFlowExcel {
    @Excel(name = "主键")
    private Integer id;
    @Excel(name = "工单ID")
    private Integer workOrderId;
    @Excel(name = "工单号")
    private String workOrderCode;
    @Excel(name = "状态")
    private Integer state;
    @Excel(name = "状态名称")
    private String stateName;
    @Excel(name = "执行时间")
    private Date executeTime;
    @Excel(name = "原因")
    private String reason;
    @Excel(name = "备注")
    private String remark;
    @Excel(name = "当前步骤")
    private Integer curStep;
    @Excel(name = "下一步骤")
    private Integer nextStep;
    @Excel(name = "上一步骤")
    private Integer lastStep;
    @Excel(name = "创建人")
    private String creator;
    @Excel(name = "创建时间")
    private Date createDate;
    @Excel(name = "修改人")
    private String modifiedBy;
    @Excel(name = "修改时间")
    private Date modifiedDate;
    @Excel(name = "逻辑删除")
    private String isDel;

}