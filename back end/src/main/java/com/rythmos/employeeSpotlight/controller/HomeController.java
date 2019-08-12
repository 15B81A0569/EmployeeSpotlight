package com.rythmos.employeeSpotlight.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rythmos.employeeSpotlight.dao.UserDAO;
import com.rythmos.employeeSpotlight.repository.UserProfileRepository;
import com.rythmos.employeeSpotlight.repository.UserRepository;
import com.rythmos.employeeSpotlight.request.GetOtherProfile;
import com.rythmos.employeeSpotlight.request.UpdateProfileJSONRequest;
import com.rythmos.employeeSpotlight.services.HomeService;



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*",maxAge=3600)
public class HomeController {
	
	public static String name;	
	   
	@Autowired
    private HomeService homeService;
    @Autowired
    private UserProfileRepository userProfileRepository;
    @Autowired
    private UserRepository userRepository; 
  
    @RequestMapping("/getProfile")
    public ResponseEntity<?> getUserProfile()
    {
        
    
    		return homeService.getUserProfile(UserDAO.getEmpid());
    	//return new ResponseEntity<>(userProfileRepository.findUserProfileByEmpId(empid),HttpStatus.OK);
    }
    @PutMapping("/updateProfile")
    public ResponseEntity<?> updateProfile(@RequestBody UpdateProfileJSONRequest updateProfileJSONRequest) throws ParseException
    {
    	return homeService.updateProfile(updateProfileJSONRequest);
    }
    @PutMapping("/search")
    public ResponseEntity<?> searchByName(@RequestBody GetOtherProfile getOtherProfile)
    {
    	name= getOtherProfile.getName();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping("/otherprofile")
    public ResponseEntity<?> getOtherProfile()
    {
    	return homeService.getOtherProfile(name);
    }
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		HomeController.name = name;
	}
    
}
