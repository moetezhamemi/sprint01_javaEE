package com.moetez.clients.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.moetez.clients.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}