package com.xuankun.workorder.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 组织区域对照表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-11-07
 */
@Data
public class WfOrgRegionExcel {
    @Excel(name = "主键")
    private Integer id;
    @Excel(name = "组织ID")
    private Integer orgId;
    @Excel(name = "区域ID")
    private Integer regionId;
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