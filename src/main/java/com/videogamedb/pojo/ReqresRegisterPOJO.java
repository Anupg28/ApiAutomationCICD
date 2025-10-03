package com.videogamedb.pojo;

import java.util.Map;

public class ReqresRegisterPOJO {
	private String email;
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
	public ReqresRegisterPOJO regesterreqres(Map<String,String> jsonData) {
		ReqresRegisterPOJO rrp= new ReqresRegisterPOJO();
		
		rrp.setEmail(jsonData.get("email"));
		rrp.setPassword(jsonData.get("password"));
		return rrp;
	}
	public ReqresRegisterPOJO regesterreqres111(String email, String passward) {
		ReqresRegisterPOJO rrp= new ReqresRegisterPOJO();
		
		rrp.setEmail(email);
		rrp.setPassword(passward);
		return rrp;
	}
}

