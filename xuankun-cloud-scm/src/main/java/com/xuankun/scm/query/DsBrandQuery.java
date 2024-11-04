package com.xuankun.scm.query;

import com.xuankun.framework.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "品牌数据查询")
public class DsBrandQuery  extends Query {
    @Schema(description = "ID", required = true)
    @NotNull(message = "ID不能为空")
    private Long id;
}
