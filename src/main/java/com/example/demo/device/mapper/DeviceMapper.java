package com.example.demo.device.mapper;

import com.example.demo.device.entity.DeviceEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeviceMapper {

    @Insert("INSERT INTO tb_device (name, deviceId, type) VALUES (#{name}, #{deviceId}, #{type})")
    void insertDevice(DeviceEntity deviceEntity);
}






