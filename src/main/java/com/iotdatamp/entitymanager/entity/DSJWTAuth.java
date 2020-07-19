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
public class DSJWTAuth {

    @Id
    private String contractAddress;

    @Column(columnDefinition="text")
    private String jwt;

    @Column
    private String nonce;

}
