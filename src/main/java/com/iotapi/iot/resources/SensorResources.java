package com.iotapi.iot.resources;

import java.util.List;
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

import com.iotapi.iot.models.Sensor;
import com.iotapi.iot.repository.SensorRepository;

@RestController
@CrossOrigin(origins = "*")
public class SensorResources {
	
	@Autowired
	SensorRepository sensorRepository;
	
	@GetMapping("/sensors")
	public List<Sensor> indexSensor(){		
		return sensorRepository.findAll();
	}
	
	@GetMapping("/sensors/{id}")
	public ResponseEntity<?> showSensor(@PathVariable Long id){
		Optional<Sensor> sensor = sensorRepository.findById(id);
		
		if(!sensor.isPresent()){
			return ResponseEntity.status(Response.SC_NOT_FOUND).body("O Sensor não foi encontrado!");
		}
		
		return ResponseEntity.ok(sensor.get());
	}
	
	@PostMapping("/sensors")
	public Sensor storeSensor(@RequestBody Sensor sensor) {		
		return sensorRepository.save(sensor);
	}
	
}
