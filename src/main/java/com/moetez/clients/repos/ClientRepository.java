package com.moetez.clients.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moetez.clients.entities.Client;



public interface ClientRepository extends JpaRepository<Client, Long> {

}
