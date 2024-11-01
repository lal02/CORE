package com.lalbr.learnifyTools.controller;

import com.lalbr.learnifyTools.model.SensorData.HumidityModel;
import com.lalbr.learnifyTools.model.SensorData.TemperatureModel;
import com.lalbr.learnifyTools.repository.SensorData.TemperatureRepository;
import com.lalbr.learnifyTools.services.SensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class SensorDataController {

    @Autowired
    private SensorDataService sensorDataService;
    @Autowired
    private TemperatureRepository temperatureRepository;

    @PostMapping("/temperature")
    public ResponseEntity<TemperatureModel> createMyModel(@RequestBody TemperatureModel myModel) {
        TemperatureModel savedModel = sensorDataService.saveTemperatureModel(myModel);
        return ResponseEntity.ok(savedModel); // Return the saved model
    }

    @PostMapping("/humidity")
    public ResponseEntity<HumidityModel> createMyModel(@RequestBody HumidityModel myModel) {
        HumidityModel savedModel = sensorDataService.saveHumidityModel(myModel);
        return ResponseEntity.ok(savedModel); // Return the saved model
    }

    @GetMapping("/sensordata")
    public String getSensorData() {
        return "sensordata";
    }


}
