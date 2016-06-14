package com.japrod.sharebox.server.controller;

import java.security.InvalidParameterException;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.japrod.sharebox.server.dto.UserDto;
import com.japrod.sharebox.server.exception.MissingFixtureException;
import com.japrod.sharebox.server.exception.UserNameAlreadyTakenException;
import com.japrod.sharebox.server.model.User;
import com.japrod.sharebox.server.service.UserService;

import springfox.documentation.annotations.ApiIgnore;

/**
 * The Class UserController.
 */
@RestController
@RequestMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController extends AbstractController {

	/** The user service. */
	@Autowired
	private UserService userService;

	/**
	 * Register a new user.
	 *
	 * @param userDto the user to register
	 * @param errors the validation errors
	 * @return the created user
	 * @throws UserNameAlreadyTakenException if the user name is already used
	 * @throws MissingFixtureException if some fixtures are missing in the database, some roles in the case
	 */
	@Transactional
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public User register(@Valid @RequestBody UserDto userDto, @ApiIgnore Errors errors)
			throws UserNameAlreadyTakenException, MissingFixtureException {
		if (!errors.hasErrors()) {
			return userService.create(userDto);
		} else {
			throw new InvalidParameterException();
		}
	}

	/**
	 * List all users.
	 * is only accessible to users with administrator role.
	 *
	 * @return the list of all users
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Iterable<User> list() {
		return userService.getAll();
	}
}
