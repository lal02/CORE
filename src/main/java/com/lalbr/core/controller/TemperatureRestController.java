package com.lalbr.core.controller;

import com.lalbr.core.model.SensorData.HumidityModel;
import com.lalbr.core.model.SensorData.TemperatureModel;
import com.lalbr.core.services.SensorDataService;
import com.lalbr.core.util.TimeSpan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TemperatureRestController {


    @Autowired
    SensorDataService sensorDataService;

    @GetMapping("/api/temperatur/all")
    public List<TemperatureModel> getTemperatureData() throws Exception {
        return sensorDataService.getTemperatureData(TimeSpan.ALL);
    }

    @GetMapping("/api/temperatur/today")
    public List<TemperatureModel> getTemperatureDataToday()throws Exception {
        return sensorDataService.getTemperatureData(TimeSpan.TODAY);
    }

    @GetMapping("/api/temperatur/month")
    public List<TemperatureModel> getTemperatureDataMonth()throws Exception{
        return sensorDataService.getTemperatureData(TimeSpan.THIS_MONTH);
    }

    @GetMapping("/api/temperatur/year")
    public List<TemperatureModel> getTemperatureDataYear() throws Exception{
        return sensorDataService.getTemperatureData(TimeSpan.THIS_YEAR);
    }


    /*
        HUMIDITY ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */

    @GetMapping("/api/humidity/all")
    public List<HumidityModel> getHumidityData() throws Exception {
        return sensorDataService.getHumidityData(TimeSpan.ALL);
    }

    @GetMapping("/api/humidity/today")
    public List<HumidityModel> getHumidityDataToday() throws Exception {
        return sensorDataService.getHumidityData(TimeSpan.TODAY);
    }

    @GetMapping("/api/humidity/month")
    public List<HumidityModel> getHumidityDataMonth() throws Exception {
        return sensorDataService.getHumidityData(TimeSpan.THIS_MONTH);
    }

    @GetMapping("/api/humidity/year")
    public List<HumidityModel> getHumidityDataYear() throws Exception {
        return sensorDataService.getHumidityData(TimeSpan.THIS_YEAR);
    }


}
