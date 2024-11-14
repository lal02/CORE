package com.lalbr.core.repository.SensorData;

import com.lalbr.core.model.SensorData.HumidityModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface HumidityRepository extends JpaRepository<HumidityModel, Long> {

    List<HumidityModel> findHumidityModelsByTimestampBetween(LocalDateTime startOfDay, LocalDateTime endOfDay);
}
