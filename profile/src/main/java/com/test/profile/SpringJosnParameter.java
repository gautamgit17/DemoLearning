package com.test.profile;

public class SpringJosnParameter {

	private String name;
	
	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	public int getId() {
		return id;
	}

	private String role;
	
	private int id;
	
	public SpringJosnParameter(String name, int id, String role) {
		this.id = id;
		this.name = name;
		this.role = role;
	}
}
