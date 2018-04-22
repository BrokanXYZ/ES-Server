package com.earthsenseserver.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.repository.support.BasicMapId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastax.driver.core.utils.UUIDs;
import com.earthsenseserver.model.User;
import com.earthsenseserver.repo.UserRepository;

@CrossOrigin /*(origins = {"http://10.9.1.100:3000", "http://127.0.0.1:3000"})*/
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@GetMapping("/user")
	public List<User> getAllUsers() {
		System.out.println("Getting all Users...");

		List<User> user = new ArrayList<>();
		userRepository.findAll().forEach(user::add);
		return user;
	}

	@PostMapping(path="/user/create", consumes = "application/json", produces = "application/json")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		System.out.println("Creating User : " + user.getUsername());

		user.setUserId(UUIDs.timeBased());

		User _user = userRepository.save(user);
		return new ResponseEntity<>(_user, HttpStatus.OK);
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateNode(@PathVariable("id") UUID id, @RequestBody User user) {
		System.out.println("Update User with ID = " + id + "...");

		User userData = userRepository.findOne(BasicMapId.id("userId", id));
		if (userData == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		userData.setPermissionId(user.getPermissionId());
		userData.setUsername(user.getUsername());
		userData.setPassword(user.getPassword());
		userData.setEmail(user.getEmail());

		User updatedUser = userRepository.save(userData);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") UUID id) {
		System.out.println("Delete User with ID = " + id + "...");

		userRepository.delete(BasicMapId.id("userId", id));

		return new ResponseEntity<>("User has been deleted!", HttpStatus.OK);
	}

}
