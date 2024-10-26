package com.xuankun.workorder.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("t_wo_increment")
@Entity
@Table(name = "t_wo_increment")
public class WoIncrementEntity {

    /**
     * 主键
     */
    @Id
    @TableId(value = "id", type = IdType.AUTO)
	private Integer id;
    /**
     * 日期
     */
	private String woDate;
    /**
     * 自增数
     */
	private Long autoincrement;
}