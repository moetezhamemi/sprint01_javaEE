package com.moetez.clients.service;
import com.moetez.clients.entities.Client;
import java.util.List;

import org.springframework.data.domain.Page;



public interface ClientService {
	Client saveClient(Client c);
	Client updateClient(Client c);
	void deleteClient(Client c);
	void deleteClientById(Long id);
	Client getClient(Long id);
	List<Client> getAllClients();
	Page<Client> getAllClientsParPage(int page, int size);


}
