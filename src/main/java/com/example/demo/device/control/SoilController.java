package com.example.demo.device.control;
import com.example.demo.device.entity.SoilEntity;
import com.example.demo.device.response.ControlResponse;
import com.example.demo.device.response.SoilRequest;
import com.example.demo.device.service.SoilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/data1")
public class SoilController {
    private final SoilService soilService;

    @Autowired
    public SoilController(SoilService soilService){
        this.soilService=soilService;
    }

    @PostMapping("/insert_soil")
    public ResponseEntity<String> insertSoil(@RequestBody SoilRequest request){
        SoilEntity soilEntity=new SoilEntity();
        soilEntity.setSoil1(request.getSoil1());
        soilEntity.setSoil2(request.getSoil2());
        soilEntity.setSoil3(request.getSoil3());
        soilEntity.setSoil4(request.getSoil4());
        soilEntity.setSoil5(request.getSoil5());
        soilEntity.setSoil6(request.getSoil6());
        soilEntity.setSoil7(request.getSoil7());
        soilEntity.setSoil8(request.getSoil8());
        soilEntity.setTime(LocalDateTime.now());
        soilService.insertData(soilEntity);
        // 计算平均值
        BigDecimal sum = request.getSoil1().add(request.getSoil2()).add(request.getSoil3()).add(request.getSoil4())
                .add(request.getSoil5()).add(request.getSoil6()).add(request.getSoil7()).add(request.getSoil8());
        BigDecimal average = sum.divide(BigDecimal.valueOf(8), 2, RoundingMode.HALF_UP); // 保留两位小数

        // 创建 StringBuilder 用于构建返回的指令
        StringBuilder result = new StringBuilder();

        // 遍历各个索引，比较平均值并构建指令
        for (int i = 1; i <= 8; i++) {
            result.append(i).append(":");
            if (average.compareTo(request.getSoilByIndex(i)) > 0) {
                result.append("high");
            } else {
                result.append("low");
            }
            // 添加逗号分隔符
            if (i != 8) {
                result.append(",");
            }
        }

        return ResponseEntity.ok(result.toString());

    }
}
