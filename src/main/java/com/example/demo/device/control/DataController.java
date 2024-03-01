package com.example.demo.device.control;
import com.example.demo.device.dto.DataDto;
import com.example.demo.device.response.DataControllerResponse;
import com.example.demo.device.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/data")
public class DataController {

    @Autowired
    private DataService dataService;

    @GetMapping("/chart-data")
    public DataControllerResponse<List<DataDto>> getDataForChart() {
        List<DataDto> data = dataService.getAllTemperatureHumidityOxygen();
        LocalDateTime createTime = data.get(0).getCreateTime(); // 获取第一个数据点的创建时间
        return new DataControllerResponse<>("success", "Request completed", 200, data, createTime);
    }

    @GetMapping("/latest-data")
    public DataControllerResponse<DataDto> getLatestData() {
        DataDto latestData = dataService.getLatestTemperatureHumidityOxygen();
        LocalDateTime createTime = latestData != null ? latestData.getCreateTime() : LocalDateTime.now();
        return latestData != null ?
                new DataControllerResponse<>("success", "Request completed", 200, latestData,createTime) :
                new DataControllerResponse<>("error", "No data available", 404, null,createTime);
    }


    @PostMapping("/range_time")
    public DataControllerResponse<List<DataDto>> getDataInTimeRange(@RequestBody DataRequest request) {
        LocalDateTime startTime = request.getStartTime();
        LocalDateTime endTime = request.getEndTime();
        List<DataDto> dataInRange = dataService.findDataByTimeRange(startTime, endTime);


        return new DataControllerResponse<>("success", "Request completed", 200, dataInRange, startTime);

    }



}



