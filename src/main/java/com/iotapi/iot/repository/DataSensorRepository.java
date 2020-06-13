package com.iotapi.iot.repository;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iotapi.iot.models.DataSensor;
import com.iotapi.iot.models.Sensor;


interface IdValueDateTime{
    LocalDateTime getDateTime();
    Float getValue();
    Long getId();
}

@Repository
public interface DataSensorRepository extends JpaRepository<DataSensor, Long>{
	
	public List<DataSensor> findAllBySensor(Sensor sensor);
	
	public List<IdValueDateTime> findAllWithIdValueDateTimeBySensor(Sensor sensor);

}
