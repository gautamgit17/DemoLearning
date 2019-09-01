package com.test.profile;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class SpringJsonReturn {
	
	@Value("${spring.application.name:SpringTesT}")
	private String name;
	
	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public String getRole() {
		return role;
	}
	@Value("${spring.id}")
	private int id;
	
	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	@Value("${spring.role}")
	private String role;
	
	public SpringJsonReturn() {
	System.out.print("Values" + name);
	}
	
	@PostConstruct
	public void print() {
		System.out.print("Values" + name);
	}
	

}
