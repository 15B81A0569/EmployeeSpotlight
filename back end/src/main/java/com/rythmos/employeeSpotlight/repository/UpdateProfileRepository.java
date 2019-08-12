package com.rythmos.employeeSpotlight.repository;

import org.springframework.data.repository.CrudRepository;

import com.rythmos.employeeSpotlight.entity.UserProfile;

public interface UpdateProfileRepository extends CrudRepository<UserProfile,Long> {
	

}
