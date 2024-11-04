package com.xuankun.scm.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xuankun.framework.mybatis.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "设计款式表",description = "")
@TableName("ds_design")
public class DsDesignEntity extends BaseEntity implements Serializable,Cloneable{
    /** 启用状态（1-启用；0-停用） */
    @ApiModelProperty(name = "启用状态（1-启用；0-停用）",notes = "")
    private int status ;
    /** 品牌ID（当前数据所属的品牌，对应SYS_Organization.OrganizationId） */
    @ApiModelProperty(name = "品牌ID（当前数据所属的品牌，对应SYS_Organization.OrganizationId）",notes = "")
    private Long brandId ;
    /** 品牌（品牌代码，对应SYS_Organization.OrganizationCode） */
    @ApiModelProperty(name = "品牌（品牌代码，对应SYS_Organization.OrganizationCode）",notes = "")
    private String brandName ;
    /** 设计款号 */
    @ApiModelProperty(name = "设计款号",notes = "")
    private String designCode ;
    /** 年份 */
    @ApiModelProperty(name = "年份",notes = "")
    private Integer designYear ;
    /** 季节（春/夏/秋/冬） */
    @ApiModelProperty(name = "季节（春/夏/秋/冬）",notes = "")
    private Long seasonId ;
    /** 季节（春/夏/秋/冬） */
    @ApiModelProperty(name = "季节（春/夏/秋/冬）",notes = "")
    private String seasonName ;
    /** 波段（标识代码：CPBD，保存名称） */
    @ApiModelProperty(name = "波段（标识代码：CPBD，保存名称）",notes = "")
    private String waverangeName ;
    /** 波段档案Id（对应DS_BandData.Id） */
    @ApiModelProperty(name = "波段档案Id（对应DS_BandData.Id）",notes = "")
    private Long waverangeId ;
    /** 设计师（设计师角色的账号） */
    @ApiModelProperty(name = "设计师（设计师角色的账号）",notes = "")
    private String designer ;
    /** 设计师所属组别ID */
    @ApiModelProperty(name = "设计师所属组别ID",notes = "")
    private Long designerGroupId ;
    /** 设计稿日期 */
    @ApiModelProperty(name = "设计稿日期",notes = "")
    private Date designDate ;
    /** 计划上新月份（到月份，默认为1号） */
    @ApiModelProperty(name = "计划上新月份（到月份，默认为1号）",notes = "")
    private Date planNewDate ;
    /** 平台（标识代码：CPPT） */
    @ApiModelProperty(name = "平台（标识代码：CPPT）",notes = "")
    private String platform ;
    /** 产品定位（标识代码：CPDW） */
    @ApiModelProperty(name = "产品定位（标识代码：CPDW）",notes = "")
    private String positioning ;
    /** 级别（标识代码：CPJB） */
    @ApiModelProperty(name = "级别（标识代码：CPJB）",notes = "")
    private String selevel ;
    /** 品类（对应品类标准ds_category） */
    @ApiModelProperty(name = "品类（对应品类标准ds_category）",notes = "")
    private Long categoryId ;
    /** 二次加工（标识代码：ECJGLX） */
    @ApiModelProperty(name = "二次加工（标识代码：ECJGLX）",notes = "")
    private String secOperCategory ;
    /** 二次工艺（来源二次工艺成本的加工类别，只取费用类别为二次加工，多个英文时逗号间隔） */
    @ApiModelProperty(name = "二次工艺（来源二次工艺成本的加工类别，只取费用类别为二次加工，多个英文时逗号间隔）",notes = "")
    private String fromProcessCost ;
    /** 款式描述 */
    @ApiModelProperty(name = "款式描述",notes = "")
    private String styleDesc ;
    /** 卖点提炼 */
    @ApiModelProperty(name = "卖点提炼",notes = "")
    private String sellingPoint ;
    /** 跟单员（设计跟单员角色的账号） */
    @ApiModelProperty(name = "跟单员（设计跟单员角色的账号）",notes = "")
    private String merchandiser ;
    /** 建议尺码组合（多选，标识代码：DHCMZH） */
    @ApiModelProperty(name = "建议尺码组合（多选，标识代码：DHCMZH）",notes = "")
    private Long sizeGroupId ;
    /** 备注 */
    @ApiModelProperty(name = "备注",notes = "")
    private String remark ;
    /** 加工类别（标识代码：JGLB） */
    @ApiModelProperty(name = "加工类别（标识代码：JGLB）",notes = "")
    private String processCategory ;
    /** 研发类别（标识代码：YFLB） */
    @ApiModelProperty(name = "研发类别（标识代码：YFLB）",notes = "")
    private String devCategory ;
    /** 产品风格(标识代码CPFG) */
    @ApiModelProperty(name = "产品风格(标识代码CPFG)",notes = "")
    private String productStyle ;
    /** 主题 */
    @ApiModelProperty(name = "主题",notes = "")
    private String theme ;
    /** 系列（标识代码：XLDA） */
    @ApiModelProperty(name = "系列（标识代码：XLDA）",notes = "")
    private Long seriesId ;
}
