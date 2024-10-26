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
public class WfNodeConditionExcel {
    @Excel(name = "主键")
    private Integer id;
    @Excel(name = "所属节点主键")
    private Integer nodeId;
    @Excel(name = "发起人")
    private Integer columnId;
    @Excel(name = "1:发起人;2其他")
    private Integer type;
    @Excel(name = "操作符")
    private String optType;
    @Excel(name = "左侧自定义内容")
    private String zdy1;
    @Excel(name = "右侧自定义内容")
    private String zdy2;
    @Excel(name = "左侧操作符")
    private String opt1;
    @Excel(name = "右侧操作符")
    private String opt2;
    @Excel(name = "条件字段名称")
    private String columnDbname;
    @Excel(name = "条件字段类型")
    private Integer columnType;
    @Excel(name = "展示类型")
    private Integer showType;
    @Excel(name = "展示名称")
    private String showName;
    @Excel(name = "多选数组")
    private String fixedDownBoxValue;
    @Excel(name = "创建人")
    private String creator;
    @Excel(name = "创建时间")
    private Date createDate;
    @Excel(name = "修改人")
    private String updator;
    @Excel(name = "修改时间")
    private Date updateDate;

}