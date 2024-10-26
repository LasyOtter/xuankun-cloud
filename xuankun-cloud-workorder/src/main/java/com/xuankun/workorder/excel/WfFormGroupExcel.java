package com.xuankun.workorder.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 表单分组
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-14
 */
@Data
public class WfFormGroupExcel {
    @Excel(name = "表单分组主键")
    private Integer id;
    @Excel(name = "表单分组名称")
    private String groupName;
    @Excel(name = "创建人")
    private String creator;
    @Excel(name = "创建时间")
    private Date createDate;
    @Excel(name = "修改人")
    private String updator;
    @Excel(name = "修改时间")
    private Date updateDate;

}