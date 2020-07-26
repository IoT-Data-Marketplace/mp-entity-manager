package com.iotdatamp.entitymanager.repository;

import com.iotdatamp.entitymanager.entity.DSEntityJWTAuth;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DSEntityJWTAuthRepository extends CrudRepository<DSEntityJWTAuth, String> {
    Optional<DSEntityJWTAuth> findByJwt(String s);
    Optional<DSEntityJWTAuth> findByContractAddress(String s);
    Optional<DSEntityJWTAuth> findByContractAddressAndJwt(String contractAddress, String jwt);
}
