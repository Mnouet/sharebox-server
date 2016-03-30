package com.japrod.sharebox.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.japrod.sharebox.server.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	public User findByLogin(String login);
}
