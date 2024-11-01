package com.lalbr.learnifyTools.services;

import com.lalbr.learnifyTools.model.SensorData.HumidityModel;
import com.lalbr.learnifyTools.model.SensorData.TemperatureModel;
import com.lalbr.learnifyTools.repository.SensorData.HumidityRepository;
import com.lalbr.learnifyTools.repository.SensorData.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SensorDataService {

    @Autowired
    private TemperatureRepository temperatureRepository;

    @Autowired
    private HumidityRepository humidityRepository;

    public TemperatureModel saveTemperatureModel(TemperatureModel temperatureModel) {
        return temperatureRepository.save(temperatureModel);
    }

    public HumidityModel saveHumidityModel(HumidityModel humidityModel) {
        return humidityRepository.save(humidityModel);
    }
//    public Optional<FinEngModel> getFinEngModelById(Long id) {
//        return finEngRepository.findById(id);
//    }

//    public List<FinEngModel> getAllFinEngModels() {
//        return finEngRepository.findAll();
//    }


}
