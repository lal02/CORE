package com.lalbr.core.sensordata;

import com.lalbr.core.sensordata.airquality.AirqualityModel;
import com.lalbr.core.sensordata.carbonmonoxide.COModel;
import com.lalbr.core.sensordata.humidity.HumidityModel;
import com.lalbr.core.sensordata.light.LightModel;
import com.lalbr.core.sensordata.soilhumidity.SoilHumidityModel;
import com.lalbr.core.sensordata.temperature.TemperatureModel;
import com.lalbr.core.util.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class  SensorDataController {

    @Autowired
    private SensorDataService sensorDataService;

    @Autowired
    private MailSenderService mailSenderService;

    private int humiditySensor1Counter;
    private int humiditySensor2Counter;

    @GetMapping(value={"/sensordata","/sensor","/sensorData","/Sensor","/SensorData","/Sensordata"})
    public String getSensorData() {
        return "sensordata";
    }

    @PostMapping("/temperature")
    public ResponseEntity<TemperatureModel> createMyModel(@RequestBody TemperatureModel myModel) {
        TemperatureModel savedModel = sensorDataService.saveTemperatureModel(myModel);
        if(savedModel.getValue()<18.5){
            String timestamp = "" + savedModel.getTimestamp();
            String subject = "Low Temperature Warning " + timestamp.substring(timestamp.length()-8,timestamp.length()-3);
            String content = "Warning, temperature is only " + savedModel.getValue() + "°C";
            mailSenderService.sendMailMessage(subject,content);
        }

        return ResponseEntity.ok(savedModel);
    }

    @PostMapping("/humidity")
    public ResponseEntity<HumidityModel> createMyModel(@RequestBody HumidityModel myModel) {
        HumidityModel savedModel = sensorDataService.saveHumidityModel(myModel);
        // send mail notification
        if(savedModel.getValue()>75){
            String timestamp = "" + savedModel.getTimestamp();
            String subject = "Humidity Warning " + timestamp.substring(timestamp.length()-8,timestamp.length()-3);
            String content = "Warning, humidity is " + savedModel.getValue() + "%";
            mailSenderService.sendMailMessage(subject,content);
        }
        return ResponseEntity.ok(savedModel);
    }

    @PostMapping("/soilhumidity")
    public ResponseEntity<SoilHumidityModel> createMyModel(@RequestBody SoilHumidityModel myModel) {
        SoilHumidityModel savedModel = sensorDataService.saveSoilHumidityModel(myModel);

        // send mail notification
        if(savedModel.getValue()>1000){
            if((savedModel.getSensorid() == 1 && humiditySensor1Counter==3) || (savedModel.getSensorid() == 2 && humiditySensor2Counter==3)){
                String timestamp = "" + savedModel.getTimestamp();
                String subject = "Soil Humidity Warning " + timestamp.substring(timestamp.length()-8,timestamp.length()-3);
                String content = "Warning, soil humidity of sensor + " + savedModel.getSensorid() + " is " + savedModel.getValue();
                mailSenderService.sendMailMessage(subject,content);
                if(savedModel.getSensorid() == 1){
                    humiditySensor1Counter = 0;
                }
                if(savedModel.getSensorid() == 2){
                    humiditySensor2Counter = 0;
                }
            }
            else{
                if(savedModel.getSensorid() == 1){
                    humiditySensor1Counter++;
                }
                if(savedModel.getSensorid() == 2){
                    humiditySensor2Counter++;
                }
            }
        }
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
