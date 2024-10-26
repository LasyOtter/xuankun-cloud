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
 * @since 1.0.0 2022-09-15
 */
@Data
@TableName("t_scheme_approval")
@Entity
@Table(name = "t_scheme_approval")
public class SchemeApprovalEntity {

    /**
     * 审核主键
     */
    @Id
    @TableId(type= IdType.AUTO)
	private Integer id;
    /**
     * 方案ID
     */
	private Integer schemeId;
    /**
     * 审核状态
     */
	private Integer approvalState;
    /**
     * 第一审核人
     */
	private String firstReviewedBy;
    /**
     * 第一审核时间
     */
	private Date firstReviewedDate;
    /**
     * 第二审核人
     */
	private String secondReviewedBy;
    /**
     * 第二审核时间
     */
	private Date secondReviewedDate;
    /**
     * 第三审核人
     */
	private String thirdReviewedBy;
    /**
     * 第三审核时间
     */
	private Date thirdReviewedDate;
    /**
     * 下一步
     */
    private int nextStep;
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