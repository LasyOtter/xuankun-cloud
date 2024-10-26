package com.xuankun.workorder.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户权限表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-11-07
 */
@Data
public class WfUserRoleExcel {
    @Excel(name = "主键")
    private Integer id;
    @Excel(name = "派单系统用户ID")
    private Integer userId;
    @Excel(name = "派单系统角色ID")
    private Integer roleId;
    @Excel(name = "创建人")
    private String creator;
    @Excel(name = "创建时间")
    private LocalDateTime createDate;
    @Excel(name = "修改人")
    private String updator;
    @Excel(name = "修改时间")
    private LocalDateTime updateDate;
    @Excel(name = "逻辑删除标志")
    private Integer delFlag;

}