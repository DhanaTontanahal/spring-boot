package com.zemoso.blogservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping("/welcome")
	public String getMessage() {
		return "Welcome to ZeMoSo Technologies !!";
		
	}
	
	
	
}
