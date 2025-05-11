package com.moetez.clients;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.moetez.clients.entities.Client;
import com.moetez.clients.entities.Type;
import com.moetez.clients.service.ClientService;


@SpringBootApplication(scanBasePackages = "com.moetez.clients")
public class ClientsApplication implements CommandLineRunner {
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	public static void main(String[] args) {
		SpringApplication.run(ClientsApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	    repositoryRestConfiguration.exposeIdsFor(Client.class, Type.class);
	}

}
