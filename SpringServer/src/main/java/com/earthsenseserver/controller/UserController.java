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

@CrossOrigin(origins = "http://10.9.1.100:4200")
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

	@PostMapping("/user/create")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		System.out.println("Creating User : " + user.getUsername());
		
		user.setUserId(UUIDs.timeBased());
		
		User _user = userRepository.save(user);
		return new ResponseEntity<>(_user, HttpStatus.OK);
	}

	/*@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") UUID id, @RequestBody Customer customer) {
		System.out.println("Update Customer with ID = " + id + "...");

		Customer customerData = customerRepository.findOne(BasicMapId.id("id", id));
		if (customerData == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		customerData.setName(customer.getName());
		customerData.setAge(customer.getAge());
		customerData.setActive(customer.isActive());
		Customer updatedcustomer = customerRepository.save(customerData);
		return new ResponseEntity<>(updatedcustomer, HttpStatus.OK);
	}*/

	/*@DeleteMapping("/customers/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") UUID id) {
		System.out.println("Delete Customer with ID = " + id + "...");

		customerRepository.delete(BasicMapId.id("id", id));

		return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK);
	}*/

	/*@DeleteMapping("/customers/delete")
	public ResponseEntity<String> deleteAllCustomers() {
		System.out.println("Delete All Customers...");

		customerRepository.deleteAll();

		return new ResponseEntity<>("All customers have been deleted!", HttpStatus.OK);
	}*/
}
