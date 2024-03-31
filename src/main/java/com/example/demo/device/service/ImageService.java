package com.example.demo.device.service;

import com.example.demo.device.dto.ImageDto;
import com.example.demo.device.entity.ImageEntity;
import com.example.demo.device.mapper.Image_mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ImageService {

    private final Image_mapper imageMapper;

    @Autowired
    public ImageService(Image_mapper imageMapper) {
        this.imageMapper = imageMapper;
    }

    @Transactional
    public void insertData(ImageEntity imageEntity) {
        imageMapper.insertData(imageEntity);
    }

    public ImageDto getLatest() {
        return imageMapper.findLatest();
    }
}
