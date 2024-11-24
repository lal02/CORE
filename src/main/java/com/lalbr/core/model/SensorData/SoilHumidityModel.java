package com.lalbr.core.model.SensorData;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "soilhumidity")
public class SoilHumidityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "value")
    private int value;
    @Column(name = "timestamp")
    private LocalDateTime timestamp;


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getValue() {
        return value;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
