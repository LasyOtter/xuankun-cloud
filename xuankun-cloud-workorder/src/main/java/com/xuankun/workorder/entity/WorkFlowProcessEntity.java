package com.xuankun.workorder.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-09-19
 */
@Data
@TableName("t_work_flow_process")
@Entity
@Table(name = "t_work_flow_process")
public class WorkFlowProcessEntity {

    /**
     * 主键
     */
    @Id
    @TableId(type= IdType.AUTO)
	private Integer id;
    /**
     * 步骤编码
     */
	private Integer processCode;
    /**
     * 步骤名称
     */
	private String processName;
    /**
     * 是否需要审批
     */
	private Integer isNeedApproval;
    /**
     * 创建人
     */
	private String creator;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
	private LocalDateTime createDate;
    /**
     * 修改人
     */
	private String modifiedBy;
    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime modifiedDate;
    /**
     * 逻辑删除
     */
	private Integer isDel;
}