package com.iotdatamp.entitymanager.repository;

import com.iotdatamp.entitymanager.entity.DSEntityJWTAuth;
import com.iotdatamp.entitymanager.entity.SensorPublishingJWTAuth;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SensorPublishingJWTAuthRepository extends CrudRepository<SensorPublishingJWTAuth, String> {
    Optional<SensorPublishingJWTAuth> findByContractAddress(String contractAddress);
    Optional<SensorPublishingJWTAuth> findByContractAddressAndJwt(String contractAddress, String jwt);
}
