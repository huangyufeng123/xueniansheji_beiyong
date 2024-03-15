package com.example.demo.device.service;

import com.example.demo.device.mapper.Command_soil_mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Command_soil_Service {

    private final Command_soil_mapper commandSoilMapper;

    @Autowired
    public Command_soil_Service(Command_soil_mapper commandSoilMapper) {
        this.commandSoilMapper = commandSoilMapper;
    }

    public String getLatestCommand() {
        return commandSoilMapper.getLatestCommand();
    }
}

