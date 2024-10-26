package com.xuankun.workorder.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 流程表单信息表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-11
 */
@Data
public class WfFormExcel {
    @Excel(name = "表单主键")
    private Long formId;
    @Excel(name = "流程主键")
    private Integer processId;
    @Excel(name = "表单名称")
    private String formName;
    @Excel(name = "表单内容")
    private String content;
    @Excel(name = "创建者")
    private String createBy;
    @Excel(name = "创建时间")
    private Date createTime;
    @Excel(name = "更新者")
    private String updateBy;
    @Excel(name = "更新时间")
    private Date updateTime;
    @Excel(name = "备注")
    private String remark;
    @Excel(name = "删除标志（0代表存在 2代表删除）")
    private String delFlag;

}