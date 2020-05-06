package com.iotdatamp.entitymanager.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Geolocation implements Serializable {

    @Id
    @OneToOne(cascade = CascadeType.ALL)
    private Sensor sensorContractAddress;

    private Double latitude;
    private Double longitude;
}
