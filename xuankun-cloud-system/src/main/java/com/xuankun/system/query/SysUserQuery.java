package com.xuankun.system.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.xuankun.framework.common.query.Query;

/**
 * 用户查询
 *
 * @author Jimy
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "用户查询")
public class SysUserQuery extends Query {
    @Schema(description = "用户名")
    private String username;

    @Schema(description = "手机号")
    private String mobile;

    @Schema(description = "性别")
    private Integer gender;

}
