package com.lalbr.core.model.SensorData;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Entity
@Table(name = "humidity")
public class HumidityModel {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generates the ID
    private int id;

    @Column(name = "value")
    private  Double value;
    @Column(name = "timestamp")
    private  LocalDateTime timestamp;

//    private static int year = timestamp.getYear();
//    private static int month = timestamp.getMonthValue();
//    private static int day = timestamp.getDayOfMonth();


    public Double getValue() {

        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
