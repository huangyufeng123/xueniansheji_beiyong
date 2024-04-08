package com.example.demo.Device_Manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.Device_Manager.entity.tb_data;

import org.apache.ibatis.annotations.*;
import java.util.List;

/**
* @author Hasee
* @description 针对表【tb_data】的数据库操作Mapper
* @createDate 2024-04-08 19:05:21
* @Entity com.example.demo.Device_Manager.entity.tb_data
*/
@Mapper
public interface tb_dataMapper extends BaseMapper<tb_data> {

    @Select("SELECT * FROM tb_data ORDER BY id DESC LIMIT 60")
    List<tb_data> getChartData();

    @Select("SELECT * FROM tb_data ORDER BY id DESC LIMIT 1")
    List<tb_data> getLatestData();

}




