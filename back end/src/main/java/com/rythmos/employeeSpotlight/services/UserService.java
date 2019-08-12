package com.rythmos.employeeSpotlight.services;

import java.text.ParseException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rythmos.employeeSpotlight.dao.UserDAO;
import com.rythmos.employeeSpotlight.request.LoginJSONRequest;
import com.rythmos.employeeSpotlight.request.SignupJSONRequest;

@Service
public class UserService {

	@Autowired
	UserDAO userDao;
	

	public ResponseEntity<?>  saveMyUser(SignupJSONRequest signupJSONRequest) throws ParseException
	{
		System.out.println(new Date());
		return userDao.saveMyUser(signupJSONRequest);
		
	}
	public ResponseEntity<?> findByUsernameAndPassword(LoginJSONRequest loginJSONRequest ) 
	{
		return userDao.findByUsernameAndPassword(loginJSONRequest);
	}
}
