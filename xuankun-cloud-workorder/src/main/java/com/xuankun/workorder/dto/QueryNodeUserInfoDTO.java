package com.xuankun.workorder.dto;

import lombok.Data;

import java.util.List;

/**
 * @author Jimy
 * @Title: QueryNodeUserInfoDTO
 * @Package com.xuankun.workorder.dto
 * @Description: todo
 * @date 2022/10/12:15:10
 */
@Data
public class QueryNodeUserInfoDTO {
    private int orderId;
    private long formId;
    private List<String> roleName;
}
