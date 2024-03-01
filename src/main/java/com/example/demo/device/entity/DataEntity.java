package com.example.demo.device.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Table(name = "tb_data")
public class DataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "device_id", nullable = false)
    private Integer deviceId;

    @Column(name = "create_time")
    private LocalDateTime create_time;

    @Column(name = "oxygen")
    private BigDecimal oxygen;

    @Column(name = "humidity")
    private BigDecimal humidity;

    @Column(name = "temperature")
    private BigDecimal temperature;

    @Column(name = "youji")
    private BigDecimal youji;

    @Column(name = "co2")
    private BigDecimal co2;

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public LocalDateTime getCreateTime() {
        return create_time;
    }

    public void setCreateTime(LocalDateTime create_time) {
        this.create_time = create_time;
    }

    public BigDecimal getOxygen() {
        return oxygen;
    }

    public void setOxygen(BigDecimal oxygen) {
        this.oxygen = oxygen;
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
}
