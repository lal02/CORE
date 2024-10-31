package com.lalbr.learnifyTools.controller;

import com.lalbr.learnifyTools.model.SensorData.TemperatureModel;
import com.lalbr.learnifyTools.repository.TemperatureRepository;
import com.lalbr.learnifyTools.services.SensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class SensorDataController {

    @Autowired
    private SensorDataService sensorDataService;

    @PostMapping("/temperature")
    public ResponseEntity<TemperatureModel> createMyModel(@RequestBody TemperatureModel myModel) {
        TemperatureModel savedModel = sensorDataService.saveTemperatureModel(myModel);
        return ResponseEntity.ok(savedModel); // Return the saved model
    }
}
