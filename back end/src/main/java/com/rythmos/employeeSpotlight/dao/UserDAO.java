package com.rythmos.employeeSpotlight.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.rythmos.employeeSpotlight.entity.Login;
import com.rythmos.employeeSpotlight.entity.User;
import com.rythmos.employeeSpotlight.entity.UserProfile;
import com.rythmos.employeeSpotlight.repository.LoginRepository;
import com.rythmos.employeeSpotlight.repository.UserProfileRepository;
import com.rythmos.employeeSpotlight.repository.UserRepository;
import com.rythmos.employeeSpotlight.request.LoginJSONRequest;
import com.rythmos.employeeSpotlight.request.SignupJSONRequest;
@Transactional
@Component
public class UserDAO {
	public static String empid;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private LoginRepository loginRepository;
	@Autowired
	private UserProfileRepository userProfileRepository; 
	public ResponseEntity<?>saveMyUser(SignupJSONRequest signupJSONRequest) throws ParseException{
		Date date=new SimpleDateFormat("dd/MM/yyyy").parse(signupJSONRequest.getDateOfJoining());
		System.out.printf("date is",date.getClass());
		User user=new User();
		user.setEmpid(signupJSONRequest.getEmpid());
		user.setName(signupJSONRequest.getName());
		UserProfile userProfile=new UserProfile();
		user.setDateOfJoining(new java.sql.Date(date.getTime()));
		user.setEmail(signupJSONRequest.getEmail());
		user.setPassword(signupJSONRequest.getPassword());
		
		if(userRepository.save(user)!=null) {
			userProfile.setEmpid(signupJSONRequest.getEmpid());
			userProfileRepository.save(userProfile);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		else
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	public ResponseEntity<?> findByUsernameAndPassword(LoginJSONRequest loginJSONRequest)
	{
		User user=userRepository.findUserByEmpId(loginJSONRequest.getEmpid());
		if(user!=null)
		{
			if(user.getPassword().equals(loginJSONRequest.getPassword()))
			{   
				setEmpid(user.getEmpid());
				Login login=new Login();
				//UserProfile userprofile=new UserProfile();
				login.setEmpid(loginJSONRequest.getEmpid());
				//userprofile.setEmpid(loginJSONRequest.getEmpid());
				login.setPassword(loginJSONRequest.getPassword());
				
				
				java.util.Date date = new java.util.Date();

				java.text.SimpleDateFormat sdf = 
				     new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

				String currentTime = sdf.format(date);
				login.setLoginTime(currentTime);
				//userProfileRepository.save(userprofile);
				if(loginRepository.save(login)!=null)
					System.out.println("Login details saved");
				else
					System.out.println("Login details not saved");
				
				return new ResponseEntity<>(HttpStatus.OK);
			
			}
			else
			{
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		else
		{
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	
		
		
	}

	public static String getEmpid() {
		return empid;
	}

	public static void setEmpid(String empid) {
		UserDAO.empid = empid;
	}
	

}
