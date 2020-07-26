package com.iotdatamp.entitymanager.controller;

import com.iotdatamp.entitymanager.entity.DSEntityJWTAuth;
import com.iotdatamp.entitymanager.service.DSEntityJWTAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/dse")
@RequiredArgsConstructor
public class DSEntityJWTAuthController {

    private final DSEntityJWTAuthService DSEntityJWTAuthService;

    @PostMapping
    public ResponseEntity<?> saveJWT(@RequestBody DSEntityJWTAuth authDTO) {
        return DSEntityJWTAuthService.saveDSJWT(authDTO);
    }

    @GetMapping("/jwt/exists")
    public ResponseEntity<Boolean> jwtExists(@RequestParam String jwt) {
        return DSEntityJWTAuthService.jwtExists(jwt);
    }

    @GetMapping("/jwt")
    public ResponseEntity<String> getJWTForEntity(@RequestParam String entityContractAddress) {
        return DSEntityJWTAuthService.getJWTForEntity(entityContractAddress);
    }

    @GetMapping("/valid")
    public ResponseEntity<Boolean> isAddressJWTKeyPairValid(@RequestParam String entityContractAddress, @RequestParam String jwt) {
        return DSEntityJWTAuthService.isAddressJWTKeyPairValid(entityContractAddress, jwt);
    }

}
