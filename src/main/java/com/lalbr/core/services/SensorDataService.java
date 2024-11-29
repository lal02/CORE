package com.lalbr.core.services;

import com.lalbr.core.model.SensorData.HumidityModel;
import com.lalbr.core.model.SensorData.LightModel;
import com.lalbr.core.model.SensorData.SoilHumidityModel;
import com.lalbr.core.model.SensorData.TemperatureModel;
import com.lalbr.core.repository.SensorData.HumidityRepository;
import com.lalbr.core.repository.SensorData.LightRepository;
import com.lalbr.core.repository.SensorData.SoilHumidityRepository;
import com.lalbr.core.repository.SensorData.TemperatureRepository;
import com.lalbr.core.util.TimeSpan;
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

    /*
        TEMPERATURE
     */

    /**
     * Gets called by esp32
     *
     * @param temperatureModel -
     * @return TemperatureModel
     */
    public TemperatureModel saveTemperatureModel(TemperatureModel temperatureModel) {
        return temperatureRepository.save(temperatureModel);
    }

    public List<TemperatureModel> getTemperatureData(TimeSpan timespan) throws Exception {

        LocalDateTime start = null;
        LocalDateTime end = null;

        switch (timespan) {
            case ALL:
                return temperatureRepository.findAll();
            case TODAY:
                start = LocalDate.now().atStartOfDay();
                end = LocalDate.now().plusDays(1).atStartOfDay();
                break;
            case WEEK:
                start = LocalDate.now().atStartOfDay().minusWeeks(1);
                end = LocalDate.now().plusWeeks(1).atStartOfDay();
                break;
            case THIS_MONTH:
                start = LocalDate.now().withDayOfMonth(1).atStartOfDay();
                end = LocalDate.now().plusDays(LocalDate.now().lengthOfMonth() + 1).atStartOfDay();
                break;
            case THIS_YEAR:
                start = LocalDate.now().withDayOfYear(1).atStartOfDay();
                end = LocalDate.now().withDayOfYear(1).plusYears(1).atStartOfDay();
                break;
        }
        return temperatureRepository.findTemperatureModelsByTimestampBetween(start, end);
    }

    /*
        HUMIDITY
     */

    /**
     * Gets called by esp32
     *
     * @param humidityModel -
     * @return HumidityModel
     */
    public HumidityModel saveHumidityModel(HumidityModel humidityModel) {
        return humidityRepository.save(humidityModel);
    }

    public List<HumidityModel> getHumidityData(TimeSpan timespan) throws Exception {

        LocalDateTime start = null;
        LocalDateTime end = null;

        switch (timespan) {
            case ALL:
                return humidityRepository.findAll();
            case TODAY:
                start = LocalDate.now().atStartOfDay();
                end = LocalDate.now().plusDays(1).atStartOfDay();
                break;
            case WEEK:
                start = LocalDate.now().atStartOfDay().minusWeeks(1);
                end = LocalDate.now().plusWeeks(1).atStartOfDay();
            case THIS_MONTH:
                start = LocalDate.now().withDayOfMonth(1).atStartOfDay();
                end = LocalDate.now().plusDays(LocalDate.now().lengthOfMonth() + 1).atStartOfDay();
                break;
            case THIS_YEAR:
                start = LocalDate.now().withDayOfYear(1).atStartOfDay();
                end = LocalDate.now().withDayOfYear(1).plusYears(1).atStartOfDay();
                break;
        }
        return humidityRepository.findHumidityModelsByTimestampBetween(start, end);
    }

    public List<SoilHumidityModel> getSoilHumidityData(TimeSpan timespan) throws Exception {

        LocalDateTime start = null;
        LocalDateTime end = null;

        switch (timespan) {
            case ALL:
                return soilHumidityRepository.findAll();
            case TODAY:
                start = LocalDate.now().atStartOfDay();
                end = LocalDate.now().plusDays(1).atStartOfDay();
                break;
            case WEEK:
                start = LocalDate.now().atStartOfDay().minusWeeks(1);
                end = LocalDate.now().plusWeeks(1).atStartOfDay();
            case THIS_MONTH:
                start = LocalDate.now().withDayOfMonth(1).atStartOfDay();
                end = LocalDate.now().plusDays(LocalDate.now().lengthOfMonth() + 1).atStartOfDay();
                break;
            case THIS_YEAR:
                start = LocalDate.now().withDayOfYear(1).atStartOfDay();
                end = LocalDate.now().withDayOfYear(1).plusYears(1).atStartOfDay();
                break;
        }
        return soilHumidityRepository.findSoilHumidityModelsByTimestampBetween(start, end);
    }

    public List<LightModel> getLightData(TimeSpan timespan) throws Exception {

        LocalDateTime start = null;
        LocalDateTime end = null;

        switch (timespan) {
            case ALL:
                return lightRepository.findAll();
            case TODAY:
                start = LocalDate.now().atStartOfDay();
                end = LocalDate.now().plusDays(1).atStartOfDay();
                break;
            case WEEK:
                start = LocalDate.now().atStartOfDay().minusWeeks(1);
                end = LocalDate.now().plusDays(1).atStartOfDay();
            case THIS_MONTH:
                start = LocalDate.now().withDayOfMonth(1).atStartOfDay();
                end = LocalDate.now().plusDays(LocalDate.now().lengthOfMonth() + 1).atStartOfDay();
                break;
            case THIS_YEAR:
                start = LocalDate.now().withDayOfYear(1).atStartOfDay();
                end = LocalDate.now().withDayOfYear(1).plusYears(1).atStartOfDay();
                break;
        }
        return lightRepository.findLightModelsByTimestampBetween(start, end);
    }


    public SoilHumidityModel saveSoilHumidityModel(SoilHumidityModel soilHumidityModel) {
        return soilHumidityRepository.save(soilHumidityModel);
    }

    public LightModel saveLightModel(LightModel lightModel) {
        return lightRepository.save(lightModel);
    }


}
