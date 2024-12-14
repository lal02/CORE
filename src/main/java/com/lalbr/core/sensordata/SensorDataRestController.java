package com.lalbr.core.sensordata;

import com.lalbr.core.sensordata.airquality.AirqualityModel;
import com.lalbr.core.sensordata.carbonmonoxide.COModel;
import com.lalbr.core.sensordata.humidity.HumidityModel;
import com.lalbr.core.sensordata.light.LightModel;
import com.lalbr.core.sensordata.soilhumidity.SoilHumidityModel;
import com.lalbr.core.sensordata.temperature.TemperatureModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        SOIL HUMIDITY RIGHT PLANT ( SENSORID 0) ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    @GetMapping("/api/soilhumidity/all/{sensorid}")
    public List<SoilHumidityModel> getSoilHumidityDataAll(@PathVariable int sensorid) throws Exception {
        return sensorDataService.getSoilHumidityData(TimeSpan.ALL,sensorid);
    }
    @GetMapping("/api/soilhumidity/today/{sensorid}")
    public List<SoilHumidityModel> getSoilHumidityDataToday(@PathVariable int sensorid) throws Exception {
        return sensorDataService.getSoilHumidityData(TimeSpan.TODAY,sensorid);
    }

    @GetMapping("/api/soilhumidity/week/{sensorid}")
    public List<SoilHumidityModel> getSoilHumidityDataWeek(@PathVariable int sensorid)throws Exception {
        return sensorDataService.getSoilHumidityData(TimeSpan.WEEK,sensorid);
    }

    @GetMapping("/api/soilhumidity/month/{sensorid}")
    public List<SoilHumidityModel> getSoilHumidityDataMonth(@PathVariable int sensorid) throws Exception {
        return sensorDataService.getSoilHumidityData(TimeSpan.THIS_MONTH,sensorid);
    }
    @GetMapping("/api/soilhumidity/year/{sensorid}")
    public List<SoilHumidityModel> getSoilHumidityDataYear(@PathVariable int sensorid) throws Exception {
        System.out.println(sensorid);
        return sensorDataService.getSoilHumidityData(TimeSpan.THIS_YEAR,sensorid);
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
    /*
        AQ DATA ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */

    @GetMapping("/api/aq/all")
    public List<AirqualityModel> getAQtDataAll() throws Exception {
        return sensorDataService.getAQData(TimeSpan.ALL);
    }
    @GetMapping("/api/aq/today")
    public List<AirqualityModel> getAQDataToday() throws Exception {
        return sensorDataService.getAQData(TimeSpan.TODAY);
    }

    @GetMapping("/api/aq/week")
    public List<AirqualityModel> getAQDataWeek()throws Exception {
        return sensorDataService.getAQData(TimeSpan.WEEK);
    }

    @GetMapping("/api/aq/month")
    public List<AirqualityModel> getAQDataMonth() throws Exception {
        return sensorDataService.getAQData(TimeSpan.THIS_MONTH);
    }
    @GetMapping("/api/aq/year")
    public List<AirqualityModel> getAQDataYear() throws Exception {
        return sensorDataService.getAQData(TimeSpan.THIS_YEAR);
    }



    /*
        CO DATA ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    @GetMapping("/api/co/all")
    public List<COModel> getCOtDataAll() throws Exception {
        return sensorDataService.getCOData(TimeSpan.ALL);
    }
    @GetMapping("/api/co/today")
    public List<COModel> getCODataToday() throws Exception {
        return sensorDataService.getCOData(TimeSpan.TODAY);
    }

    @GetMapping("/api/co/week")
    public List<COModel> getCODataWeek()throws Exception {
        return sensorDataService.getCOData(TimeSpan.WEEK);
    }

    @GetMapping("/api/co/month")
    public List<COModel> getCODataMonth() throws Exception {
        return sensorDataService.getCOData(TimeSpan.THIS_MONTH);
    }
    @GetMapping("/api/co/year")
    public List<COModel> getCODataYear() throws Exception {
        return sensorDataService.getCOData(TimeSpan.THIS_YEAR);
    }
}
