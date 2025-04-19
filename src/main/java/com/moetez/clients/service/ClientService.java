package com.moetez.clients.service;
import com.moetez.clients.entities.Client;
import com.moetez.clients.entities.Type;
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
	List<Client> findByNomclient(String nom);
	List<Client> findByNomclientContains(String nom);
	List<Client> findByNomAdresse (String nom, String adresse);
	List<Client> findByType (Type type);
	List<Client> findByTypeIdType(Long id);
	List<Client> findByOrderByNomclientAsc();
	List<Client> trierClientsNomsAdresse();
	List<Type> getAllTypes();


}
