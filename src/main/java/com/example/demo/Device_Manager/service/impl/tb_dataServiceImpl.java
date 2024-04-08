package com.example.demo.Device_Manager.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.Device_Manager.mapper.tb_dataMapper;
import com.example.demo.Device_Manager.service.tb_dataService;
import com.example.demo.Device_Manager.entity.tb_data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Hasee
* @description 针对表【tb_data】的数据库操作Service实现
* @createDate 2024-04-08 19:05:21
*/
@Service
public class tb_dataServiceImpl extends ServiceImpl<tb_dataMapper, tb_data>
    implements tb_dataService {


    @Autowired
    private tb_dataMapper dataMapper;

    @Override
    public List<tb_data> getLatestData() {
        return dataMapper.getLatestData();

    }

    @Override
    public List<tb_data> getChartData() {
        return dataMapper.getChartData();

    }

}




