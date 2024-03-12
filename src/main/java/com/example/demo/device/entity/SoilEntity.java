package com.example.demo.device.entity;
import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@Table(name = "tb_soil")
public class SoilEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;


    @Column(name = "time")
    private LocalDateTime time;


    @Column(name = "soil1")
    private BigDecimal soil1;


    @Column(name = "soil2")
    private BigDecimal soil2;


    @Column(name = "soil3")
    private BigDecimal soil3;


    @Column(name = "soil4")
    private BigDecimal soil4;


    @Column(name = "soil5")
    private BigDecimal soil5;


    @Column(name = "soil6")
    private BigDecimal soil6;


    @Column(name = "soil7")
    private BigDecimal soil7;

    @Column(name = "soil8")
    private BigDecimal soil8;

    public BigDecimal getSoil1() {
        return soil1;
    }

    public BigDecimal getSoil2() {
        return soil2;
    }

    public BigDecimal getSoil3() {
        return soil3;
    }

    public BigDecimal getSoil4() {
        return soil4;
    }

    public BigDecimal getSoil5() {
        return soil5;
    }

    public BigDecimal getSoil6() {
        return soil6;
    }

    public BigDecimal getSoil7() {
        return soil7;
    }

    public BigDecimal getSoil8() {
        return soil8;
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSoil1(BigDecimal soil1) {
        this.soil1 = soil1;
    }

    public void setSoil2(BigDecimal soil2) {
        this.soil2 = soil2;
    }

    public void setSoil3(BigDecimal soil3) {
        this.soil3 = soil3;
    }

    public void setSoil4(BigDecimal soil4) {
        this.soil4 = soil4;
    }

    public void setSoil5(BigDecimal soil5) {
        this.soil5 = soil5;
    }

    public void setSoil6(BigDecimal soil6) {
        this.soil6 = soil6;
    }

    public void setSoil7(BigDecimal soil7) {
        this.soil7 = soil7;
    }

    public void setSoil8(BigDecimal soil8) {
        this.soil8 = soil8;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
