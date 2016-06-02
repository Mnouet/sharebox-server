package com.japrod.sharebox.server.controller;

import java.security.InvalidParameterException;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.japrod.sharebox.server.exception.MissingFixtureException;
import com.japrod.sharebox.server.exception.UserNameAlreadyTakenException;

/**
 * class managing RegisterController exceptions
 * @author alex
 * @see RegisterControllerTest
 */
@ControllerAdvice
public class RegisterControllerAdvice {
	@ResponseBody
	@ExceptionHandler(UserNameAlreadyTakenException.class)
	@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Username already taken")
	VndErrors userNameAlreadyTakenHandler() {
		return new VndErrors("error", "Username already taken");
	}
	
	@ResponseBody
	@ExceptionHandler(MissingFixtureException.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Missing fixture")
	VndErrors missingFixtureHandler() {
		return new VndErrors("error", "Missing fixture");
	}
	
	@ResponseBody
	@ExceptionHandler(InvalidParameterException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid parameters given")
	VndErrors invalidParameterHandler() {
		return new VndErrors("error", "Invalid parameters given");
	}
}
