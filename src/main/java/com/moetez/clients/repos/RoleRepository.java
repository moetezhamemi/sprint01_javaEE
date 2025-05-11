package com.moetez.clients.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moetez.clients.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findFirstByRole(String role);
}
