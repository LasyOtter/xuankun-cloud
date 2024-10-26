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
public class WfNodeUserExcel {
    @Excel(name = "")
    private Integer id;
    @Excel(name = "")
    private Integer nodeId;
    @Excel(name = "")
    private String name;
    @Excel(name = "")
    private Integer targetid;
    @Excel(name = "")
    private Integer type;
    @Excel(name = "")
    private String creator;
    @Excel(name = "")
    private Date createDate;
    @Excel(name = "")
    private String updator;
    @Excel(name = "")
    private Date updateDate;

}