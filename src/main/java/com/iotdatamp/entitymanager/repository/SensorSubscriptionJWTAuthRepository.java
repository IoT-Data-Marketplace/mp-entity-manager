package com.iotdatamp.entitymanager.repository;

import com.iotdatamp.entitymanager.entity.SensorSubscriptionJWTAuth;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SensorSubscriptionJWTAuthRepository extends CrudRepository<SensorSubscriptionJWTAuth, String> {
    Optional<SensorSubscriptionJWTAuth> findByContractAddressAndJwt(String contractAddress, String jwt);
}
