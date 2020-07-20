package com.iotdatamp.entitymanager.repository;

import com.iotdatamp.entitymanager.entity.DSJWTAuth;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DSJWTAuthRepository extends CrudRepository<DSJWTAuth, String> {
    Optional<DSJWTAuth> findByJwt(String s);
    Optional<DSJWTAuth> findByContractAddress(String s);
}
