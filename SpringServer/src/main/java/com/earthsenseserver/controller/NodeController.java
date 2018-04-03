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
import com.earthsenseserver.model.Node;
import com.earthsenseserver.repo.NodeRepository;

@CrossOrigin(origins = "http://10.9.1.100:4200")
@RestController
@RequestMapping("/api")
public class NodeController {

	@Autowired
	NodeRepository nodeRepository;

	@GetMapping("/node")
	public List<Node> getAllNodes() {
		System.out.println("Getting all Nodes...");

		List<Node> nodes = new ArrayList<>();
		nodeRepository.findAll().forEach(nodes::add);
		return nodes;
	}

	@GetMapping("/node/{id}")
	public ResponseEntity<Node> getOneNode(@PathVariable("id") UUID id) {
		System.out.println("Getting node with ID = " + id + "...");

		Node nodeData = nodeRepository.findOne(BasicMapId.id("nodeId", id));
		if (nodeData == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(nodeData, HttpStatus.OK);
	}
	
	@PostMapping("/node/create")
	public ResponseEntity<Node> createNode(@Valid @RequestBody Node node) {
		System.out.println("Creating Node: " + node.getNodeName());
		
		node.setNodeId(UUIDs.timeBased());
		node.setStatus(0);
		
		Node _node = nodeRepository.save(node);
		return new ResponseEntity<>(_node, HttpStatus.OK);
	}

	@PutMapping("/node/{id}")
	public ResponseEntity<Node> updateNode(@PathVariable("id") UUID id, @RequestBody Node node) {
		System.out.println("Update Node with ID = " + id + "...");

		Node nodeData = nodeRepository.findOne(BasicMapId.id("id", id));
		if (nodeData == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		nodeData.setName(customer.getName());
		nodeData.setAge(customer.getAge());
		nodeData.setActive(customer.isActive());
		Node updatedNode = nodeRepository.save(nodeData);
		return new ResponseEntity<>(updatedNode, HttpStatus.OK);
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
