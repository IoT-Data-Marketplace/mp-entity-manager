package com.iotdatamp.entitymanager.service;


import com.iotdatamp.entitymanager.entity.SensorPublishingJWTAuth;
import com.iotdatamp.entitymanager.entity.SensorSubscriptionJWTAuth;
import com.iotdatamp.entitymanager.repository.SensorPublishingJWTAuthRepository;
import com.iotdatamp.entitymanager.repository.SensorSubscriptionJWTAuthRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SensorSubscriptionWTAuthService {

    private final SensorSubscriptionJWTAuthRepository sensorSubscriptionJWTAuthRepository;

    @SneakyThrows
    public ResponseEntity<?> saveDSJWT(SensorSubscriptionJWTAuth sensorSubscriptionJWTAuth) {
        sensorSubscriptionJWTAuthRepository.save(sensorSubscriptionJWTAuth);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Boolean> isAddressJWTKeyPairValid(String entityContractAddress, String jwt) {
        Optional<SensorSubscriptionJWTAuth> sensorSubscriptionJWTAuthOptional = sensorSubscriptionJWTAuthRepository.findByContractAddressAndJwt(entityContractAddress, jwt);
        return sensorSubscriptionJWTAuthOptional.map(DSEntityJWTAuth -> ResponseEntity.ok(Boolean.TRUE)).orElseGet(() -> ResponseEntity.ok(Boolean.FALSE));
    }
}
