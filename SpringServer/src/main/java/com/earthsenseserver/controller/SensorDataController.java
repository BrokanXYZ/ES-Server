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
import com.earthsenseserver.model.SensorData;
import com.earthsenseserver.model.SensorDataKey;
import com.earthsenseserver.repo.SensorDataRepository;

@CrossOrigin(origins = "http://10.9.1.100:4200")
@RestController
@RequestMapping("/api")
public class SensorDataController {

	@Autowired
	SensorDataRepository sensorDataRepository;

	@GetMapping("/sensordata")
	public List<SensorData> getAllSensorData() {
		System.out.println("Getting all Sensor Data...");

		List<SensorData> sensordata = new ArrayList<>();
		sensorDataRepository.findAll().forEach(sensordata::add);
		return sensordata;
	}
	
	@GetMapping("/sensordata/{id}")
	public ResponseEntity<List<SensorData>> getOneSensorData(@PathVariable("id") UUID id) {
		System.out.println("Getting all sensor-data for node with ID = " + id + "...");
		
		List<SensorData> sensordata = sensorDataRepository.findByNodeId(id);
		
		if (sensordata == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<SensorData>>(sensordata, HttpStatus.OK);
	}

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
