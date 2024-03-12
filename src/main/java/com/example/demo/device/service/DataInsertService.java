package com.example.demo.device.service;

//import com.example.demo.device.sql.entity.Co2Entity;
import com.example.demo.device.entity.DataEntity;
//import com.example.demo.device.sql.mapper.Co2Mapper;
import com.example.demo.device.mapper.DataInsertMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DataInsertService {

    private final DataInsertMapper dataInsertMapper;

    @Autowired
    public DataInsertService(DataInsertMapper dataInsertMapper) {
        this.dataInsertMapper = dataInsertMapper;
    }

    @Transactional
    public void insertData(DataEntity dataEntity) {
        dataInsertMapper.insertData(dataEntity);
    }



}
