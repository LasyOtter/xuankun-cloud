package com.xuankun.workorder.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 部门表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-31
 */
@Data
public class WfDeptExcel {
    @Excel(name = "部门id")
    private Long id;
    @Excel(name = "部门名称")
    private String name;
    @Excel(name = "父部门id")
    private Long parentId;
    @Excel(name = "显示顺序")
    private Integer sort;
    @Excel(name = "负责人")
    private Long leaderUserId;
    @Excel(name = "联系电话")
    private String phone;
    @Excel(name = "邮箱")
    private String email;
    @Excel(name = "部门状态（0正常 1停用）")
    private Integer status;
    @Excel(name = "创建者")
    private String creator;
    @Excel(name = "创建时间")
    private LocalDateTime createDate;
    @Excel(name = "更新者")
    private String updator;
    @Excel(name = "更新时间")
    private LocalDateTime updateDate;
    @Excel(name = "是否删除")
    private Boolean delFlag;
    @Excel(name = "租户编号/组织编号")
    private Long tenantId;

}