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

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "device_id", referencedColumnName = "id")
//    private DeviceEntity device;

    @Column(name = "device_id", nullable = false)
    private Integer deviceId;






    public LocalDateTime getCreateTime() {
        return create_time;
    }

    public void setCreateTime(LocalDateTime create_time) {
        this.create_time = create_time;
    }

}



//package com.example.demo.device.entity;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "tb_command")
//public class CommandEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @Column(name = "data")
//    private String data;
//
//    @Column(name = "create_time")
//    private LocalDateTime createTime;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "device_id", referencedColumnName = "id")
//    private DeviceEntity device;
//
//    // Getters and Setters
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getData() {
//        return data;
//    }
//
//    public void setData(String data) {
//        this.data = data;
//    }
//
//    public LocalDateTime getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(LocalDateTime createTime) {
//        this.createTime = createTime;
//    }
//
//    public DeviceEntity getDevice() {
//        return device;
//    }
//
//    public void setDevice(DeviceEntity device) {
//        this.device = device;
//    }
//}
//
