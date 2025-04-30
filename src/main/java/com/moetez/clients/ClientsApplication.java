package com.moetez.clients;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.moetez.clients.entities.Client;
import com.moetez.clients.entities.Role;
import com.moetez.clients.entities.User;
import com.moetez.clients.service.ClientService;
import com.moetez.clients.service.UserService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class ClientsApplication implements CommandLineRunner {
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(ClientsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//System.out.println("Password Encoded BCRYPT :******************** ");
		// System.out.println(passwordEncoder.encode("123"));
		//repositoryRestConfiguration.exposeIdsFor(Client.class);
	}
	/*
	 * @PostConstruct void init_users() { //ajouter les rôles aux users
	 * userService.addRoleToUser("admin", "ADMIN");
	 * userService.addRoleToUser("moetez", "AGENT");
	 * userService.addRoleToUser("user1", "USER"); }
	 */

	 
	
}
