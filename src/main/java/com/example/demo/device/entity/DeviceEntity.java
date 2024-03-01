package com.example.demo.device.entity;

//import com.baomidou.mybatisplus.annotation.TableName;
//import lombok.Data;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "tb_device")
//@Data
//public class DeviceEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//    @Column(name = "deviceID", nullable = false, unique = true)
//    private Integer deviceID;
//
//    @Column(name = "account_id")
//    private Integer accountId;
//
//    @Column(name = "type")
//    private Long type;
//
//}





import javax.persistence.*;


@Entity
@Table(name = "tb_device")
public class DeviceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "deviceID", nullable = false, unique = true)
    private Integer deviceID;

    @Column(name = "account_id")
    private Integer accountId;

    @Column(name = "type")
    private Long type;

    // Setters and Getters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDeviceId() {
        return deviceID;
    }

    public void setDeviceId(Integer deviceID) {
        this.deviceID = deviceID;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }
}




