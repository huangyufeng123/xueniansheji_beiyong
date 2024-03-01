package com.example.demo.device.response;

import java.math.BigDecimal;

public class DataInsertRequest {
    private String name;
    private Integer deviceID;
    private Long type;
    private BigDecimal humidity;
    private BigDecimal oxygen;
    private BigDecimal temperature;
    private BigDecimal youji;
    private BigDecimal co2;
    private Integer data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDeviceID() {
        return deviceID;
    }


    public void setDeviceID(Integer deviceID) {
        this.deviceID = deviceID;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public BigDecimal getHumidity() {
        return humidity;
    }

    public void setHumidity(BigDecimal humidity) {
        this.humidity = humidity;
    }


    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    public BigDecimal getOxygen() {
        return oxygen;
    }

    public void setOxygen(BigDecimal oxygen) {
        this.oxygen = oxygen;
    }


    public BigDecimal getYouji() {
        return youji;
    }

    public void setYouji(BigDecimal youji) {
        this.youji = youji;
    }


    public BigDecimal getCo2() {
        return co2;
    }

    public void setCo2(BigDecimal co2) {
        this.co2 = co2;
    }


    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }




}
