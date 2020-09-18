package com.zemoso.blogservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zemoso.blogservice.exception.ResourceNotFoundException;
import com.zemoso.blogservice.model.User;
import com.zemoso.blogservice.service.UserService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("users")
	public List<User> getAllBlogs() {
		return this.userService.getAllUsers();
	}

	@GetMapping("users/exist/{userName}")
	public Boolean doesUserExist(@PathVariable(value = "userName") String userName) {
		
		boolean isUserExist = false;
		try {
			Long countOfRecords = this.userService.getUserIdOfUserByUserName(userName);
			if(countOfRecords > 0 && countOfRecords == 1)
				isUserExist=true;
		else
				isUserExist=false;
		
		}
		catch(Exception e) {
			System.out.println("Exception");
			e.printStackTrace();
		}
		
		return isUserExist;
	}
	
	
	@GetMapping("users/{uId}")
	public ResponseEntity<User> getBlogById(@PathVariable(value = "uId") Long uId) throws ResourceNotFoundException {
		return ResponseEntity.ok().body(this.userService.getUserById(uId));
	}

	@PostMapping("users")
	public User createUser(@RequestBody User user) {
		return this.userService.createUser(user);
	}

	@PutMapping("users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId, @RequestBody User user)
			throws ResourceNotFoundException {
		User userFromDB = userService.getUserById(userId);
		
		userFromDB.setUserId(user.getUserId());
		userFromDB.setFirstName(user.getFirstName());
		userFromDB.setLastName(user.getLastName());
		userFromDB.setAbout(user.getAbout());
		userFromDB.setTwitterUrl(user.getTwitterUrl());
		userFromDB.setCreatedDate(user.getCreatedDate());
		userFromDB.setUpdatedDate(user.getUpdatedDate());
		userFromDB.setActive(user.isActive());
		userFromDB.setAvatarLink(user.getAvatarLink());
		userFromDB.setUserName(user.getUserName());
		
		return ResponseEntity.ok(userService.createUser(userFromDB));
	}
	
	@DeleteMapping("users/{id}")
	public Map<String,Boolean> deleteBlog(@PathVariable(value="id") Long userId) throws ResourceNotFoundException{
		User userFromDB = userService.getUserById(userId);
		return userService.deleteUser(userFromDB);
	}
	
	
	

}
