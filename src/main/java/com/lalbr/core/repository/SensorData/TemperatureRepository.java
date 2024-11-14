package com.lalbr.core.repository.SensorData;

import com.lalbr.core.model.SensorData.TemperatureModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TemperatureRepository extends JpaRepository<TemperatureModel, Long> {


    List<TemperatureModel> findTemperatureModelsByTimestampBetween(LocalDateTime startOfDay, LocalDateTime endOfDay);


    //List<TemperatureModel> findTemperatureModelsByTimestampBetween(LocalDateTime startOfDay,LocalDateTime endOfDay);


}