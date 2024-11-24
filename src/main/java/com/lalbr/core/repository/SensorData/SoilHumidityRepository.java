package com.lalbr.core.repository.SensorData;

import com.lalbr.core.model.SensorData.HumidityModel;
import com.lalbr.core.model.SensorData.SoilHumidityModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface SoilHumidityRepository extends JpaRepository<SoilHumidityModel, Long> {
    List<SoilHumidityModel> findSoilHumidityModelsByTimestampBetween(LocalDateTime startOfDay, LocalDateTime endOfDay);

}
