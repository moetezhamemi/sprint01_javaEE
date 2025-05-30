package com.moetez.clients.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.moetez.clients.entities.Client;
import com.moetez.clients.service.ClientService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ClientRESTController {

	@Autowired
	ClientService clientService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Client> getAllClients() {
		return clientService.getAllClients();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Client getClientById(@PathVariable("id") Long id) {
		return clientService.getClient(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Client createProduit(@RequestBody Client client) {
		return clientService.saveClient(client);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Client updateClient(@RequestBody Client client) {
		return clientService.updateClient(client);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteClient(@PathVariable("id") Long id) {
		clientService.deleteClientById(id);
	}
	@RequestMapping(value="/clstype/{idType}",method = RequestMethod.GET)
	public List<Client> getClientsByTypeId(@PathVariable("idType") Long idType) {
	return clientService.findByTypeIdType(idType);
	}

}