package com.example.demo.device.service;

import com.example.demo.device.entity.CommandEntity;
import com.example.demo.device.mapper.CommandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CommandService {


    private final CommandMapper commandMapper;

    @Autowired
    public CommandService(CommandMapper commandMapper) {
        this.commandMapper = commandMapper;
    }

    @Transactional
    public void insertCommand(CommandEntity commandEntity) {
        commandMapper.insertCommand(commandEntity);
    }

    public CommandEntity getLatestCommand(String deviceId) {
        return commandMapper.findLatestCommandByDeviceId(deviceId);
    }



}
