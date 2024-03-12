package com.example.demo.device.mapper;
import com.example.demo.device.entity.DataEntity;
import com.example.demo.device.entity.SoilEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface SoilMapper {
    @Insert("INSERT INTO tb_soil (soil1,soil2,soil3,soil4,soil5,soil6,soil7,soil8,time) VALUES (#{soil1},#{soil2},#{soil3},#{soil4},#{soil5},#{soil6},#{soil7},#{soil8},#{time})")
    void insertData(SoilEntity soilEntity);



}
