package com.xuankun.workorder.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author Jimy
 * @Title: ProjectInfoDTO
 * @Package com.xuankun.workorder.dto
 * @Description: todo
 * @date 2022/9/19:15:08
 */
@Data
@ApiModel(value = "工单所需项目信息")
public class ProjectInfoDTO {
    /**
     * 项目ID
     */
    private int projectId;
    /**
     * 项目
     */
    private String projectName;
}
