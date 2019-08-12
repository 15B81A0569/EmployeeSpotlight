package com.rythmos.employeeSpotlight.services;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.rythmos.employeeSpotlight.dao.HomeDao;
import com.rythmos.employeeSpotlight.request.GetOtherProfile;
import com.rythmos.employeeSpotlight.request.UpdateProfileJSONRequest;
@Service
public class HomeService {
	
	@Autowired
	HomeDao homeDao;
	
	public ResponseEntity<?> updateProfile(@RequestBody UpdateProfileJSONRequest updateProfileJSONRequest  ) throws ParseException
	{
	    return homeDao.updateProfile(updateProfileJSONRequest);
	}
	public ResponseEntity<?> getUserProfile(String empid)
	{
		return homeDao.getUserProfile(empid);
	}
	 public ResponseEntity<?> getOtherProfile(String name)
	    {
	    	return homeDao.getOtherProfile(name);
	    }
	

}
