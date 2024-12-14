package com.lalbr.core.sensordata;

import com.lalbr.core.sensordata.airquality.AirqualityModel;
import com.lalbr.core.sensordata.carbonmonoxide.COModel;
import com.lalbr.core.sensordata.humidity.HumidityModel;
import com.lalbr.core.sensordata.light.LightModel;
import com.lalbr.core.sensordata.soilhumidity.SoilHumidityModel;
import com.lalbr.core.sensordata.temperature.TemperatureModel;
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

    @GetMapping(value={"/sensordata","/sensor","/sensorData","/Sensor","/SensorData","/Sensordata"})
    public String getSensorData() {
        return "sensordata";
    }

    @PostMapping("/temperature")
    public ResponseEntity<TemperatureModel> createMyModel(@RequestBody TemperatureModel myModel) {
        TemperatureModel savedModel = sensorDataService.saveTemperatureModel(myModel);
        return ResponseEntity.ok(savedModel); // Return the saved model
    }

    @PostMapping("/humidity")
    public ResponseEntity<HumidityModel> createMyModel(@RequestBody HumidityModel myModel) {
        HumidityModel savedModel = sensorDataService.saveHumidityModel(myModel);
        if(savedModel.getValue()>75){
            //send mail TODO
            System.out.println("lüften");
        }
        return ResponseEntity.ok(savedModel);
    }

    @PostMapping("/soilhumidity")
    public ResponseEntity<SoilHumidityModel> createMyModel(@RequestBody SoilHumidityModel myModel) {
        SoilHumidityModel savedModel = sensorDataService.saveSoilHumidityModel(myModel);
        return ResponseEntity.ok(savedModel);
    }
    @PostMapping("/light")
    public ResponseEntity<LightModel> createMyModel(@RequestBody LightModel myModel) {
        LightModel savedModel = sensorDataService.saveLightModel(myModel);
        return ResponseEntity.ok(savedModel);
    }

    @PostMapping("/co")
    public ResponseEntity<COModel> createMyModel(@RequestBody COModel myModel) {
        COModel savedModel = sensorDataService.saveCOModel(myModel);
        return ResponseEntity.ok(savedModel);
    }

    @PostMapping("/airquality")
    public ResponseEntity<AirqualityModel> createMyModel(@RequestBody AirqualityModel myModel) {
        AirqualityModel savedModel = sensorDataService.saveAirqualityModel(myModel);
        return ResponseEntity.ok(savedModel);
    }




}
