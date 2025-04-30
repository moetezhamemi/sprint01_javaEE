package com.moetez.clients.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.moetez.clients.entities.Client;
import com.moetez.clients.entities.Type;
import com.moetez.clients.repos.ClientRepository;
import com.moetez.clients.repos.TypeRepository;
import com.moetez.dto.ClientDto;
@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	TypeRepository typeRepository;
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

	@Override
	public List<Client> findByNomclient(String nom) {
		return clientRepository.findByNomclient(nom);
	}

	@Override
	public List<Client> findByNomclientContains(String nom) {
		return clientRepository.findByNomclientContains(nom);
	}

	@Override
	public List<Client> findByNomAdresse(String nom, String adresse) {
		return clientRepository.findByNomAdresse(nom, adresse);
	}

	@Override
	public List<Client> findByType(Type type) {
		return clientRepository.findByType(type);
	}

	@Override
	public List<Client> findByTypeIdType(Long id) {
		return clientRepository.findByTypeIdType(id);
	}

	@Override
	public List<Client> findByOrderByNomclientAsc() {
		return clientRepository.findByOrderByNomclientAsc();
	}

	@Override
	public List<Client> trierClientsNomsAdresse() {
		return clientRepository.trierClientsNomsAdresse();
	}
	@Override
	public List<Type> getAllTypes()
	{
		return typeRepository.findAll();
	}
	@Override
	public ClientDto convertEntityToDto(Client client) {
	 ClientDto clientDTO = new ClientDto();
	 clientDTO.setIdClient(client.getIdclient());
	 clientDTO.setAdresseclient(client.getAdresseclient());
	 clientDTO.setDateInscription(client.getDateinscription());
	 clientDTO.setEmailclient(client.getEmailclient());
	 
	}


	 /*return ProduitDTO.builder()
	.idProduit(produit.getIdProduit())
	.nomProduit(produit.getNomProduit())
	.prixProduit(produit.getPrixProduit())
	.dateCreation(p.getDateCreation())
	.categorie(produit.getCategorie())
	.build();*/
	}

}