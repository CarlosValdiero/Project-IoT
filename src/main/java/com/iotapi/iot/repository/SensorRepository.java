package com.iotapi.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iotapi.iot.models.Sensor;


public interface SensorRepository extends JpaRepository<Sensor, Long>{

}
