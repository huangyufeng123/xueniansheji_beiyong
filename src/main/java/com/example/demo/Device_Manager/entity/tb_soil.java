package com.example.demo.Device_Manager.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName tb_soil
 */
@TableName(value ="tb_soil")
@Data
public class tb_soil implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String soil1;

    /**
     * 
     */
    private String soil2;

    /**
     * 
     */
    private String soil3;

    /**
     * 
     */
    private String soil4;

    /**
     * 
     */
    private String soil5;

    /**
     * 
     */
    private String soil6;

    /**
     * 
     */
    private String soil7;

    /**
     * 
     */
    private String soil8;

    /**
     * 
     */
    private Date time;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}