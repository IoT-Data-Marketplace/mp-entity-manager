package com.iotdatamp.entitymanager.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Sensor {

    @Id
    private String sensorContractAddress;

    @Column(nullable = false)
    private String dataStreamEntityContractAddress;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    @Enumerated(EnumType.STRING)
    private SensorType sensorType;

    @Enumerated(EnumType.STRING)
    private SensorStatus sensorStatus;
}
