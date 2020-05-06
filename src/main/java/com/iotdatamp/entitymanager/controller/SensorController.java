package com.iotdatamp.entitymanager.controller;

import com.iotdatamp.entitymanager.entity.Sensor;
import com.iotdatamp.entitymanager.service.SensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sensors")
@RequiredArgsConstructor
public class SensorController {

    private final SensorService sensorService;

    @PostMapping
    public ResponseEntity<?> saveSensor(@RequestBody Sensor sensor) {
        return sensorService.saveSensor(sensor);
    }

}
