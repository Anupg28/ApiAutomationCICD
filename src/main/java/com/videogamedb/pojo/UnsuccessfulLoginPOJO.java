package com.videogamedb.pojo;

import java.util.Map;

public class UnsuccessfulLoginPOJO {
	private String email;

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public UnsuccessfulLoginPOJO loginReqresPayload(Map<String, String> jsonData) {
		UnsuccessfulLoginPOJO unlog= new UnsuccessfulLoginPOJO();
		unlog.setEmail(jsonData.get("email"));
		return unlog;
	}

}
