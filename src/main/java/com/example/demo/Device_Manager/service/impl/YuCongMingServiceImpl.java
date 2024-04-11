package com.example.demo.Device_Manager.service.impl;



import com.example.demo.Device_Manager.client.YuCongMingClient;
import com.example.demo.Device_Manager.common.BaseResponse;
import com.example.demo.Device_Manager.model.DevChatRequest;
import com.example.demo.Device_Manager.model.DevChatResponse;
import com.example.demo.Device_Manager.service.YuCongMingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class YuCongMingServiceImpl implements YuCongMingService {

    private YuCongMingClient client;

    public YuCongMingServiceImpl(@Value("${accessKey}") String accessKey, @Value("${secretKey}") String secretKey) {
        this.client = new YuCongMingClient(accessKey, secretKey);
    }

    @Override
    public BaseResponse<DevChatResponse> talkToModel(DevChatRequest request) {
        return client.doChat(request);
    }
}




