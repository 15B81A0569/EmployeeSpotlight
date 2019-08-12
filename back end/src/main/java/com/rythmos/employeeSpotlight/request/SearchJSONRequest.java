package com.rythmos.employeeSpotlight.request;

public class SearchJSONRequest {
	private String userid;
	private String name;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "SearchJSONRequest [userid=" + userid + ", name=" + name + "]";
	}
	

}
