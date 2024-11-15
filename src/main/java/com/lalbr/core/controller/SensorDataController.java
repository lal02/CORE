package com.lalbr.core.controller;

import com.lalbr.core.model.SensorData.HumidityModel;
import com.lalbr.core.model.SensorData.TemperatureModel;
import com.lalbr.core.repository.SensorData.TemperatureRepository;
import com.lalbr.core.services.SensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class  SensorDataController {

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
