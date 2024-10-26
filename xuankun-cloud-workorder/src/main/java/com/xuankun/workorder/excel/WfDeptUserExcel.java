package com.xuankun.workorder.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 部门与用户对照表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-11-07
 */
@Data
public class WfDeptUserExcel {
    @Excel(name = "主键")
    private Integer id;
    @Excel(name = "部门ID")
    private Integer deptId;
    @Excel(name = "用户ID")
    private Integer userId;
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