package com.example.demo.device.control;

import java.time.LocalDateTime;

public class DataRequest {

    private LocalDateTime startTime;
    private LocalDateTime endTime;


    // Getters and Setters for startTime
    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    // Getters and Setters for endTime
    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }


}
