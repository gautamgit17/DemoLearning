package com.profile;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class UserPref implements Serializable {
	
	@JsonInclude
	private String prefrenceName;
	
	public String getPrefrenceName() {
		return prefrenceName;
	}

	public UserPref() {}
	
	private UserPref(String prefrenceName) {
		this.prefrenceName = prefrenceName;
	}
		
	public static UserPref create(String prefrenceName) {
		return new UserPref(prefrenceName);
	}
	}


