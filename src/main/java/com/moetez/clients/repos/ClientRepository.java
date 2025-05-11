package com.moetez.clients.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.moetez.clients.entities.Client;
import com.moetez.clients.entities.Type;

@RepositoryRestResource(path = "rest")
public interface ClientRepository extends JpaRepository<Client, Long> {
	List<Client> findByNomclient(String nomclient);
	List<Client> findByNomclientContains(String nom);
	@Query("select c from Client c where c.nomclient like %?1 and c.adresseclient like ?2")
	List<Client> findByNomAdresse (String nomclient, String adresseclient);
	@Query("select c from Client c where c.type = ?1")
	List<Client> findByType (Type type);
	List<Client> findByTypeIdType(Long idType);
	List<Client> findByOrderByNomclientAsc();
	@Query("select c from Client c order by c.nomclient ASC, c.adresseclient DESC")
	List<Client> trierClientsNomsAdresse ();
}
