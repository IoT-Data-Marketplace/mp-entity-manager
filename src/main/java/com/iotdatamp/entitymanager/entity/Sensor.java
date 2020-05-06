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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String sensorContractAddress;

    @Column(nullable = false)
    private String dataStreamEntityContractAddress;

    @Column(nullable = false)
    private String latitude;

    @Column(nullable = false)
    private String longitude;

    @Enumerated(EnumType.STRING)
    private SensorType sensorType;

    @Enumerated(EnumType.STRING)
    private SensorStatus sensorStatus;
}
