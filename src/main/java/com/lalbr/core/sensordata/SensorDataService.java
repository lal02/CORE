package com.lalbr.core.sensordata;

import com.lalbr.core.sensordata.airquality.AirqualityModel;
import com.lalbr.core.sensordata.airquality.AirqualityRepository;
import com.lalbr.core.sensordata.carbonmonoxide.COModel;
import com.lalbr.core.sensordata.carbonmonoxide.CORepository;
import com.lalbr.core.sensordata.humidity.HumidityModel;
import com.lalbr.core.sensordata.humidity.HumidityRepository;
import com.lalbr.core.sensordata.light.LightModel;
import com.lalbr.core.sensordata.light.LightRepository;
import com.lalbr.core.sensordata.soilhumidity.SoilHumidityModel;
import com.lalbr.core.sensordata.soilhumidity.SoilHumidityRepository;
import com.lalbr.core.sensordata.temperature.TemperatureModel;
import com.lalbr.core.sensordata.temperature.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SensorDataService {

    @Autowired
    private TemperatureRepository temperatureRepository;

    @Autowired
    private HumidityRepository humidityRepository;

    @Autowired
    private SoilHumidityRepository soilHumidityRepository;

    @Autowired
    private LightRepository lightRepository;

    @Autowired
    private CORepository coRepository;

    @Autowired
    private AirqualityRepository airqualityRepository;

    public List<TemperatureModel> getTemperatureData(TimeSpan timespan) throws Exception {
        if(timespan == TimeSpan.ALL){
            return temperatureRepository.findAll();
        }
        LocalDateTime[] arr = getStartAndEndDate(timespan);
        return temperatureRepository.findTemperatureModelsByTimestampBetween(arr[0],arr[1]);
    }


    public List<HumidityModel> getHumidityData(TimeSpan timespan) throws Exception {
        if(timespan == TimeSpan.ALL){
            return humidityRepository.findAll();
        }
        LocalDateTime[] arr = getStartAndEndDate(timespan);
        return humidityRepository.findHumidityModelsByTimestampBetween(arr[0],arr[1]);
    }

    public List<SoilHumidityModel> getSoilHumidityData(TimeSpan timespan,int sensorID) throws Exception {
        if(timespan == TimeSpan.ALL){
            return soilHumidityRepository.findSoilHumidityModelsBySensorid(sensorID);
        }
        LocalDateTime[] arr = getStartAndEndDate(timespan);
        return soilHumidityRepository.findSoilHumidityModelsByTimestampBetweenAndSensorid(arr[0],arr[1],sensorID);
    }

    public List<LightModel> getLightData(TimeSpan timespan) throws Exception {
        if(timespan == TimeSpan.ALL){
            return lightRepository.findAll();
        }
        LocalDateTime[] arr = getStartAndEndDate(timespan);
        return lightRepository.findLightModelsByTimestampBetween(arr[0],arr[1]);
    }

    public List<AirqualityModel> getAQData(TimeSpan timespan) throws Exception {
        if(timespan == TimeSpan.ALL){
            return airqualityRepository.findAll();
        }
        LocalDateTime[] arr = getStartAndEndDate(timespan);
        return airqualityRepository.findAirqualityModelsByTimestampBetween(arr[0],arr[1]);
    }

    public List<COModel> getCOData(TimeSpan timespan) throws Exception {
       if(timespan == TimeSpan.ALL){
           return coRepository.findAll();
       }
       LocalDateTime[] arr = getStartAndEndDate(timespan);
        return coRepository.findCOModelsByTimestampBetween(arr[0],arr[1]);
    }

    /*
        SAVING
     */

    public TemperatureModel saveTemperatureModel(TemperatureModel temperatureModel) {
        return temperatureRepository.save(temperatureModel);
    }

    public SoilHumidityModel saveSoilHumidityModel(SoilHumidityModel soilHumidityModel) {
        return soilHumidityRepository.save(soilHumidityModel);
    }

    public LightModel saveLightModel(LightModel lightModel) {
        return lightRepository.save(lightModel);
    }

    public COModel saveCOModel(COModel coModel){
        return coRepository.save(coModel);
    }

    public AirqualityModel saveAirqualityModel(AirqualityModel airqualityModel){
        return airqualityRepository.save(airqualityModel);
    }

    public HumidityModel saveHumidityModel(HumidityModel humidityModel) {
        return humidityRepository.save(humidityModel);
    }

    private LocalDateTime[] getStartAndEndDate(TimeSpan timespan){
        LocalDateTime start;
        LocalDateTime end;

        switch (timespan) {
            case TODAY -> {
                start = LocalDate.now().atStartOfDay();
                end = LocalDate.now().plusDays(1).atStartOfDay();
            }
            case WEEK -> {
                start = LocalDate.now().atStartOfDay().minusWeeks(1);
                end = LocalDate.now().plusDays(1).atStartOfDay();
            }
            case THIS_MONTH -> {
                start = LocalDate.now().withDayOfMonth(1).atStartOfDay();
                end = LocalDate.now().plusDays(LocalDate.now().lengthOfMonth() + 1).atStartOfDay();
            }
            case THIS_YEAR -> {
                start = LocalDate.now().withDayOfYear(1).atStartOfDay();
                end = LocalDate.now().withDayOfYear(1).plusYears(1).atStartOfDay();
            }
            default -> throw new IllegalStateException("Unexpected value: " + timespan);
        }

        return new LocalDateTime[] {
            start,
            end
        };
    }
}
