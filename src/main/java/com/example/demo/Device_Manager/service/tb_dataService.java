package com.example.demo.Device_Manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.Device_Manager.entity.tb_data;

import java.util.List;

/**
* @author Hasee
* @description 针对表【tb_data】的数据库操作Service
* @createDate 2024-04-08 19:05:21
*/
public interface tb_dataService extends IService<tb_data> {

    List<tb_data> getLatestData();


    List<tb_data> getChartData();

}
