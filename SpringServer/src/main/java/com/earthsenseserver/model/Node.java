package com.earthsenseserver.model;

import java.util.UUID;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table
public class Node {

	@PrimaryKey
	private UUID nodeId;
	
	private UUID owner;
	private String nodeName;
	@Column(value = "lat")
	private float latitude;
	@Column(value = "long")
	private float longitude;
	private String city;
	private String state;
	private String country;
	private int status;

	
	public Node(UUID owner, String nodeName, float latitude, float longitude, String city, String state, String country) {
		this.owner = owner;
		this.nodeName = nodeName;
		this.latitude = latitude;
		this.longitude = longitude;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	
	public UUID getNodeId() {
		return nodeId;
	}

	public void setNodeId(UUID nodeId) {
		this.nodeId = nodeId;
	}
	
	public UUID getOwner() {
		return owner;
	}

	public void setOwner(UUID owner) {
		this.owner = owner;
	}
	
	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	
	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	
	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	

	@Override
	public String toString() {
		return "Node [nodeId=" + nodeId + ", owner=" + owner + ", nodeName=" + nodeName + ", latitude=" + latitude + ", longitude=" + longitude + ", city=" + city + ", state=" + state + ", country=" + country + ", status=" + status + "]";
	}
}