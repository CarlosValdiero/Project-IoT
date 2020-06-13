package com.iotapi.iot.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="datasSensor")
public class DataSensor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9183927402820159675L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private float value;
	
	private LocalDateTime dateTime;
	
	@ManyToOne (optional=true)
    @JoinColumn(name="sensor_id", nullable=false)
	private Sensor sensor;

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public long getId() {
		return id;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	public Sensor getSensor() {
		return sensor;
	}


	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	

	
	
	
}
