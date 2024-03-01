// DataService.java
package com.example.demo.device.service;

import com.example.demo.device.mapper.DataMapper;
import com.example.demo.device.dto.DataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import com.example.demo.device.repository.DataRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DataService {

    @Autowired
    private DataMapper dataMapper;


    public List<DataDto> getAllTemperatureHumidityOxygen() {
        return dataMapper.findAllTemperatureHumidityOxygen();
    }

    public DataDto getLatestTemperatureHumidityOxygen() {
        return dataMapper.findLatestTemperatureHumidityOxygen();
    }

    public List<DataDto> findDataByTimeRange(LocalDateTime startTime, LocalDateTime endTime) {
        // 在这里根据时间范围查询数据并返回
        // 示例代码
        return dataMapper.findDataByTimeRange(startTime, endTime);
    }



}
