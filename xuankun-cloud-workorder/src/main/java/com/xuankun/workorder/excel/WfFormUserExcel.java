package com.xuankun.workorder.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 表单发起用户表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-20
 */
@Data
public class WfFormUserExcel {
    @Excel(name = "主键")
    private Integer id;
    @Excel(name = "表单ID")
    private Integer formId;
    @Excel(name = "用户ID")
    private Integer userId;
    @Excel(name = "组织ID")
    private Integer orgId;
    @Excel(name = "创建人")
    private String creator;
    @Excel(name = "创建时间")
    private LocalDateTime createDate;
    @Excel(name = "修改人")
    private String updator;
    @Excel(name = "修改时间")
    private LocalDateTime updateDate;
    @Excel(name = "逻辑删除标识")
    private Integer delFlag;

}