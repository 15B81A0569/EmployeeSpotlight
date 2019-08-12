package com.rythmos.employeeSpotlight.dao;

import java.text.ParseException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.rythmos.employeeSpotlight.entity.User;
import com.rythmos.employeeSpotlight.entity.UserProfile;
import com.rythmos.employeeSpotlight.repository.UserProfileRepository;
import com.rythmos.employeeSpotlight.repository.UserRepository;
import com.rythmos.employeeSpotlight.request.GetOtherProfile;
import com.rythmos.employeeSpotlight.request.UpdateProfileJSONRequest;
import com.rythmos.employeeSpotlight.request.UserProfileJSONSender;

@Transactional
@Component
public class HomeDao {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserProfileRepository userProfileRepository;
	/*
	public UserProfileJSONSender getUserProfile(LoginJSONRequest loginJSONRequest) throws ParseException
	{
		UserProfile userProfile=new UserProfile();
		findUserProfileByEmpId(User)
		
	}
	*/
	public ResponseEntity<?> updateProfile(@RequestBody UpdateProfileJSONRequest updateProfileJSONRequest ) throws ParseException
	{
		//UserProfile userProfile=new UserProfile();
		UserProfile userProfile=userProfileRepository.findUserProfileByEmpId(UserDAO.getEmpid());
		//userProfile.setEmpid(updateProfileJSONRequest.getEmpid());
		userProfile.setHighestEducation(updateProfileJSONRequest.getHighestEducation());
		userProfile.setInterest(updateProfileJSONRequest.getInterest());
		userProfile.setSkill(updateProfileJSONRequest.getSkill());
		userProfile.setCertification(updateProfileJSONRequest.getCertification());
		userProfile.setWorkExperience(updateProfileJSONRequest.getWorkExperience());
		if(userProfileRepository.save(userProfile)!=null)
			return new ResponseEntity<>(HttpStatus.OK);
			
		else
		{
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
			
		/*UserProfile userProfile=userProfileRepository.findUserProfileByEmpId(userProfileJSONRequest.getEmpid());
//		UserProfile  userProfile=new UserProfile();
			userProfile.setEmpid(userProfileJSONRequest.getEmpid());
			//userProfileRepository.updateHighestEducation(userProfileJSONRequest.getHighestEducation());
			userProfile.setHighestEducation(userProfileJSONRequest.getHighestEducation());
			userProfile.setInterest(userProfileJSONRequest.getInterest());
			userProfile.setSkill(userProfileJSONRequest.getSkill());
			userProfile.setCertification(userProfileJSONRequest.getCertification());
			userProfile.setWorkExperience(userProfileJSONRequest.getWorkExperience());
			
			
			if(userProfileRepository.save(userProfile)!=null) {
				return new ResponseEntity<>(HttpStatus.OK);
			}
			
			else
			{
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	
		}
		*/
		
		
		
	}
	
	public ResponseEntity<?> getUserProfile(String empid)
	{
			UserProfileJSONSender userProfileJSONSender=new UserProfileJSONSender();
			UserProfile userProfile=userProfileRepository.findUserProfileByEmpId(empid);
    		User user= userRepository.findUserByEmpId(empid);
    		userProfileJSONSender.setName(user.getName());
    		userProfileJSONSender.setEmail(user.getEmail());
    		userProfileJSONSender.setHighestEducation(userProfile.getHighestEducation());
    		userProfileJSONSender.setInterest(userProfile.getInterest());
    		userProfileJSONSender.setSkill(userProfile.getSkill());
    		userProfileJSONSender.setCertification(userProfile.getCertification());
    		userProfileJSONSender.setWorkExperience(userProfile.getWorkExperience());
    		return new ResponseEntity<>(userProfileJSONSender,HttpStatus.OK);
		
	}
	public ResponseEntity<?> getOtherProfile(String name)
    {
		System.out.println("the name is "+name);
		UserProfileJSONSender userProfileJSONSender=new UserProfileJSONSender();
		User user=userRepository.findUserProfileByName(name);
		if(user!=null) {
		UserProfile userProfile= userProfileRepository.findUserProfileByEmpId(user.getEmpid());
		userProfileJSONSender.setName(user.getName());
		userProfileJSONSender.setEmail(user.getEmail());
		userProfileJSONSender.setHighestEducation(userProfile.getHighestEducation());
		userProfileJSONSender.setInterest(userProfile.getInterest());
		userProfileJSONSender.setSkill(userProfile.getSkill());
		userProfileJSONSender.setCertification(userProfile.getCertification());
		userProfileJSONSender.setWorkExperience(userProfile.getWorkExperience());
		return new ResponseEntity<>(userProfileJSONSender,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	
	
}
