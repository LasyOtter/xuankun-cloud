package com.xuankun.flowable.dto.model;

import com.xuankun.framework.common.rest.dto.BaseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 流程模型
 * @author xxm
 * @date 2022-08-23
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(title = "流程模型")
@Accessors(chain = true)
public class BpmModelDto extends BaseDto {

    @Schema(description = "名称")
    private String name;
    @Schema(description = "流程类型")
    private String modelType;
    @Schema(description = "关联表单id")
    private Long formId;
    @Schema(description = "发布状态")
    private String publish;
    @Schema(description = "启用状态")
    private Boolean enable;
    @Schema(description = "部署id")
    private String deployId;
    @Schema(description = "流程定义id")
    private String defId;
    @Schema(description = "流程key")
    private String defKey;
    @Schema(description ="流程名称")
    private String defName;
    @Schema(description ="流程备注")
    private String defRemark;
    @Schema(description = "是否主流程")
    private Boolean mainProcess;
    @Schema(description = "流程版本号")
    private Integer processVersion;
    @Schema(description = "流程xml")
    private String modelEditorXml;
    @Schema(description = "备注")
    private String remark;

}