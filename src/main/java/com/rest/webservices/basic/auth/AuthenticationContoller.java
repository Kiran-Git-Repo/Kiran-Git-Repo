package com.rest.webservices.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class AuthenticationContoller {
	@GetMapping("/basicauth")
	public AuthenticationBean basicUserIdPassValidationService() {
		return new AuthenticationBean("Hello from Local host");
	}
	
	

}
