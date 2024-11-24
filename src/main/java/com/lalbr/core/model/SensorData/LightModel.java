package com.lalbr.core.model.SensorData;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "light")
public class LightModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "value")
    private Double value;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;


    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Double getValue() {
        return value;
    }
}
