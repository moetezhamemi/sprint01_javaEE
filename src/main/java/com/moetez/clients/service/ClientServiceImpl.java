package com.moetez.clients.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.moetez.clients.entities.Client;
import com.moetez.clients.repos.ClientRepository;
@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
	ClientRepository clientRepository;
	@Override
	public Client saveClient(Client c) {
		
		return clientRepository.save(c);
	}

	@Override
	public Client updateClient(Client c) {
		return clientRepository.save(c);
	}

	@Override
	public void deleteClient(Client c) {
		 clientRepository.delete(c);
		
	}

	@Override
	public void deleteClientById(Long id) {
		
		clientRepository.deleteById(id);
	}

	@Override
	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}

	@Override
	public Client getClient(Long id) {
		return clientRepository.findById(id).get();
	}
	@Override
	public Page<Client> getAllClientsParPage(int page, int size){
		return clientRepository.findAll(PageRequest.of(page, size));
	}

}