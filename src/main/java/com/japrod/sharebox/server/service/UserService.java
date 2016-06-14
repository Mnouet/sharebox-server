package com.japrod.sharebox.server.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.japrod.sharebox.server.dto.UserDto;
import com.japrod.sharebox.server.exception.MissingFixtureException;
import com.japrod.sharebox.server.exception.UserNameAlreadyTakenException;
import com.japrod.sharebox.server.model.User;

public interface UserService extends UserDetailsService{

	/**
     * Create a new user.
     *
     * @param user
     *            the user top create
     * @return the created user
     * @throws UserNameAlreadyTakenException
     *             if the user name is already used
     */
    public User create(UserDto user) throws UserNameAlreadyTakenException, MissingFixtureException;
    
    /**
     * get all users
     * @return all users
     */
    public Iterable<User> getAll();
	
}
