package com.iotdatamp.entitymanager.repository;

import com.iotdatamp.entitymanager.entity.Sensor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends CrudRepository<Sensor, String> {
}
