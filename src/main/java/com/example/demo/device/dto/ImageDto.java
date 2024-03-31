package com.example.demo.device.dto;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
public class ImageDto {
    private byte[] image;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    public ImageDto() {
        // Default constructor for serialization
    }

    public ImageDto(byte[] image){
        this.image=image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public byte[] getImage() {
        return image;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
