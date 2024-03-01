package com.example.demo.device.mapper;


import com.example.demo.device.entity.DataEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DataInsertMapper {
    @Insert("INSERT INTO tb_data (device_id,oxygen,humidity,temperature,youji,co2,create_time) VALUES (#{deviceId},#{co2},#{humidity},#{temperature},#{oxygen},#{youji},#{create_time})")
    void insertData(DataEntity dataEntity);
}
