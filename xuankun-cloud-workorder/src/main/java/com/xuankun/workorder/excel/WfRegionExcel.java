package com.xuankun.workorder.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-30
 */
@Data
public class WfRegionExcel {
    @Excel(name = "主键")
    private Integer id;
    @Excel(name = "地区编码")
    private String regionCode;
    @Excel(name = "地区名称")
    private String regionName;
    @Excel(name = "上一级")
    private Integer parentId;
    @Excel(name = "创建时间")
    private LocalDateTime createDate;
    @Excel(name = "创建人")
    private String creator;
    @Excel(name = "修改人")
    private String updator;
    @Excel(name = "修改时间")
    private LocalDateTime updateDate;
    @Excel(name = "逻辑删除标志")
    private Integer delFlag;

}