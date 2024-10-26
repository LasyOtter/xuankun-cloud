package com.xuankun.workorder.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 流程实例关联表单
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-11
 */
@Data
public class WfDeployFormExcel {
    @Excel(name = "流程表单实例主键")
    private Integer id;
    @Excel(name = "表单Key")
    private Integer formId;
    @Excel(name = "节点Key")
    private Integer processId;
    @Excel(name = "节点名称")
    private Integer nodeId;
    @Excel(name = "表单内容")
    private String content;
    @Excel(name = "工单主键")
    private Integer workOrderId;
    @Excel(name = "工单号")
    private String workOrderCode;
    @Excel(name = "创建人")
    private String creator;
    @Excel(name = "创建时间")
    private Date createDate;
    @Excel(name = "修改人")
    private String updator;
    @Excel(name = "修改时间")
    private Date updateDate;

}