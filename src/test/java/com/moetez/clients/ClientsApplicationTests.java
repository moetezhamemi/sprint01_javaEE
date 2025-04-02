package com.moetez.clients;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.moetez.clients.entities.Client;
import com.moetez.clients.repos.ClientRepository;
import com.moetez.clients.service.ClientService;

@SpringBootTest
class ClientsApplicationTests {

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private ClientService clientService;

	@Test
	public void testCreateClient() {
		Client client = new Client("moetez", "moetez@email.com", new Date(), "nabeul");
		clientRepository.save(client);
	}

	@Test
	public void testFindCLient() {
		Client c = clientRepository.findById(2L).get();
		System.out.println(c);
	}

	@Test
	public void testUpdateClient() {
		Client c = clientRepository.findById(2L).get();
		c.setAdresseclient("tunis");
		clientRepository.save(c);
	}

	@Test
	public void testDeleteClient() {
		clientRepository.deleteById(1L);
		;
	}

	@Test
	public void testListerTousClients() {
		List<Client> cls = clientRepository.findAll();
		for (Client c : cls) {
			System.out.println(c);
		}

	}

	@Test
	public void testFindByNomProduitContains() {
		Page<Client> cls = clientService.getAllClientsParPage(0, 2);
		System.out.println(cls.getSize());
		System.out.println(cls.getTotalElements());
		System.out.println(cls.getTotalPages());
		cls.getContent().forEach(c -> {
			System.out.println(c.toString());
		});
	}

}
