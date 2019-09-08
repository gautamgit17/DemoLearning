package com.profile;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class UserPrefList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonInclude
	private transient List<UserPref> prefrences;
	
	public List<UserPref> getPrefrences() {
		return prefrences;
	}
	public UserPrefList() {}
	@SuppressWarnings("unused")
	private UserPrefList(List<UserPref> prefrences) {
		this.prefrences = prefrences;
	}
	
	public static UserPrefList create(List<UserPref> prefrences) {
		return new UserPrefList(prefrences);
	}
}
