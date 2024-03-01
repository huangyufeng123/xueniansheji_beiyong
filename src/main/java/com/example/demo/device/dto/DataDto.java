package com.example.demo.device.dto;

// Imports
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

public class DataDto implements Serializable {
    private Double temperature;
    private Integer device_id;
    private Double humidity;
    private Double oxygen;
    private Double co2;
    private Double youji;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    public DataDto() {
        // Default constructor for serialization
    }

    public DataDto(Double temperature, Double humidity,Double co2,Integer device_id, Double oxygen, Double youji, LocalDateTime createTime) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.co2=co2;
        this.device_id=device_id;
        this.oxygen = oxygen;
        this.youji=youji;
        this.createTime = createTime;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Integer getDevice_id() {
        return device_id;
    }

    public void setDevice_id(Integer device_id) {
        this.device_id = device_id;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getYouji() {
        return youji;
    }

    public void setYouji(Double youji) {
        this.youji = youji;
    }

    public Double getOxygen() {
        return oxygen;
    }

    public void setCo2(Double co2) {
        this.co2 = co2;
    }

    public Double getCo2() {
        return co2;
    }

    public void setOxygen(Double oxygen) {
        this.oxygen = oxygen;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }


}
