package com.iotapi.iot.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="sensors")
public class Sensor implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4808637070572089141L;

	@Id
	private long id;

	private String type;
	private String unitMeasurement;
	
	@OneToMany(mappedBy="sensor_id")
	//private Set<DataSensor> datas;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUnitMeasurement() {
		return unitMeasurement;
	}

	public void setUnitMeasurement(String unitMeasurement) {
		this.unitMeasurement = unitMeasurement;
	}



	public long getId() {
		return id;
	}

}
