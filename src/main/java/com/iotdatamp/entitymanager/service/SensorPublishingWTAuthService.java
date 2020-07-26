package com.iotdatamp.entitymanager.service;


import com.iotdatamp.entitymanager.entity.DSEntityJWTAuth;
import com.iotdatamp.entitymanager.entity.SensorPublishingJWTAuth;
import com.iotdatamp.entitymanager.repository.SensorPublishingJWTAuthRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SensorPublishingWTAuthService {

    private final SensorPublishingJWTAuthRepository sensorPublishingJWTAuthRepository;

    @SneakyThrows
    public ResponseEntity<?> saveDSJWT(SensorPublishingJWTAuth sensorPublishingJWTAuth) {
        sensorPublishingJWTAuthRepository.save(sensorPublishingJWTAuth);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Boolean> isAddressJWTKeyPairValid(String entityContractAddress, String jwt) {
        Optional<SensorPublishingJWTAuth> sensorPublishingJWTAuthOptional = sensorPublishingJWTAuthRepository.findByContractAddressAndJwt(entityContractAddress, jwt);
        return sensorPublishingJWTAuthOptional.map(DSEntityJWTAuth -> ResponseEntity.ok(Boolean.TRUE)).orElseGet(() -> ResponseEntity.ok(Boolean.FALSE));
    }

    public ResponseEntity<String> getJWTForEntity(String entityContractAddress) {
        Optional<SensorPublishingJWTAuth> dsOptional = sensorPublishingJWTAuthRepository.findByContractAddress(entityContractAddress);
        return dsOptional.map(DSEntityJWTAuth -> ResponseEntity.ok(DSEntityJWTAuth.getJwt())).orElseGet(() -> ResponseEntity.status(HttpStatus.FORBIDDEN).build());

    }
}
