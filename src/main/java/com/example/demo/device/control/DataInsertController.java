package com.example.demo.device.control;
import com.example.demo.device.entity.DataEntity;
import com.example.demo.device.entity.DeviceEntity;
import com.example.demo.device.entity.CommandEntity;
//import com.example.demo.device.sql.entity.HumidityEntity;
import com.example.demo.device.response.ControlResponse;
import com.example.demo.device.response.DataInsertRequest;
import com.example.demo.device.service.DataInsertService;
import com.example.demo.device.service.DeviceService;
import com.example.demo.device.service.CommandService;
//import com.example.demo.device.sql.service.HumidityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/data")
public class DataInsertController {
    private final DeviceService deviceService;
    private final DataInsertService dataInsertService;
    private final CommandService commandService;
    private boolean ledState = false;
    @Autowired
    public DataInsertController(DeviceService deviceService, DataInsertService dataInsertService,CommandService commandService) {
        this.deviceService = deviceService;
        this.dataInsertService = dataInsertService;
        this.commandService=commandService;
    }


    @GetMapping("/command/{deviceId}")
    public ResponseEntity<Integer> getLatestCommand(@PathVariable("deviceId") String deviceId) {
        CommandEntity latestCommand = commandService.getLatestCommand(deviceId);

        if (latestCommand != null) {
            return ResponseEntity.ok(latestCommand.getData());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    private ControlResponse generateControlResponse(DataInsertRequest request) {
        // 创建并设置控制响应对象
        ControlResponse controlResponse = new ControlResponse();
        controlResponse.setCommand("YourCommandHere");
        // 设置其他字段
        return controlResponse;
    }

    @PostMapping("/insert_data1")
    public ResponseEntity<String> insertData1(@RequestBody DataInsertRequest request) {
        // Insert device.sql data
        DeviceEntity deviceEntity = new DeviceEntity();
        deviceEntity.setName(request.getName());
        deviceEntity.setDeviceId(request.getDeviceID());
        deviceEntity.setType(request.getType());
        deviceService.insertDeviceData(deviceEntity);
        // Insert CO2 data
        DataEntity dataEntity = new DataEntity();
        dataEntity.setDeviceId(request.getDeviceID());
//        co2Entity.setDevice(deviceEntity); // Set the device.sql entity
        dataEntity.setHumidity(request.getHumidity());
        dataEntity.setTemperature(request.getTemperature());
        dataEntity.setOxygen(request.getOxygen());
        dataEntity.setYouji(request.getYouji());
        dataEntity.setCo2(request.getCo2());

        dataEntity.setCreateTime(LocalDateTime.now());
        dataInsertService.insertData(dataEntity);
        CommandEntity commandEntity=new CommandEntity();
        commandEntity.setDeviceId(request.getDeviceID());
        commandEntity.setData(request.getData());
        commandEntity.setCreateTime(LocalDateTime.now());
        commandService.insertCommand(commandEntity);

        // 修改设置标准规定值部分
        final BigDecimal standard_humidity = BigDecimal.valueOf(50);
        final BigDecimal standard_temperature = BigDecimal.valueOf(50);
        final BigDecimal standard_oxygen = BigDecimal.valueOf(50);
        final BigDecimal standard_youji = BigDecimal.valueOf(50);
        final BigDecimal standard_co2 = BigDecimal.valueOf(50);
        String msg1 = request.getHumidity().compareTo(standard_humidity) < 0 ? "1" : "11";  //humiditty,1代表缺失，11代表正常
        String msg2 = request.getCo2().compareTo(standard_co2) < 0 ? "2" : "22";   //co2

        String msg3 = request.getCo2().compareTo(standard_temperature) < 0 ? "3" : "33";  //temperature
        String msg4 = request.getCo2().compareTo(standard_oxygen) < 0 ? "4" : "44";  //oxygen
        String msg5 = request.getCo2().compareTo(standard_youji) < 0 ? "5" : "55";  //youji
        String combinedMsg = msg1 + ", " + msg2+", "+msg3+", "+msg4+", "+msg5;


        return new ResponseEntity<>(combinedMsg, HttpStatus.CREATED);

    }


//    private ControlResponse generateControlResponse(DataInsertRequest request) {
//        ControlResponse controlResponse = new ControlResponse();
//        // 设置控制响应数据，例如命令等
//        return controlResponse;
//    }
//
//
//
//    private void sendControlResponseToDevice2(ControlResponse controlResponse) {
//        // 使用WebSocket发送JSON响应
//        messagingTemplate.convertAndSend("/topic/device2", controlResponse);
//    }

}
