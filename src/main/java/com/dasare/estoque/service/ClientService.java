package com.dasare.estoque.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dasare.estoque.Repository.ClientRepository;
import com.dasare.estoque.model.Client;

@Service
public class ClientService {

	ClientRepository clientRepository;

	private final void ClientRepository(ClientRepository clientRepository) {

		this.clientRepository = clientRepository;
	}

	public Client saveClient(Client client) {
		return clientRepository.save(client);
	}

	public Optional<Client> findById(Long id) {
		Optional<Client> client;
		if (id == null) {
			throw new IllegalArgumentException();
		}
		client = clientRepository.findById(id);
		if (client.isEmpty()) {
			throw new IllegalArgumentException();
		}
		return client;
	}
	
	public Client findByName (String name) {
		return clientRepository.findByName(name);
	}

	public Client upDateClient(Long id, Client client) {
		Optional<Client> c1;
		var cAux = new Client();
		c1 = findById(id);
		upDate(cAux, c1);
		return clientRepository.saveAndFlush(cAux);
	}

	private void upDate(Client cAux, Optional<Client> c1) {
		cAux.setName(c1.get().getName());
		cAux.setEnderco(c1.get().getEnderco());
	}
	
	public void deleteClient(Long id) {
		if (id == null) {
			throw new IllegalArgumentException();
		}
		clientRepository.deleteById(id);
	}
}
