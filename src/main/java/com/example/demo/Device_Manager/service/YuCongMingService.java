package com.example.demo.Device_Manager.service;


import com.example.demo.Device_Manager.common.BaseResponse;
import com.example.demo.Device_Manager.model.DevChatRequest;
import com.example.demo.Device_Manager.model.DevChatResponse;

/**
 *
 */
public interface YuCongMingService {
    BaseResponse<DevChatResponse> talkToModel(DevChatRequest request);
}
