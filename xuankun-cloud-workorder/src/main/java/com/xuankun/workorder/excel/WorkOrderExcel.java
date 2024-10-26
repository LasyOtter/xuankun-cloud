package com.xuankun.workorder.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-09-15
 */
@Data
public class WorkOrderExcel {
    @Excel(name = "工单ID")
    private Integer id;
    @Excel(name = "工单号")
    private String woCode;
    @Excel(name = "工单描述")
    private String woDescription;
    @Excel(name = "工单状态")
    private Integer woState;
    @Excel(name = "运维方案ID")
    private String schemeId;
    @Excel(name = "运维方案")
    private String schemeName;
    @Excel(name = "提交时间")
    private Date submissionTime;
    @Excel(name = "计划执行时间")
    private Date plannedExecutionTime;
    @Excel(name = "执行角色ID")
    private Integer executorRoleId;
    @Excel(name = "执行角色")
    private String executorRole;
    @Excel(name = "创建人")
    private String creator;
    @Excel(name = "创建时间")
    private Date createDate;
    @Excel(name = "修改人")
    private String modifiedBy;
    @Excel(name = "修改时间")
    private Date modifiedDate;
    @Excel(name = "逻辑删除")
    private Integer isDel;

}