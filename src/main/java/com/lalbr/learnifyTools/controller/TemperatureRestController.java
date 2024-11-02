package com.lalbr.learnifyTools.controller;

import com.lalbr.learnifyTools.model.SensorData.HumidityModel;
import com.lalbr.learnifyTools.model.SensorData.TemperatureModel;
import com.lalbr.learnifyTools.repository.SensorData.HumidityRepository;
import com.lalbr.learnifyTools.repository.SensorData.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TemperatureRestController {

    @Autowired
    TemperatureRepository temperatureRepository;

    @Autowired
    HumidityRepository humidityRepository;

    @GetMapping("/api/temperatur")
    public List<TemperatureModel> getTemperatureData() {
        return temperatureRepository.findAll();
    }
    @GetMapping("/api/humidity")
    public List<HumidityModel> getHumidityData() {
        return humidityRepository.findAll();
    }
}
