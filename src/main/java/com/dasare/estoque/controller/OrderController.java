 package com.dasare.estoque.controller;

import java.util.List;

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

import com.dasare.estoque.model.Order;
import com.dasare.estoque.record.reponse.ClientRecordResponse;
import com.dasare.estoque.service.OrderService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/order")
@Tag(name = "Order", description = "Endpoints for managing Order")
public class OrderController {
	
	@Autowired
	OrderService orderService;

	ClientRecordResponse clientResponse;

	@PostMapping(value = "/save", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Order> saveClient(@RequestBody Order order) {
		return ResponseEntity.status(HttpStatus.CREATED).body(orderService.saveOrder(order));
	}

	@CrossOrigin(origins = "http://localhost:8080") // seta quais dominios permite acessa minha API
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@Operation(summary = "Find a Order", description = "Find a Order", tags = { "Order" }, responses = {
			@ApiResponse(description = "Sucess", responseCode = "200", 
			content = @Content(schema = @Schema(implementation = Order.class))),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content) })
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(orderService.findById(id));
	}

	@GetMapping(value = "/all", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@Operation(summary = "Finds all Orders", description = "Finds all Orders", tags = { "Order" }, responses = {
			@ApiResponse(description = "Sucess", responseCode = "200", content = {
					@Content(mediaType = "application/Json", array = @ArraySchema(schema = @Schema(implementation = ClientRecordResponse.class))) }),
			@ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content) })
	public ResponseEntity<List<Order>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(orderService.AllOrder());
	}

	@PutMapping(value = "/update", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, 
								   produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	@Operation(summary = "Update a Order", description = "Update a Status of Order", tags = { "Order" }, responses = {
			@ApiResponse(description = "Sucess", responseCode = "200", content = @Content(schema = @Schema(implementation = ClientRecordResponse.class))),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content) })
	public ResponseEntity<String> upDateClient(@RequestBody Order order) {
		orderService.upDateStatusOrder(order);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@DeleteMapping("/delete/{id}")
	@Operation(summary = "Delete a Order", description = "Delete a Order", tags = { "Order" }, responses = {
			@ApiResponse(description = "No content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content) })
	public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
		orderService.deleteOrder(id);
		return ResponseEntity.noContent().build();
	}
}