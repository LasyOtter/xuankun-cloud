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
public class WoIncrementExcel {
    @Excel(name = "主键")
    private Integer id;
    @Excel(name = "日期")
    private Date woDate;
    @Excel(name = "自增数")
    private Long autoincrement;

}