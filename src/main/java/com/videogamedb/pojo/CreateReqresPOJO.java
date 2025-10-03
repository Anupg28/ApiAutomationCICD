package com.videogamedb.pojo;

import java.util.Map;

public class CreateReqresPOJO {
	private String name;
	private String job;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
public CreateReqresPOJO reqresPayload(Map <String,String> jsonData) {
	CreateReqresPOJO reqres=new CreateReqresPOJO();
	reqres.setName(jsonData.get("name"));
	reqres.setJob(jsonData.get("job"));
	
	return reqres;
}
}
