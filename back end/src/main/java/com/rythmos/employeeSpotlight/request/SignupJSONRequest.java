package com.rythmos.employeeSpotlight.request;

public class SignupJSONRequest {

	private String empid;
	private String dateOfJoining;

	private String password;

	private String name;

	private String email;

	public String getEmpid() {
		return empid;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
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

	@Override
	public String toString() {
		return "SignupJSONRequest [dateOfJoining=" + dateOfJoining + ", password=" + password + ", name=" + name
				+ ", email=" + email + "]";
	}

}
