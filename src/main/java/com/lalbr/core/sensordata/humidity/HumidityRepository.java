package com.lalbr.core.sensordata.humidity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface HumidityRepository extends JpaRepository<HumidityModel, Long> {

    List<HumidityModel> findHumidityModelsByTimestampBetween(LocalDateTime startOfDay, LocalDateTime endOfDay);
}