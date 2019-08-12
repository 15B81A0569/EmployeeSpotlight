package com.rythmos.employeeSpotlight.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rythmos.employeeSpotlight.entity.User;
import com.rythmos.employeeSpotlight.entity.UserProfile;
import com.rythmos.employeeSpotlight.request.SearchRequest;


public interface UserRepository extends CrudRepository<User,Long> {
	
	@Query("from User where empid=:empid")
    User findUserByEmpId(@Param("empid") String empid);
	
	@Query("SELECT name FROM User")
	List<String> names();
	@Query("from User u WHERE u.name LIKE CONCAT(:name)")
    User findUserProfileByName(@Param("name") String name);
	

}
