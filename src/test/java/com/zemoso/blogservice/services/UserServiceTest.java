package com.zemoso.blogservice.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.zemoso.blogservice.model.User;
import com.zemoso.blogservice.repository.UserRepository;
import com.zemoso.blogservice.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	
	@InjectMocks
	private UserService userService;
	
	@Mock
	private UserRepository userRepository;
	
	@Test
	public void testGetAllUsers() {
		List<User> userList = new ArrayList<>();
		Mockito.when(userRepository.findAll()).thenReturn(userList);
		List<User> userListReturned = userService.getAllUsers();
		assertEquals(0,userListReturned.size());	
	}
}
