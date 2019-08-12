package com.rythmos.employeeSpotlight.request;

import java.util.List;

public class UpdateProfileJSONRequest {
	
	

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
	public List<String> getSkill() {
		return skill;
	}
	public void setSkill(List<String> skill) {
		this.skill = skill;
	}
	public List<String> getCertification() {
		return certification;
	}
	public void setCertification(List<String> certification) {
		this.certification = certification;
	}
	
	
	@Override
	public String toString() {
		return "UpdateProfileJSONRequest [ highestEducation=" + highestEducation + ", interest="
				+ interest + ", workExperience=" + workExperience + ", skill=" + skill + ", certification="
				+ certification + "]";
	}
	
	

}
