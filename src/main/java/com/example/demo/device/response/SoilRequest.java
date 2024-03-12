package com.example.demo.device.response;
import java.math.BigDecimal;

public class SoilRequest {
    private BigDecimal soil1;
    private BigDecimal soil2;
    private BigDecimal soil3;
    private BigDecimal soil4;
    private BigDecimal soil5;
    private BigDecimal soil6;
    private BigDecimal soil7;
    private BigDecimal soil8;

    public void setSoil8(BigDecimal soil8) {
        this.soil8 = soil8;
    }

    public void setSoil7(BigDecimal soil7) {
        this.soil7 = soil7;
    }

    public void setSoil6(BigDecimal soil6) {
        this.soil6 = soil6;
    }

    public void setSoil5(BigDecimal soil5) {
        this.soil5 = soil5;
    }

    public void setSoil4(BigDecimal soil4) {
        this.soil4 = soil4;
    }

    public void setSoil3(BigDecimal soil3) {
        this.soil3 = soil3;
    }

    public void setSoil2(BigDecimal soil2) {
        this.soil2 = soil2;
    }

    public void setSoil1(BigDecimal soil1) {
        this.soil1 = soil1;
    }

    public BigDecimal getSoil8() {
        return soil8;
    }

    public BigDecimal getSoil7() {
        return soil7;
    }

    public BigDecimal getSoil6() {
        return soil6;
    }

    public BigDecimal getSoil5() {
        return soil5;
    }

    public BigDecimal getSoil4() {
        return soil4;
    }

    public BigDecimal getSoil3() {
        return soil3;
    }

    public BigDecimal getSoil2() {
        return soil2;
    }

    public BigDecimal getSoil1() {
        return soil1;
    }

    // 根据索引获取土壤值
    public BigDecimal getSoilByIndex(int index) {
        switch (index) {
            case 1:
                return soil1;
            case 2:
                return soil2;
            case 3:
                return soil3;
            case 4:
                return soil4;
            case 5:
                return soil5;
            case 6:
                return soil6;
            case 7:
                return soil7;
            case 8:
                return soil8;
            default:
                throw new IllegalArgumentException("Invalid index: " + index);
        }
    }
}
