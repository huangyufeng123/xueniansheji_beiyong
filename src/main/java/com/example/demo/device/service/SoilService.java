package com.example.demo.device.service;
import com.example.demo.device.entity.SoilEntity;
import com.example.demo.device.mapper.SoilMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class SoilService {
    private final SoilMapper soilMapper;

    @Autowired
    public SoilService(SoilMapper soilMapper){
        this.soilMapper=soilMapper;
    }

    @Transactional
    public void insertData(SoilEntity soilEntity){
        soilMapper.insertData(soilEntity);
    }
}
