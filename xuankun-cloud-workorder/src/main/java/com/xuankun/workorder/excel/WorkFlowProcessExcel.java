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
public class WorkFlowProcessExcel {
    @Excel(name = "主键")
    private Integer id;
    @Excel(name = "步骤编码")
    private Integer processCode;
    @Excel(name = "步骤名称")
    private String processName;
    @Excel(name = "是否需要审批")
    private Integer isNeedApproval;
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