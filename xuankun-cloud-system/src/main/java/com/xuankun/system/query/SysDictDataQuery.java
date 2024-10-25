package com.xuankun.system.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.xuankun.framework.common.query.Query;

import javax.validation.constraints.NotNull;

/**
 * 字典数据
 *
 * @author Jimy
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "字典数据查询")
public class SysDictDataQuery extends Query {
    @Schema(description = "字典类型ID", required = true)
    @NotNull(message = "字典类型ID不能为空")
    private Long dictTypeId;

}
