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

import com.dasare.estoque.model.Client;
import com.dasare.estoque.record.ClientRecord;
import com.dasare.estoque.record.reponse.ClientRecordResponse;
import com.dasare.estoque.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	ClientService clientService;
	
	ClientRecordResponse clientResponse;

	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Client> saveClient(@RequestBody ClientRecord clientRecord) {
		var client = new Client();
		BeanUtils.copyProperties(clientRecord, client);
		return ResponseEntity.status(HttpStatus.CREATED).body(clientService.saveClient(client));
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClientRecordResponse> findById(@PathVariable Long id) {

		return ResponseEntity.status(HttpStatus.OK).body(clientService.findByID(id));
	}

	@GetMapping(value = "/get/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<ClientRecordResponse>> bYName(@PathVariable String name) {
		return ResponseEntity.status(HttpStatus.OK).body(clientService.getByName(name));
	}

	@GetMapping(value = "/all",produces =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ClientRecordResponse>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(clientService.getAllClient());
	}

	@PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> upDateClient(@RequestBody ClientRecord clientrecord) {
		var client = new Client();
		BeanUtils.copyProperties(clientrecord, client);
		clientService.upDateClient(client);
		return ResponseEntity.status(HttpStatus.OK).body("Sucesffuly");
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
		clientService.deleteClient(id);
		return ResponseEntity.noContent().build();
	}
}