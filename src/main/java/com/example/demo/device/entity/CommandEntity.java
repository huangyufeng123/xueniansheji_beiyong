package com.example.demo.device.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
@Table(name = "tb_command")

public class CommandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "data")
    private Integer data;

    @Column(name = "create_time")
    private LocalDateTime create_time;


    @Column(name = "device_id", nullable = false)
    private Integer deviceId;




    public LocalDateTime getCreateTime() {
        return create_time;
    }

    public void setCreateTime(LocalDateTime create_time) {
        this.create_time = create_time;
    }

}

