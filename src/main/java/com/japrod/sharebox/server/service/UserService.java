package com.japrod.sharebox.server.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.japrod.sharebox.server.dto.UserDto;
import com.japrod.sharebox.server.exception.MissingFixtureException;
import com.japrod.sharebox.server.exception.UserNameAlreadyTakenException;
import com.japrod.sharebox.server.model.User;

public interface UserService extends UserDetailsService{

	/**
     * Creates the user.
     *
     * @param user
     *            the user
     * @return the user
     * @throws UserNameAlreadyTakenException
     *             the user name already taken exception
     */
    public User create(UserDto user) throws UserNameAlreadyTakenException, MissingFixtureException;
	
}
