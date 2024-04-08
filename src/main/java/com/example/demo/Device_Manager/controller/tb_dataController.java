package com.example.demo.Device_Manager.controller;

import com.example.demo.Device_Manager.common.ResultUtils;
import com.example.demo.Device_Manager.common.BaseResponse;
import com.example.demo.Device_Manager.common.ErrorCode;
import com.example.demo.Device_Manager.entity.tb_data;
import com.example.demo.Device_Manager.service.tb_dataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/data")
public class tb_dataController {
    @Autowired
    private tb_dataService dataService;

    @PostMapping("/insertData")
    public BaseResponse<String> insertData(@RequestBody tb_data data) {
        data.setCreate_time(new Date());
        boolean isSaved = dataService.save(data);
        if(isSaved){
            return ResultUtils.success("Data inserted successfully");
        } else {
            return ResultUtils.error(ErrorCode.PARAMS_ERROR, "Failed to insert data", "Check data exists or correct");
        }
    }

    @GetMapping("/latestData")
    public BaseResponse<List<tb_data>> getLatestData() {
        List<tb_data> data = dataService.getLatestData();
        if(data != null && !data.isEmpty()){
            return ResultUtils.success(data);
        } else {
            return ResultUtils.error(ErrorCode.NULL_ERROR, "No data found", "Data list is empty");
        }
    }

    @GetMapping("/chartData")
    public BaseResponse<List<tb_data>> getChartData(){
        List<tb_data> data=dataService.getChartData();
        if(data !=null && !data.isEmpty()){
            return ResultUtils.success(data);
        }
        else {
            return ResultUtils.error(ErrorCode.NULL_ERROR,"No data found","Data list is empty");
        }
    }
}