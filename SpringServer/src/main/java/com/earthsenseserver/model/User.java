package com.earthsenseserver.model;

import java.util.UUID;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table
public class User {

	@PrimaryKey
	private UUID userId;
	
	private int permissionId;
	private String username;
	private String password;
	private String email;

	public User(){}
	
	public User(int permissionId, String username, String password, String email) {
		this.permissionId = permissionId;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	
	public int getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", permissionId=" + permissionId + ", username=" + username + ", password=" + password + ", email=" + email + "]";
	}
}