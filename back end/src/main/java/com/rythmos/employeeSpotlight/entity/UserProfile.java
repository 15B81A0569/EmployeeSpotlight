package com.rythmos.employeeSpotlight.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="userprofile", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "empid"})})

public class UserProfile {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column
	private String empid;
	
	@ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    @Embedded
    public List<String> skill;
	
	
	
	@ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    @Embedded
    public List<String> certification;
	

	@Column
	public String interest ;


	

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

	@Column
	private String highestEducation;
	

	@Column
	private String workExperience;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

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

	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", empid=" + empid + ", skill=" + skill + ", certification=" + certification
				+ ", interest=" + interest + ", highestEducation=" + highestEducation + ", workExperience="
				+ workExperience + "]";
	}

	
	
	

}
