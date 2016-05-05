package com.japrod.sharebox.server.repository;

import org.springframework.data.repository.CrudRepository;

import com.japrod.sharebox.server.model.Role;

public interface RoleRepository extends CrudRepository<Role, Integer>{

	public Role findByName(String name);
}
