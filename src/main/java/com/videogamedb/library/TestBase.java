package com.videogamedb.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	public String baseUri;
	public String basereqres;
	public RequestSpecification httpRequest;
	public String token;
	String username1 = "admin";
	String password1 = "admin";
	
	public void loadPropertyfile(String baseUrlKey) throws IOException {
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\videogamedb.properties");
		FileInputStream fis = new FileInputStream(file);
		Properties property = new Properties();
		property.load(fis);
		switch (baseUrlKey) {
		case "videoGame":
			this.baseUri = (String) property.get("baseURL");
			break;
		case "reqres":
			this.baseUri = (String) property.get("baseURL2");
			break;
		default:
			System.out.println("Choose correct key");
		}
		
		

		
	}

	public RequestSpecification setupRest(String baseUrlKey) throws IOException {
		
		loadPropertyfile(baseUrlKey);
		RestAssured.baseURI = this.baseUri;

		RequestSpecification request = RestAssured.given().log().all();
		request.header("content-type", "application/json");
		return request;
	}

	public RequestSpecification setupRest(String token, String baseUrlKey) throws IOException {
		loadPropertyfile(baseUrlKey);
		RequestSpecification request = RestAssured.given().log().all();
		request.header("content-type", "application/json");
		// request.header("Authorization", token);
		request.header("Authorization", "Bearer " + token);
		return request;
	}

	@SuppressWarnings("unchecked")
	public String generateToken(String baseUrlKey) throws IOException {
		RequestSpecification request = setupRest(baseUrlKey);
		JSONObject bodyParams = new JSONObject();
		bodyParams.put("password", password1);
		bodyParams.put("username", username1);

		request.body(bodyParams.toJSONString());
		Response response = request.post(this.baseUri + ResourceURI.GENERATE_TOKEN.getUri());
		JsonPath jsonPath = response.getBody().jsonPath();
		token = jsonPath.get("token");
		return token;
	}

}
