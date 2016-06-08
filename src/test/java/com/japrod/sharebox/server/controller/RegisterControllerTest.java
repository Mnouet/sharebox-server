package com.japrod.sharebox.server.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.View;

import com.japrod.sharebox.server.dto.UserDto;
import com.japrod.sharebox.server.exception.MissingFixtureException;
import com.japrod.sharebox.server.exception.UserNameAlreadyTakenException;
import com.japrod.sharebox.server.model.User;
import com.japrod.sharebox.server.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class RegisterControllerTest {

	@InjectMocks
	private RegisterController registerController;

	@Mock
	private UserService userService;
	
	@Mock
    View mockView;
	
	MockMvc mockMvc;

	@Test
	public void registerValidUser() throws UserNameAlreadyTakenException, MissingFixtureException {
		// a refaire avec le mock MVC
		Mockito.when(userService.create(any(UserDto.class))).thenReturn(new User());
		UserDto uDto = new UserDto();
		uDto.setLogin("testUser");
		uDto.setName("test user");
		uDto.setPassword("123456");
	}

	@Test
	public void registerInvalidUserWithInvalidParameter() {

	}

}
