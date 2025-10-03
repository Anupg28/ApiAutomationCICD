package com.videogamedb.testcase;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.videogamedb.library.ResourceURI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class sample {
	@Test
	public void post() throws InterruptedException {
		RestAssured.baseURI = "https://www.videogamedb.uk:443";
		RequestSpecification request= RestAssured.given().log().all();
		request.header("content-type", "application/json");
		JSONObject bodyParams = new JSONObject();
		bodyParams.put("password", "admin");
		bodyParams.put("username", "admin");

		request.body(bodyParams.toJSONString());
		Response response1 = request.post("/api/authenticate");
		JsonPath jsonPath = response1.getBody().jsonPath();
		String token = jsonPath.get("token");
		System.out.println("token is"+token);
		Thread.sleep(1000);
		
		//request.header("content-type", "application/json");
		request.header("Authorization", "Bearer " + token);
		JSONObject bodyParams1 = new JSONObject();
		bodyParams1.put("category", "Platform");
		bodyParams1.put("name", "Mario");
		bodyParams1.put("rating", "Mature");
		bodyParams1.put("releaseDate", "2012-05-04");
		bodyParams1.put("reviewScore",85 );
	
		request.body(bodyParams1.toJSONString());
		
		Response response2 = request.post("/api/videogame");
System.out.println("***************************************");
		response2.prettyPrint();
		
	}

}
