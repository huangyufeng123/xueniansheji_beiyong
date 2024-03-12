// DataMapper.java
package com.example.demo.device.mapper;

import com.example.demo.device.entity.DataEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.device.dto.DataDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.type.JdbcType;

import java.sql.Timestamp;


public interface DataMapper extends BaseMapper<DataEntity> {


    @Select("SELECT temperature, humidity, oxygen, co2, youji, device_id, create_time " +
            "FROM tb_data " +
            "ORDER BY create_time DESC " +
            "LIMIT 60")
    @Results(value = {
            @Result(property = "createTime", column = "create_time", javaType = LocalDateTime.class, jdbcType = JdbcType.TIMESTAMP),
    })
    List<DataDto> findAllTemperatureHumidityOxygen();







    @Select("SELECT temperature, humidity, oxygen,co2, youji, device_id, create_time FROM tb_data ORDER BY create_time DESC LIMIT 1")
    @Results(value = {
            @Result(property = "createTime", column = "create_time", javaType = LocalDateTime.class, jdbcType = JdbcType.TIMESTAMP),
    })
    DataDto findLatestTemperatureHumidityOxygen();




    @Select("SELECT temperature, humidity, oxygen, co2, youji, device_id, create_time " +
            "FROM tb_data " +
            "WHERE create_time BETWEEN #{startTime} AND #{endTime}")
    @Results(value = {
            @Result(property = "createTime", column = "create_time", javaType = LocalDateTime.class, jdbcType = JdbcType.TIMESTAMP),
    })
    List<DataDto> findDataByTimeRange(@Param("startTime") LocalDateTime startTime,
                                      @Param("endTime") LocalDateTime endTime);



}




//package com.example.demo.device.mapper;
//
//import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//import com.example.demo.device.entity.DataEntity;
//import org.apache.ibatis.annotations.Mapper;
//
//@Mapper
//public interface DataMapper extends BaseMapper<DataEntity> {
//
//}

