package com.lalbr.learnifyTools.repository.SensorData;

import com.lalbr.learnifyTools.model.SensorData.HumidityModel;
import com.lalbr.learnifyTools.model.SensorData.TemperatureModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HumidityRepository extends JpaRepository<HumidityModel, Long> {
}
