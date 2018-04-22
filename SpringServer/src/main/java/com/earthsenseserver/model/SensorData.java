package com.earthsenseserver.model;

import java.util.UUID;
import java.util.Date;

import org.springframework.cassandra.core.Ordering;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

@Table
public class SensorData {

	@PrimaryKeyColumn(name = "nodeid", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private UUID nodeId;

	@PrimaryKeyColumn(name = "timestamp", ordinal = 1, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
	private Date timestamp;
	
	private float altitude;
	private float humidity;
	private float pressure;
	private float temp;
	private float latitude;
	private float longitude;


	public SensorData(float altitude, float humidity, float pressure, float temp, float latitude, float longitude) {
		this.altitude = altitude;
		this.humidity = humidity;
		this.pressure = pressure;
		this.temp = temp;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public UUID getNodeId() {
		return nodeId;
	}
	
	public void setNodeId(UUID nodeId) {
		this.nodeId = nodeId;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public float getAltitude() {
		return altitude;
	}

	public void setAltitude(float altitude) {
		this.altitude = altitude;
	}
	
	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}
	
	public float getPressure() {
		return pressure;
	}

	public void setPressure(float pressure) {
		this.pressure = pressure;
	}
	
	public float getTemp() {
		return temp;
	}

	public void setTemp(float temp) {
		this.temp = temp;
	}
	
	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	
	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	
}