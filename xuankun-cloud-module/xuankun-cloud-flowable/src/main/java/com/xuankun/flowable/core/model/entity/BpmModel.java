package com.xuankun.flowable.core.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xuankun.flowable.core.model.convert.BpmModelConvert;
import com.xuankun.flowable.dto.model.BpmModelDto;
import com.xuankun.framework.common.annotation.BigField;
import com.xuankun.framework.common.function.EntityBaseFunction;
import com.xuankun.framework.mybatis.base.MpBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* 流程模型
* @author xxm
* @date 2020/2/28 19:44
*/
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@TableName("bpm_model")
public class BpmModel extends MpBaseEntity implements EntityBaseFunction<BpmModelDto> {

    /** 名称 */
    private String name;
    /** 流程类型 */
    private String modelType;
    /** 关联表单id */
    private Long formId;
    /** 发布状态 */
    private String publish;
    /** 启用状态 */
    private Boolean enable;
    /** 部署id */
    private String deployId;
    /** 流程定义id */
    private String defId;
    /** 流程key */
    private String defKey;
    /** 流程名称 */
    private String defName;
    /** 流程备注 */
    private String defRemark;
    /** 是否主流程 */
    private Boolean mainProcess;
    /** 流程版本号 */
    private Integer processVersion;
    /** 流程xml */
    @BigField
    private String modelEditorXml;
    /** 备注 */
    private String remark;


    /** 转换成dto */
    @Override
    public BpmModelDto toDto() {
        return BpmModelConvert.CONVERT.convert(this);
    }

}
