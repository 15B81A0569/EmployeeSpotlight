package com.rythmos.employeeSpotlight.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.UniqueConstraint;

@Entity
@Table(name="login", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "empid"})})

public class Login {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	
	@Column(unique = true)
	private String empid;
	
	@Column
	private String password;
	
	@Column
	private String loginTime;
	
	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		
		
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", empid=" + empid + ", password=" + password + ", loginTime=" + loginTime + "]";
	}

	
	

}
