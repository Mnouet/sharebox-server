package com.japrod.sharebox.server.controller;

import java.security.InvalidParameterException;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.japrod.sharebox.server.exception.UserNameAlreadyTakenException;

/**
 * class managing RegisterController exceptions
 * @author alex
 * @see RegisterController
 */
@ControllerAdvice
public class RegisterControllerAdvice {
	@ResponseBody
	@ExceptionHandler(UserNameAlreadyTakenException.class)
	@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Username already taken")
	VndErrors userNameAlreadyTakenHandler(UserNameAlreadyTakenException ex) {
		return new VndErrors("error", "Username already taken");
	}
	
	@ResponseBody
	@ExceptionHandler(InvalidParameterException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid parameters given")
	VndErrors invalidParameterHandler(InvalidParameterException ex) {
		return new VndErrors("error", "Invalid parameters given");
	}
}