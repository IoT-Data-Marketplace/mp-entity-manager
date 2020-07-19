package com.iotdatamp.entitymanager.service;


import com.iotdatamp.entitymanager.entity.DSJWTAuth;
import com.iotdatamp.entitymanager.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class DSJWTAuthService {

    private final AuthRepository authRepository;

    @SneakyThrows
    public ResponseEntity<?> saveDSJWT(DSJWTAuth DSJWTAuth) {
        authRepository.save(DSJWTAuth);
        return ResponseEntity.ok().build();
    }

    @SneakyThrows
    public ResponseEntity<Boolean> jwtExists(String jwt) {
        Optional<DSJWTAuth> dsOptional = authRepository.findByJwt(jwt);
        if (dsOptional.isPresent())
            return ResponseEntity.ok(Boolean.TRUE);
        return ResponseEntity.ok(Boolean.FALSE);
    }
}
