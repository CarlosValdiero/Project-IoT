package com.iotapi.iot.resources;

import java.time.LocalDateTime;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iotapi.iot.models.DataSensor;
import com.iotapi.iot.models.Sensor;
import com.iotapi.iot.repository.DataSensorRepository;
import com.iotapi.iot.repository.SensorRepository;

@RestController
@CrossOrigin(origins = "*")
public class DataSensorResources {
	
	@Autowired
	DataSensorRepository dataSensorRepository;
	
	@Autowired
	SensorRepository sensorRepository;
	
	@GetMapping("/sensors/{id}/dataSensors")
	public ResponseEntity<?> indexSensor(@PathVariable Long id){
		Optional<Sensor> sensor = sensorRepository.findById(id);
		
		if(!sensor.isPresent()) {
			return (ResponseEntity<?>) ResponseEntity.notFound();
		}
		
		return ResponseEntity.ok(dataSensorRepository.findAllWithIdValueDateTimeBySensor(sensor.get()));
	}
	
	@PostMapping("/sensors/{id}/dataSensors")
	public ResponseEntity<?> storeSensor(@PathVariable Long id, @RequestBody DataSensor dataSensor) {
		Optional<Sensor> sensor = sensorRepository.findById(id);
		
		if(!sensor.isPresent()) {
			return ResponseEntity.status(Response.SC_NOT_FOUND).body("Erro, sensor não encontrado!");
		}		
		
		dataSensor.setDateTime( LocalDateTime.now());
		dataSensor.setSensor(sensor.get());
		
		
		return ResponseEntity.ok(dataSensorRepository.save(dataSensor));
	}

}
