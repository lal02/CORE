package com.lalbr.learnifyTools.services;

import com.lalbr.learnifyTools.model.SensorData.TemperatureModel;
import com.lalbr.learnifyTools.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SensorDataService {

    @Autowired
    private TemperatureRepository temperatureRepository;

    public TemperatureModel saveTemperatureModel(TemperatureModel temperatureModel) {
        return temperatureRepository.save(temperatureModel);
    }

//    public Optional<FinEngModel> getFinEngModelById(Long id) {
//        return finEngRepository.findById(id);
//    }

//    public List<FinEngModel> getAllFinEngModels() {
//        return finEngRepository.findAll();
//    }


}
