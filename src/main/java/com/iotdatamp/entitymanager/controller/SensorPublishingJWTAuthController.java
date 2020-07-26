package com.iotdatamp.entitymanager.controller;

import com.iotdatamp.entitymanager.entity.SensorPublishingJWTAuth;
import com.iotdatamp.entitymanager.service.SensorPublishingWTAuthService;
import com.iotdatamp.entitymanager.service.SensorSubscriptionWTAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/sensor/publishing")
@RequiredArgsConstructor
public class SensorPublishingJWTAuthController {

    private final SensorPublishingWTAuthService sensorPublishingWTAuthService;

    @PostMapping
    public ResponseEntity<?> saveJWT(@RequestBody SensorPublishingJWTAuth authDTO) {
        return sensorPublishingWTAuthService.saveDSJWT(authDTO);
    }

    @GetMapping("/valid")
    public ResponseEntity<Boolean> isAddressJWTKeyPairValid(@RequestParam String entityContractAddress, @RequestParam String jwt) {
        return sensorPublishingWTAuthService.isAddressJWTKeyPairValid(entityContractAddress, jwt);
    }

    @GetMapping("/jwt")
    public ResponseEntity<String> getJWTForEntity(@RequestParam String entityContractAddress) {
        return sensorPublishingWTAuthService.getJWTForEntity(entityContractAddress);
    }

}
