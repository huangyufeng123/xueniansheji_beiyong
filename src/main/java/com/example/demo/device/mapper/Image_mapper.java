package com.example.demo.device.mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.type.JdbcType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.device.entity.ImageEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.example.demo.device.dto.ImageDto;

@Mapper
public interface Image_mapper extends BaseMapper<ImageEntity> {
    @Insert("INSERT INTO imagedata (image,time) VALUES (#{image},#{time})")
    void insertData(ImageEntity imageEntity);

    @Select("SELECT image,time FROM imagedata ORDER BY time DESC LIMIT 1")
    @Results(value = {
            @Result(property = "createTime", column = "time", javaType = LocalDateTime.class, jdbcType = JdbcType.TIMESTAMP),
    })
    ImageDto findLatest();
}
