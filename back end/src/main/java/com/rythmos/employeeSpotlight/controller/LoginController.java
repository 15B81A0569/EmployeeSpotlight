package com.rythmos.employeeSpotlight.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rythmos.employeeSpotlight.request.LoginJSONRequest;
import com.rythmos.employeeSpotlight.request.SignupJSONRequest;
import com.rythmos.employeeSpotlight.services.UserService;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*",maxAge=3600)
public class LoginController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/hello")
	public ResponseEntity<String> getMessage(){
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@PostMapping("/save-user")   
	public ResponseEntity<?> saveUser(@RequestBody SignupJSONRequest signupJSONRequest) throws ParseException{
		return userService.saveMyUser(signupJSONRequest);
	}
	
	@RequestMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginJSONRequest loginJSONRequest){
		
		return userService.findByUsernameAndPassword(loginJSONRequest);
	}
	
	  
	
	

}
