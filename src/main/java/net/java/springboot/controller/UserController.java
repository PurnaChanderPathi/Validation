package net.java.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import net.java.springboot.model.User;
import net.java.springboot.service.UserService;

@RestController
@RequestMapping("/api/")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("user")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user)
	{
		User savedUser=userService.createUser(user);
		return new ResponseEntity<User>(savedUser,HttpStatus.CREATED);
		
	}

}
