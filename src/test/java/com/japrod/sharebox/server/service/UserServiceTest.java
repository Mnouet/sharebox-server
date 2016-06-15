package com.japrod.sharebox.server.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import com.japrod.sharebox.server.dto.UserDto;
import com.japrod.sharebox.server.exception.MissingFixtureException;
import com.japrod.sharebox.server.exception.UserNameAlreadyTakenException;
import com.japrod.sharebox.server.model.Role;
import com.japrod.sharebox.server.model.User;
import com.japrod.sharebox.server.repository.RoleRepository;
import com.japrod.sharebox.server.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@InjectMocks
	private UserServiceImpl userService;

	@Mock
	private UserRepository userRepository;

	@Mock
	private RoleRepository roleRepository;

	@Test()
	public void createUserWithNonUsedLogin() {
		Mockito.when(userRepository.findByLogin(anyString())).thenReturn(null);
		Mockito.when(roleRepository.findByName("ROLE_USER")).thenReturn(new Role());
		Mockito.when(userRepository.save(any(User.class))).thenReturn(new User());
		UserDto uDto = new UserDto();
		//set password to avoid BCrypt nullPointerException
		uDto.setPassword("");
		try {
			User u = userService.create(uDto);
			assertTrue(u.getClass().equals(User.class));
		} catch (UserNameAlreadyTakenException | MissingFixtureException e) {
			assertTrue("a user with a non used login should be created", false);
		}
	}

	@Test(expected=UserNameAlreadyTakenException.class)
	public void createUserWithUsedLogin() throws UserNameAlreadyTakenException, MissingFixtureException {
		Mockito.when(userRepository.findByLogin(anyString())).thenReturn(new User());
		UserDto uDto = new UserDto();
		userService.create(uDto);
	}

}
