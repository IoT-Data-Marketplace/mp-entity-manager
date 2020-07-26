package com.iotdatamp.entitymanager.controller;

import com.iotdatamp.entitymanager.entity.SensorSubscriptionJWTAuth;
import com.iotdatamp.entitymanager.service.SensorSubscriptionWTAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/sensor/subscription")
@RequiredArgsConstructor
public class SensorSubscriptionJWTAuthController {

    private final SensorSubscriptionWTAuthService sensorSubscriptionWTAuthService;

    @PostMapping
    public ResponseEntity<?> saveJWT(@RequestBody SensorSubscriptionJWTAuth authDTO) {
        return sensorSubscriptionWTAuthService.saveDSJWT(authDTO);
    }

    @GetMapping("/valid")
    public ResponseEntity<Boolean> isAddressJWTKeyPairValid(@RequestParam String entityContractAddress, @RequestParam String jwt) {
        return sensorSubscriptionWTAuthService.isAddressJWTKeyPairValid(entityContractAddress, jwt);
    }

}
