package com.example.demo.Device_Manager.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @TableName tb_data
 */
@TableName(value ="tb_data")
@Data
public class tb_data implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private Integer device_id;

    /**
     * 
     */
    private Date create_time;

    /**
     * 
     */
    private BigDecimal oxygen;

    /**
     * 
     */
    private BigDecimal humidity;

    /**
     * 
     */
    private BigDecimal temperature;

    /**
     * 
     */
    private BigDecimal light;

    /**
     * 
     */
    private BigDecimal co2;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}