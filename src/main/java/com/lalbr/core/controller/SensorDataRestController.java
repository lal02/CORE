package com.lalbr.core.controller;

import com.lalbr.core.model.SensorData.HumidityModel;
import com.lalbr.core.model.SensorData.LightModel;
import com.lalbr.core.model.SensorData.SoilHumidityModel;
import com.lalbr.core.model.SensorData.TemperatureModel;
import com.lalbr.core.services.SensorDataService;
import com.lalbr.core.util.TimeSpan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SensorDataRestController {


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

    @GetMapping("/api/temperatur/week")
    public List<TemperatureModel> getTemperatureDataWeek()throws Exception {
        return sensorDataService.getTemperatureData(TimeSpan.WEEK);
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

    @GetMapping("/api/humidity/week")
    public List<HumidityModel> getHumidityDataWeek()throws Exception {
        return sensorDataService.getHumidityData(TimeSpan.WEEK);
    }

    @GetMapping("/api/humidity/month")
    public List<HumidityModel> getHumidityDataMonth() throws Exception {
        return sensorDataService.getHumidityData(TimeSpan.THIS_MONTH);
    }

    @GetMapping("/api/humidity/year")
    public List<HumidityModel> getHumidityDataYear() throws Exception {
        return sensorDataService.getHumidityData(TimeSpan.THIS_YEAR);
    }

    /*
        SOIL HUMIDITY ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    @GetMapping("/api/soilhumidity/all")
    public List<SoilHumidityModel> getSoilHumidityDataAll() throws Exception {
        return sensorDataService.getSoilHumidityData(TimeSpan.ALL);
    }
    @GetMapping("/api/soilhumidity/today")
    public List<SoilHumidityModel> getSoilHumidityDataToday() throws Exception {
        return sensorDataService.getSoilHumidityData(TimeSpan.TODAY);
    }

    @GetMapping("/api/soilhumidity/week")
    public List<SoilHumidityModel> getSoilHumidityDataWeek()throws Exception {
        return sensorDataService.getSoilHumidityData(TimeSpan.WEEK);
    }

    @GetMapping("/api/soilhumidity/month")
    public List<SoilHumidityModel> getSoilHumidityDataMonth() throws Exception {
        return sensorDataService.getSoilHumidityData(TimeSpan.THIS_MONTH);
    }
    @GetMapping("/api/soilhumidity/year")
    public List<SoilHumidityModel> getSoilHumidityDataYear() throws Exception {
        return sensorDataService.getSoilHumidityData(TimeSpan.THIS_YEAR);
    }
    /*
        LIGHT DATA ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */

    @GetMapping("/api/light/all")
    public List<LightModel> getLightDataAll() throws Exception {
        return sensorDataService.getLightData(TimeSpan.ALL);
    }
    @GetMapping("/api/light/today")
    public List<LightModel> getLightDataToday() throws Exception {
        return sensorDataService.getLightData(TimeSpan.TODAY);
    }

    @GetMapping("/api/light/week")
    public List<LightModel> getLightDataWeek()throws Exception {
        return sensorDataService.getLightData(TimeSpan.WEEK);
    }

    @GetMapping("/api/light/month")
    public List<LightModel> getLightDataMonth() throws Exception {
        return sensorDataService.getLightData(TimeSpan.THIS_MONTH);
    }
    @GetMapping("/api/light/year")
    public List<LightModel> getLightDataYear() throws Exception {
        return sensorDataService.getLightData(TimeSpan.THIS_YEAR);
    }
}
