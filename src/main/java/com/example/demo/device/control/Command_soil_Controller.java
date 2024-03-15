package com.example.demo.device.control;

import com.example.demo.device.service.Command_soil_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/command1")
public class Command_soil_Controller {

    private final Command_soil_Service commandSoilService;

    @Autowired
    public Command_soil_Controller(Command_soil_Service commandSoilService) {
        this.commandSoilService = commandSoilService;
    }

    @GetMapping("/soil")
    public String getLatestCommand() {
        return commandSoilService.getLatestCommand();
    }
}

