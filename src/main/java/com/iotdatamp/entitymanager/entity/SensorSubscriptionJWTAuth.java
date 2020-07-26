package com.iotdatamp.entitymanager.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@IdClass(SensorSubscriptionJWTAuth.class)
public class SensorSubscriptionJWTAuth implements Serializable {

    @Id
    private String contractAddress;

    @Id
    @Column(columnDefinition="text")
    private String jwt;

}
