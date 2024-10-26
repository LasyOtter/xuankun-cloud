package com.xuankun.workorder.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 角色表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-31
 */
@Data
public class WfRoleExcel {
    @Excel(name = "主键")
    private Integer id;
    @Excel(name = "角色名称")
    private String roleName;
    @Excel(name = "区域ID")
    private Integer regionId;
    @Excel(name = "创建者")
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