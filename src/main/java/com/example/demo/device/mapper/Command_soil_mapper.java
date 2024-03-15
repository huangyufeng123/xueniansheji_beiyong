package com.example.demo.device.mapper;
import com.example.demo.device.entity.Command_soil_Entity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Command_soil_mapper extends BaseMapper<Command_soil_Entity> {

    @Select("SELECT command FROM command1 ORDER BY time DESC LIMIT 1")
    String getLatestCommand();
}
