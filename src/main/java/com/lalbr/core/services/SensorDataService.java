package com.lalbr.core.services;

import com.lalbr.core.model.SensorData.HumidityModel;
import com.lalbr.core.model.SensorData.TemperatureModel;
import com.lalbr.core.repository.SensorData.HumidityRepository;
import com.lalbr.core.repository.SensorData.TemperatureRepository;
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

    /*
        TEMPERATURE
     */

    /**
     * Gets called by esp32
     * @param temperatureModel -
     * @return TemperatureModel
     */
    public TemperatureModel saveTemperatureModel(TemperatureModel temperatureModel) {
        return temperatureRepository.save(temperatureModel);
    }

    public List<TemperatureModel> getTemperatureData(TimeSpan timespan) throws Exception {

        LocalDateTime start = null;
        LocalDateTime end = null;

        switch(timespan){
            case ALL:
                return temperatureRepository.findAll();
            case TODAY:
                start = LocalDate.now().atStartOfDay();
                end = LocalDate.now().plusDays(1).atStartOfDay();;
                break;
            case THIS_MONTH:
                start = LocalDate.now().withDayOfMonth(1).atStartOfDay();
                end = LocalDate.now().plusDays(LocalDate.now().lengthOfMonth()+1).atStartOfDay();
                break;
            case THIS_YEAR:
                start = LocalDate.now().withDayOfYear(1).atStartOfDay();
                end = LocalDate.now().withDayOfYear(1).plusYears(1).atStartOfDay();
                break;
        }
        return temperatureRepository.findTemperatureModelsByTimestampBetween(start,end);
    }

    /*
        HUMIDITY
     */
    /**
     * Gets called by esp32
     * @param humidityModel -
     * @return HumidityModel
     */
    public HumidityModel saveHumidityModel(HumidityModel humidityModel) {
        return humidityRepository.save(humidityModel);
    }

//    public List<HumidityModel> getHumidityDataAll() {
//        return humidityRepository.findAll();
//    }
//
//    public List<HumidityModel> getHumidityDataToday(){
//        LocalDateTime todayStart = LocalDate.now().atStartOfDay();
//        LocalDateTime tomorrowStart = LocalDate.now().plusDays(1).atStartOfDay();
//        return humidityRepository.findHumidityModelsByTimestampBetween(todayStart,tomorrowStart);
//    }
//
//    public List<HumidityModel> getHumidityDataMonth() {
//        LocalDateTime thisMonthStart = LocalDate.now().withDayOfMonth(1).atStartOfDay();
//        LocalDateTime nextMonthStart = LocalDate.now().plusDays(LocalDate.now().lengthOfMonth()+1).atStartOfDay();
//        return humidityRepository.findHumidityModelsByTimestampBetween(thisMonthStart,nextMonthStart);
//    }
//
//    public List<HumidityModel> getHumidityDataYear() {
//        LocalDateTime thisYearStart = LocalDate.now().withDayOfYear(1).atStartOfDay();
//        LocalDateTime nextYearStart = LocalDate.now().withDayOfYear(1).plusYears(1).atStartOfDay();
//        return humidityRepository.findHumidityModelsByTimestampBetween(thisYearStart,nextYearStart);
//    }

    public List<HumidityModel> getHumidityData(TimeSpan timespan) throws Exception {

        LocalDateTime start = null;
        LocalDateTime end = null;

        switch(timespan){
            case ALL:
                return humidityRepository.findAll();
            case TODAY:
                start = LocalDate.now().atStartOfDay();
                end = LocalDate.now().plusDays(1).atStartOfDay();;
                break;
                case THIS_MONTH:
                start = LocalDate.now().withDayOfMonth(1).atStartOfDay();
                end = LocalDate.now().plusDays(LocalDate.now().lengthOfMonth()+1).atStartOfDay();
                    break;
                case THIS_YEAR:
                    start = LocalDate.now().withDayOfYear(1).atStartOfDay();
                    end = LocalDate.now().withDayOfYear(1).plusYears(1).atStartOfDay();
                    break;
        }
        return humidityRepository.findHumidityModelsByTimestampBetween(start,end);
    }




}
