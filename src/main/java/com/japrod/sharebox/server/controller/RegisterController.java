package com.japrod.sharebox.server.controller;

import java.security.InvalidParameterException;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.japrod.sharebox.server.dto.UserDto;
import com.japrod.sharebox.server.exception.UserNameAlreadyTakenException;
import com.japrod.sharebox.server.model.User;
import com.japrod.sharebox.server.service.UserService;

@RestController
public class RegisterController extends AbstractController {

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
	 */
	@Transactional
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public User registerUserAccount(@Valid @RequestBody UserDto userDto, Errors errors)
			throws UserNameAlreadyTakenException {
		if (!errors.hasErrors()) {
			return userService.create(userDto);
		} else {
			throw new InvalidParameterException();
		}
	}
}
