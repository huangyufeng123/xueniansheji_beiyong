package com.example.demo.device.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@Table(name = "imagedata")
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;


    @Lob
    @Column(name = "image", nullable = true)
    private byte[] image;


    @Column(name = "time")
    private LocalDateTime time;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public byte[] getImage() {
        return image;
    }

    public LocalDateTime getCreate_time() {
        return time;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setCreate_time(LocalDateTime time) {
        this.time = time;
    }
}
