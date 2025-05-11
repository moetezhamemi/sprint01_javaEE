package com.moetez.clients.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.moetez.clients.entities.Client;
import com.moetez.clients.entities.User;
import com.moetez.clients.service.ClientService;
import com.moetez.clients.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ClientRESTController {

	@Autowired
	ClientService clientService;

	@RequestMapping(path="all",method = RequestMethod.GET)
	public List<Client> getAllClients() {
		return clientService.getAllClients();
	}
	@RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
	public Client getClientById(@PathVariable("id") Long id) {
		return clientService.getClient(id);
	}

	@RequestMapping(path="/addclient" ,method = RequestMethod.POST)
	public Client createClient(@RequestBody Client client) {
		return clientService.saveClient(client);
	}

	@RequestMapping(path="/updateclient",method = RequestMethod.PUT)
	public Client updateClient(@RequestBody Client client) {
		return clientService.updateClient(client);
	}
	@RequestMapping(value = "/delclient/{id}", method = RequestMethod.DELETE)
	public void deleteClient(@PathVariable("id") Long id) {
		clientService.deleteClientById(id);
	}
	@RequestMapping(value="/clstype/{idType}",method = RequestMethod.GET)
	public List<Client> getClientsByTypeId(@PathVariable("idType") Long idType) {
	return clientService.findByTypeIdType(idType);
	}
	@GetMapping("/clientsByName/{nom}")
	public List<Client> findByNomClientContains(@PathVariable("nom") String nom) {
	    return clientService.findByNomclientContains(nom);
	}
}