package com.dasare.estoque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.dasare.estoque.DTOmapper.ClientDTOmapper;
import com.dasare.estoque.Repository.ClientRepository;
import com.dasare.estoque.model.Client;
import com.dasare.estoque.record.reponse.ClientRecordResponse;
import com.dasare.estoque.service.execption.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepository;

	public Client saveClient(Client client) {
		var clientAux = new Client();
		clientAux.setName(client.getName());
		clientAux.setEnderco(client.getEnderco());
		clientAux.setManager(client.getManager());

		return clientRepository.save(clientAux);
	}

	public ClientRecordResponse findByID(Long id) {

		Optional<Client> client;
		var clientResponse = new ClientDTOmapper();
		client = clientRepository.findById(id);
		return clientResponse.ClientResponse(client.orElseThrow(() -> new ResourceNotFoundException(id)));

	}

	public List<ClientRecordResponse> getByName(String name) {
		var clientAux = new ClientDTOmapper();

		List<Client> client = new ArrayList<>();
		List<ClientRecordResponse> clientResponse = new ArrayList<>();
		client = clientRepository.findByName(name);
		for (Client c : client) {
			clientResponse.add(clientAux.ClientResponse(c));
		}
		return clientResponse;
	}

	public List<ClientRecordResponse> getAllClient() {
		var clientAux = new ClientDTOmapper();

		try {
			List<Client> client = new ArrayList<>();
			List<ClientRecordResponse> clientResponse = new ArrayList<>();
			client = clientRepository.findAll();

			for (Client c : client) {
				clientResponse.add(clientAux.ClientResponse(c));
			}
			return clientResponse;
		} catch (ResourceNotFoundException e) {
			e.getMessage();
		}
		return null;
	}

	public void upDateClient(Client client) {
		
		try {
		var cAux = new Client();
		cAux = clientRepository.getReferenceById(client.getClientID());

		cAux.setName(client.getName());
		cAux.setEnderco(client.getEnderco());
		clientRepository.save(client);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(client.getClientID());
		}
	}

	public void deleteClient(Long id) {
		try {
			var client = new Client();
			client = clientRepository.getReferenceById(id);
			clientRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
}
