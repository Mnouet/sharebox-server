package com.japrod.sharebox.server.controller;

import java.security.InvalidParameterException;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

@RestController
public class UserController extends AbstractController {

	@Autowired
	private UserService userService;

	/**
	 * Register user account.
	 *
	 * @param userDto
	 *            the user dto
	 * @param result
	 *            the result
	 * @param errors
	 *            the errors
	 * @return the model and view
	 * @throws UserNameAlreadyTakenException
	 * @throws MissingFixtureException
	 */
	@Transactional
	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User register(@Valid @RequestBody UserDto userDto, @ApiIgnore Errors errors)
			throws UserNameAlreadyTakenException, MissingFixtureException {
		if (!errors.hasErrors()) {
			return userService.create(userDto);
		} else {
			throw new InvalidParameterException();
		}
	}
}
