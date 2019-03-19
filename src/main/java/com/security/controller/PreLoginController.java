package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.domain.Response;
import com.security.model.User;
import com.security.service.UserService2;

@RestController
public class PreLoginController {

	@Autowired
	private UserService2 userService;
	
	@PostMapping(value="/registrartion")
	public ResponseEntity<Response> registration(@RequestBody User user){
		User dbUser = userService.save(user);
		if(dbUser != null) {
			return new ResponseEntity<Response>(new Response("User registration done successfully"),HttpStatus.OK);
		}
		return null;
	}
	
}
