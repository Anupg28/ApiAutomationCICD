package com.videogamedb.testcase;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.videogamedb.library.ReadJSONFile;
import com.videogamedb.library.TestBase;
import com.videogamedb.pojo.Helper;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC02_POST extends TestBase {

	RequestSpecification request;
	Helper help;

	@BeforeClass
	public void setup() throws IOException {
		request = setupRest(generateToken("videoGame"), "videoGame");
		this.help = new Helper(request);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void postRequest() throws Exception {
		ReadJSONFile rjf = new ReadJSONFile();

		Map<String, String> jsonData = rjf.jsonFileReader("payload.json");

		Response response = help.createVideoGame(jsonData);
		response.prettyPrint();
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

		JsonPath jsonpath = response.getBody().jsonPath();
		int id = jsonpath.get("id");
		Assert.assertEquals(id, 0);

		
		// To get the key of an objet from body
		
		List<Object> keys = response.jsonPath().getMap("").keySet().stream().collect(Collectors.toList());
		System.out.println(keys.get(0));
		System.out.println("**********************************");
		for (Object key : keys) {
			System.out.println(key);
		}
	}
}
