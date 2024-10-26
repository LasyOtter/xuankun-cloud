package com.xuankun.workorder.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-12
 */
@Data
public class WfProcessUserApprovalExcel {
    @Excel(name = "")
    private Integer id;
    @Excel(name = "")
    private Integer processId;
    @Excel(name = "")
    private Long formId;
    @Excel(name = "")
    private Integer parentNodeId;
    @Excel(name = "")
    private Integer nodeId;
    @Excel(name = "")
    private Integer roleId;
    @Excel(name = "")
    private String roleName;
    @Excel(name = "")
    private Integer targetId;
    @Excel(name = "")
    private Integer isApproval;
    @Excel(name = "")
    private Integer approvalState;
    @Excel(name = "")
    private Integer approvalType;
    @Excel(name = "")
    private String creator;
    @Excel(name = "")
    private Date createDate;
    @Excel(name = "")
    private String updator;
    @Excel(name = "")
    private Date updateDate;

}