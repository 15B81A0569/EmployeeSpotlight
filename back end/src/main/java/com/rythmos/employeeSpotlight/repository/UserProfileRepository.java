package com.rythmos.employeeSpotlight.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rythmos.employeeSpotlight.entity.UserProfile;
@Repository
@Transactional
public interface UserProfileRepository extends CrudRepository<UserProfile,Long>{


	@Query("from UserProfile where empid=:empid")
    UserProfile findUserProfileByEmpId(@Param("empid") String empid);
	
	/*@Modifying
	@Query("UPDATE UserProfile up SET up.highest_education = :highestEducation WHERE up.empid = :empid") 
	UserProfile updateHighestEducation(@Param("empid") String empid, @Param("highestEducation") String highestEducation);
	*/
	
}
