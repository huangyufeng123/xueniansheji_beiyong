package com.example.demo.device.service;

import com.example.demo.device.entity.DeviceEntity;
import com.example.demo.device.mapper.DeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeviceService {

    private final DeviceMapper deviceMapper;

    @Autowired
    public DeviceService(DeviceMapper deviceMapper) {
        this.deviceMapper = deviceMapper;
    }

    @Transactional
    public void insertDeviceData(DeviceEntity deviceEntity) {
        deviceMapper.insertDevice(deviceEntity);
    }
}
