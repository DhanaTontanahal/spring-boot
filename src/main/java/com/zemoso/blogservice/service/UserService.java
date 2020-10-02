package com.zemoso.blogservice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zemoso.blogservice.exception.ResourceNotFoundException;
import com.zemoso.blogservice.model.User;
import com.zemoso.blogservice.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers() {
		return this.userRepository.findAll();
	}
	
	public Long getUserIdOfUserByUserName(String userName) {
		return this.userRepository.getUserIdOfUserByUserName(userName);
	}
	
	public User getUserById(Long uId) throws ResourceNotFoundException {
		return this.userRepository.findById(uId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
	}
	
	public User createUser(User user) {
		return this.userRepository.save(user);
	}
	
	public Map<String,Boolean> deleteUser(User user) throws ResourceNotFoundException{
		
		this.userRepository.delete(user);
		
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
		
	}
	

}
