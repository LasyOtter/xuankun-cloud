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
public class WfProcessExcel {
    @Excel(name = "主键")
    private Integer id;
    @Excel(name = "表ID")
    private Integer tableId;
    @Excel(name = "流程深度")
    private Integer directorMaxLevel;
    @Excel(name = "流程节点信息")
    private String processNode;
    @Excel(name = "创建人")
    private String creator;
    @Excel(name = "创建时间")
    private Date createDate;
    @Excel(name = "修改人")
    private String updator;
    @Excel(name = "修改时间")
    private Date updateDate;

}