package com.xuankun.workorder.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-09-17
 */
@Data
public class SchemeProductInfoExcel {
    @Excel(name = "主键")
    private Integer id;
    @Excel(name = "方案ID")
    private Integer schemeId;
    @Excel(name = "产品型号ID")
    private Integer productModeId;
    @Excel(name = "产品型号")
    private String productMode;
    @Excel(name = "创建人")
    private String creator;
    @Excel(name = "创建时间")
    private Date createDate;
    @Excel(name = "修改人")
    private String modifiedBy;
    @Excel(name = "修改日期")
    private Date modifiedDate;
    @Excel(name = "逻辑删除")
    private Integer isDel;

}