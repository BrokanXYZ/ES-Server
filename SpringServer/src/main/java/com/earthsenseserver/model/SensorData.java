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
	
	private float sensorReading1;
	private float sensorReading2;
	private float sensorReading3;


	public SensorData(float sensorReading1, float sensorReading2, float sensorReading3) {
		this.sensorReading1 = sensorReading1;
		this.sensorReading2 = sensorReading2;
		this.sensorReading3 = sensorReading3;
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

	public float getSensorReading1() {
		return sensorReading1;
	}

	public void setSensorReading1(float sensorReading1) {
		this.sensorReading1 = sensorReading1;
	}
	
	public float getSensorReading2() {
		return sensorReading2;
	}

	public void setSensorReading2(float sensorReading2) {
		this.sensorReading2 = sensorReading2;
	}
	
	public float getSensorReading3() {
		return sensorReading3;
	}

	public void setSensorReading3(float sensorReading3) {
		this.sensorReading3 = sensorReading3;
	}
	

	@Override
	public String toString() {
		/*return "SensorData [nodeId=" + pk.getNodeId() + ", timestamp=" + pk.getTimestamp() + ", sensorReading1=" + sensorReading1 + ", sensorReading2=" + sensorReading2 + ", sensorReading3=" + sensorReading3 + "]";*/
		return "NEED TO REDO THIS";
	}
}