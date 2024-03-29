 package com.dasare.estoque.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.dasare.estoque.model.Client;
import com.dasare.estoque.record.ClientRecord;
import com.dasare.estoque.record.reponse.ClientRecordResponse;
import com.dasare.estoque.service.ClientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/client")
@Tag(name = "Client", description = "Endpoints for managing Client")
public class ClientController {
	
	@Autowired
	ClientService clientService;

	ClientRecordResponse clientResponse;

	@PostMapping(value = "/save", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Client> saveClient(@RequestBody ClientRecord clientRecord) {
		var client = new Client();
		BeanUtils.copyProperties(clientRecord, client);
		return ResponseEntity.status(HttpStatus.CREATED).body(clientService.saveClient(client));
	}

	@CrossOrigin(origins = "http://localhost:8080") // seta quais dominios permite acessa minha API
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@Operation(summary = "Find a Client", description = "Find a Client", tags = { "Client" }, responses = {
			@ApiResponse(description = "Sucess", responseCode = "200", 
			content = @Content(schema = @Schema(implementation = ClientRecordResponse.class))),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content) })
	public ResponseEntity<ClientRecordResponse> findById(@PathVariable Long id) {

		return ResponseEntity.status(HttpStatus.OK).body(clientService.findByID(id));
	}

	@GetMapping(value = "/get/{name}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@Operation(summary = "Finds a Client by name", description = "Finds one or more Client by name", tags = {
			"Client" }, responses = { @ApiResponse(description = "Sucess", responseCode = "200", content = {
					@Content(mediaType = "application/Json", array = @ArraySchema(schema = @Schema(implementation = ClientRecordResponse.class))) }),
					@ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content) })
	ResponseEntity<List<ClientRecordResponse>> bYName(@PathVariable String name) {
		return ResponseEntity.status(HttpStatus.OK).body(clientService.getByName(name));
	}

	@GetMapping(value = "/all", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@Operation(summary = "Finds all Client", description = "Finds all Client", tags = { "Client" }, responses = {
			@ApiResponse(description = "Sucess", responseCode = "200", content = {
					@Content(mediaType = "application/Json", array = @ArraySchema(schema = @Schema(implementation = ClientRecordResponse.class))) }),
			@ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content) })
	public ResponseEntity<List<ClientRecordResponse>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(clientService.getAllClient());
	}

	@PutMapping(value = "/update", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, 
								   produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	@Operation(summary = "Update a Client", description = "Update a Client", tags = { "Client" }, responses = {
			@ApiResponse(description = "Sucess", responseCode = "200", content = @Content(schema = @Schema(implementation = ClientRecordResponse.class))),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content) })
	public ResponseEntity<String> upDateClient(@RequestBody ClientRecord clientrecord) {
		var client = new Client();
		BeanUtils.copyProperties(clientrecord, client);
		clientService.upDateClient(client);
		return ResponseEntity.status(HttpStatus.OK).body("Sucesffuly");
	}

	@DeleteMapping("/delete/{id}")
	@Operation(summary = "Delete a Client", description = "Delete a Client", tags = { "Client" }, responses = {
			@ApiResponse(description = "No content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content) })
	public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
		clientService.deleteClient(id);
		return ResponseEntity.noContent().build();
	}
}