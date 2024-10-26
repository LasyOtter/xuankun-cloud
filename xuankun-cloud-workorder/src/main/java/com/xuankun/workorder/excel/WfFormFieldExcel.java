package com.xuankun.workorder.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 流程表单字段权限表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-19
 */
@Data
public class WfFormFieldExcel {
    @Excel(name = "主键")
    private Integer id;
    @Excel(name = "流程ID")
    private Integer processId;
    @Excel(name = "节点ID")
    private Integer nodeId;
    @Excel(name = "流程表单ID")
    private Integer formId;
    @Excel(name = "字段关键字")
    private String field;
    @Excel(name = "字段名称")
    private String fieldName;
    @Excel(name = "是否必填")
    private Integer required;
    @Excel(name = "可选操作：editable：可编辑  readonly：只读  hidden：隐藏")
    private String operation;
    @Excel(name = "创建人")
    private String creator;
    @Excel(name = "创建时间")
    private LocalDateTime createDate;
    @Excel(name = "修改人")
    private String updator;
    @Excel(name = "修改时间")
    private LocalDateTime updateDate;
    @Excel(name = "逻辑删除")
    private Integer delFlag;

}