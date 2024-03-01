package com.example.demo.device.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.device.entity.CommandEntity;
import com.example.demo.device.entity.DataEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CommandMapper extends BaseMapper<CommandEntity> {

    @Insert("INSERT INTO tb_command (device_id,data,create_time) VALUES (#{deviceId},#{data},#{create_time})")
    void insertCommand(CommandEntity commandEntity);



    @Select("SELECT * FROM tb_command WHERE device_id = #{deviceId} ORDER BY create_time DESC LIMIT 1")
    CommandEntity findLatestCommandByDeviceId(String deviceId);

//    CommandEntity findLatestCommandByDeviceId(String deviceId);

}

