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
public class SchemeApprovalExcel {
    @Excel(name = "审核主键")
    private Integer id;
    @Excel(name = "方案ID")
    private Integer schemeId;
    @Excel(name = "审核状态")
    private Integer approvalState;
    @Excel(name = "第一审核人")
    private String firstReviewedBy;
    @Excel(name = "第一审核时间")
    private Date firstReviewedDate;
    @Excel(name = "第二审核人")
    private String secondReviewedBy;
    @Excel(name = "第二审核时间")
    private Date secondReviewedDate;
    @Excel(name = "第三审核人")
    private String thirdReviewedBy;
    @Excel(name = "第三审核时间")
    private Date thirdReviewedDate;
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