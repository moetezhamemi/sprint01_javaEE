package com.moetez.clients.repos;
import com.moetez.clients.entities.Type;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.CrossOrigin;
@RepositoryRestResource(path = "types")
@CrossOrigin("http://localhost:4200/") 
public interface TypeRepository extends JpaRepository<Type,Long> {

}
