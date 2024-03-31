package com.example.demo.device.control;
import com.example.demo.device.entity.SoilEntity;
import com.example.demo.device.repository.Command1;
import com.example.demo.device.repository.CommandRepository;
import com.example.demo.device.response.SoilRequest;
import com.example.demo.device.service.SoilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.demo.device.service.Command_soil_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data1")
public class SoilController {
    private final SoilService soilService;
    private final CommandRepository commandRepository;

    private final Command_soil_Service commandSoilService;

    public SoilController(SoilService soilService, CommandRepository commandRepository,Command_soil_Service commandSoilService) {
        this.soilService = soilService;
        this.commandRepository = commandRepository;
        this.commandSoilService = commandSoilService;
    }


    @PostMapping("/insert_soil")
    public ResponseEntity<String> insertSoil(@RequestBody SoilRequest request) {
        SoilEntity soilEntity = new SoilEntity();
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

        // 记录有多少个设备读取到0
        int countZeroReadings = 0;

        // 判断每台设备是否都大于50，如果有读取到0的，则不进行比较该设备和标准值的关系，而是与其他设备比较
        for (int i = 1; i <= 8; i++) {
            if (request.getSoilByIndex(i).compareTo(BigDecimal.ZERO) == 0) {
                countZeroReadings++;
            }
        }

        boolean allAbove50 = true;

        // 如果有设备读取到0，则对其他设备进行比较
        if (countZeroReadings > 0) {
            for (int i = 1; i <= 8; i++) {
                if (request.getSoilByIndex(i).compareTo(BigDecimal.valueOf(25)) < 0 && request.getSoilByIndex(i).compareTo(BigDecimal.ZERO) != 0) {
                    allAbove50 = false;
                    break;
                }
            }
        } else {
            // 记录有多少个设备读取到50以下
            int countBelow50 = 0;
            for (int i = 1; i <= 8; i++) {
                if (request.getSoilByIndex(i).compareTo(BigDecimal.valueOf(25)) < 0) {
                    countBelow50++;
                }
            }

            // 如果有两个设备读取到0，则比较剩余6台的，以此类推
            if (countBelow50 >= 2) {
                allAbove50 = false;
            }
        }

        // 如果所有设备都大于50，则返回1，否则返回0
        String result = allAbove50 ? "1" : "0";

        // 将结果保存到tb_command表的command列
        Command1 command = new Command1();
        command.setCommand(result);
        command.setTime(LocalDateTime.now());
        commandRepository.save(command);

        // 返回处理结果
        return ResponseEntity.ok(result);
    }


//    @PostMapping("/insert_soil")
//    public ResponseEntity<String> insertSoil(@RequestBody SoilRequest request){
//        SoilEntity soilEntity = new SoilEntity();
//        soilEntity.setSoil1(request.getSoil1());
//        soilEntity.setSoil2(request.getSoil2());
//        soilEntity.setSoil3(request.getSoil3());
//        soilEntity.setSoil4(request.getSoil4());
//        soilEntity.setSoil5(request.getSoil5());
//        soilEntity.setSoil6(request.getSoil6());
//        soilEntity.setSoil7(request.getSoil7());
//        soilEntity.setSoil8(request.getSoil8());
//        soilEntity.setTime(LocalDateTime.now());
//        soilService.insertData(soilEntity);
//
//        // 判断每台设备是否都大于50
//        boolean allAbove50 = true;
//        for (int i = 1; i <= 8; i++) {
//            if (request.getSoilByIndex(i).compareTo(BigDecimal.valueOf(50)) < 0) {
//                allAbove50 = false;
//                break;
//            }
//        }
//
//        // 如果所有设备都大于50，则返回1，否则返回0
//        String result = allAbove50 ? "1" : "0";
//
//        // 将结果保存到tb_command表的command列
//        Command1 command = new Command1();
//        command.setCommand(result);
//        command.setTime(LocalDateTime.now());
//        commandRepository.save(command);
//
//        // 返回处理结果
//        return ResponseEntity.ok(result);
//    }

    @GetMapping("/soil")
    public String getLatestCommand() {
        return commandSoilService.getLatestCommand();
    }

}
