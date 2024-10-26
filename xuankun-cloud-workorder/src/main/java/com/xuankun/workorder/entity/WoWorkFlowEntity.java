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
@TableName("t_wo_work_flow")
@Entity
@Table(name = "t_wo_work_flow")
public class WoWorkFlowEntity {

    /**
     * 主键
     */
    @Id
    @TableId(type= IdType.AUTO)
	private Integer id;
    /**
     * 工单ID
     */
	private Integer workOrderId;
    /**
     * 工单号
     */
	private String workOrderCode;
    /**
     * 状态
     */
	private Integer state;
    /**
     * 状态名称
     */
	private String stateName;
    /**
     * 执行时间
     */
	private LocalDateTime executeTime;
    /**
     * 执行人ID
     */
    private String executorUserId;
    /**
     * 原因
     */
	private String reason;
    /**
     * 备注
     */
	private String remark;
    /**
     * 当前步骤
     */
	private Integer curStep;
    /**
     * 下一步骤
     */
	private Integer nextStep;
    /**
     * 上一步骤
     */
	private Integer lastStep;
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
	private String isDel;
}