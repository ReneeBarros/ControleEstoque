package com.dasare.estoque.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dasare.estoque.model.Manager;
import com.dasare.estoque.service.ManagerService;

@RestController
@RequestMapping("/managers")
public class ManagerController {

	@Autowired
	ManagerService managerService;

	@PostMapping(value = "/save", 
			consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, 
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Manager> saveClient(@RequestBody Manager managerLider) {
		var manager = new Manager();
		BeanUtils.copyProperties(managerLider, manager);
		return ResponseEntity.status(HttpStatus.CREATED).body(managerService.saveManager(manager));
	}

	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Optional<Manager>> findById(@PathVariable Long id) {

		return ResponseEntity.status(HttpStatus.OK).body(managerService.findById(id));
	}

	@GetMapping(value = "/get/{name}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	ResponseEntity<Manager> bYName(@PathVariable String name) {
		return ResponseEntity.status(HttpStatus.OK).body(managerService.findByName(name));
	}

	@GetMapping(value = "/all", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<Manager>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(managerService.getAllManager());
	}

	@PutMapping(value = "/update", 
			consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, 
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<String> upDateClient(@RequestBody Manager managers) {
		managerService.upDateManager(managers);
		return ResponseEntity.status(HttpStatus.OK).body("Sucesffuly");
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteClient(@PathVariable Long id) {
		managerService.deleteManager(id);
		return ResponseEntity.status(HttpStatus.OK).body("Deleted Sucesffuly");
	}

}
