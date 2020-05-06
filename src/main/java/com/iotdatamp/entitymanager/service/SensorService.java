package com.iotdatamp.entitymanager.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.iotdatamp.entitymanager.entity.Sensor;
import com.iotdatamp.entitymanager.repository.SensorRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SensorService {

    private final SensorRepository sensorRepository;

    ObjectMapper mapper = new ObjectMapper();

    @SneakyThrows
    public ResponseEntity<?> saveSensor(Sensor sensor) {
        Sensor savedSensor = sensorRepository.save(sensor);
        return ResponseEntity.ok().body(mapper.writeValueAsString(savedSensor));
    }
}
