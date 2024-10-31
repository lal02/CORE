package com.lalbr.learnifyTools.repository;

import com.lalbr.learnifyTools.model.SensorData.TemperatureModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemperatureRepository extends JpaRepository<TemperatureModel, Long> {
}
