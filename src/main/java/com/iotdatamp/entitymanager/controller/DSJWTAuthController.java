package com.iotdatamp.entitymanager.controller;

import com.iotdatamp.entitymanager.entity.DSJWTAuth;
import com.iotdatamp.entitymanager.service.DSJWTAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class DSJWTAuthController {

    private final DSJWTAuthService DSJWTAuthService;

    @PostMapping
    public ResponseEntity<?> saveJWT(@RequestBody DSJWTAuth authDTO) {
        return DSJWTAuthService.saveDSJWT(authDTO);
    }

    @GetMapping("/jwt/exists")
    public ResponseEntity<Boolean> jwtExists(@RequestParam String jwt) {
        return DSJWTAuthService.jwtExists(jwt);
    }

    @GetMapping("/jwt")
    public ResponseEntity<String> getJWTForEntity(@RequestParam String entityContractAddress) {
        return DSJWTAuthService.getJWTForEntity(entityContractAddress);
    }

    @GetMapping("/valid")
    public ResponseEntity<Boolean> isAddressJWTKeyPairValid(@RequestParam String entityContractAddress, @RequestParam String jwt) {
        return DSJWTAuthService.isAddressJWTKeyPairValid(entityContractAddress, jwt);
    }

}
