package com.moetez.clients.service;

import com.moetez.clients.entities.Role;
import com.moetez.clients.entities.User;

public interface UserService {
	
	void deleteAllusers();
	
	void deleteAllRoles();
	
	User saveUser(User user);
	
	User findUserByUsername (String username);
	
	Role addRole(Role role);
	
	User addRoleToUser(String username, String rolename);
}
