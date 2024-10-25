package com.xuankun.framework.mybatis.interceptor;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 数据范围
 *
 * @author Jimy
 */
@Data
@AllArgsConstructor
public class DataScope {
    private String sqlFilter;

}