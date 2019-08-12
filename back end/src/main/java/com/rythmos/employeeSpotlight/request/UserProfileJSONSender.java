package com.rythmos.employeeSpotlight.request;

import java.util.List;

public class UserProfileJSONSender {
	
	private String name;
	private String email;
	private String highestEducation;
	private String interest;
	private String workExperience;
	private List<String> skill;
	private List<String> certification;
	
	public String getHighestEducation() {
		return highestEducation;
	}
	public void setHighestEducation(String highestEducation) {
		this.highestEducation = highestEducation;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getWorkExperience() {
		return workExperience;
	}
	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<String> getCertification() {
		return certification;
	}
	public void setCertification(List<String> certification) {
		this.certification = certification;
	}

	@Override
	public String toString() {
		return "UserProfileJSONSender [name=" + name + ", email=" + email + ", highestEducation=" + highestEducation
				+ ", interest=" + interest + ", workExperience=" + workExperience + ", skill=" + skill
				+ ", certification=" + certification + "]";
	}
	public List<String> getSkill() {
		return skill;
	}
	public void setSkill(List<String> skill) {
		this.skill = skill;
	}
	

}
