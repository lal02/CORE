package com.lalbr.core.repository.SensorData;

import com.lalbr.core.model.SensorData.LightModel;
import com.lalbr.core.model.SensorData.SoilHumidityModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface LightRepository extends JpaRepository<LightModel, Long> {

    List<LightModel> findLightModelsByTimestampBetween(LocalDateTime startOfDay, LocalDateTime endOfDay);
}
