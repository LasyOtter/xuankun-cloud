package com.xuankun.workorder.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-09-15
 */
@Data
public class OperationSchemeExcel {
    @Excel(name = "运维方案主键")
    private Integer id;
    @Excel(name = "运维方案名称")
    private String schemeName;
    @Excel(name = "运维类型")
    private String operationType;
    @Excel(name = "运维说明")
    private String schemeDescription;
    @Excel(name = "创建人")
    private String creator;
    @Excel(name = "创建时间")
    private Date createDate;
    @Excel(name = "方案图示")
    private String schemeLllustration;
    @Excel(name = "组织类型")
    private String organizationType;
    @Excel(name = "运维执行组织")
    private String executorOfOrganization;
    @Excel(name = "使用产品型号")
    private String productModel;
    @Excel(name = "审批级别")
    private String approvalLevel;
    @Excel(name = "审批角色")
    private String approvalRole;
    @Excel(name = "是否需要验收")
    private Integer isCheck;
    @Excel(name = "验收方式")
    private String acceptanceMethod;
    @Excel(name = "自动验收设置")
    private String autoAcceptanceSettings;
    @Excel(name = "方案启用")
    private String enableCheme;
    @Excel(name = "方案生效日期")
    private String effectiveDate;
    @Excel(name = "方案有效期")
    private String termOfValidity;
    @Excel(name = "修改人")
    private String modifiedBy;
    @Excel(name = "修改日期")
    private Date modifiedDate;
    @Excel(name = "逻辑删除")
    private Integer isDel;

}