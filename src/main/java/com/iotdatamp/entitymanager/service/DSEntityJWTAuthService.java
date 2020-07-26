package com.iotdatamp.entitymanager.service;


import com.iotdatamp.entitymanager.entity.DSEntityJWTAuth;
import com.iotdatamp.entitymanager.repository.DSEntityJWTAuthRepository;
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
public class DSEntityJWTAuthService {

    private final DSEntityJWTAuthRepository dsEntityJWTAuthRepository;

    @SneakyThrows
    public ResponseEntity<?> saveDSJWT(DSEntityJWTAuth DSEntityJWTAuth) {
        dsEntityJWTAuthRepository.save(DSEntityJWTAuth);
        return ResponseEntity.ok().build();
    }

    @SneakyThrows
    public ResponseEntity<Boolean> jwtExists(String jwt) {
        Optional<DSEntityJWTAuth> dsOptional = dsEntityJWTAuthRepository.findByJwt(jwt);
        if (dsOptional.isPresent())
            return ResponseEntity.ok(Boolean.TRUE);
        return ResponseEntity.ok(Boolean.FALSE);
    }

    public ResponseEntity<String> getJWTForEntity(String entityContractAddress) {
        Optional<DSEntityJWTAuth> dsOptional = dsEntityJWTAuthRepository.findByContractAddress(entityContractAddress);
        return dsOptional.map(DSEntityJWTAuth -> ResponseEntity.ok(DSEntityJWTAuth.getJwt())).orElseGet(() -> ResponseEntity.status(HttpStatus.FORBIDDEN).build());
    }

    public ResponseEntity<Boolean> isAddressJWTKeyPairValid(String entityContractAddress, String jwt) {
        Optional<DSEntityJWTAuth> dsjwtAuthOptional = dsEntityJWTAuthRepository.findByContractAddressAndJwt(entityContractAddress, jwt);
        return dsjwtAuthOptional.map(DSEntityJWTAuth -> ResponseEntity.ok(Boolean.TRUE)).orElseGet(() -> ResponseEntity.ok(Boolean.FALSE));
    }
}
