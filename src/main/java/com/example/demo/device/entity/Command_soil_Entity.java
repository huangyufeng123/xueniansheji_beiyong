package com.example.demo.device.entity;
import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@Table(name ="command1")
public class Command_soil_Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;


    @Column(name = "time")
    private LocalDateTime time;

    @Column(name = "command")
    private BigDecimal command;

    public BigDecimal getCommand() {
        return command;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Integer getId() {
        return id;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCommand(BigDecimal command) {
        this.command = command;
    }
}
