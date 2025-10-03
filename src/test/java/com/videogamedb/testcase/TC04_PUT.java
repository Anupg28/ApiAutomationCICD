package com.videogamedb.testcase;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.videogamedb.library.ReadJSONFile;
import com.videogamedb.library.TestBase;
import com.videogamedb.pojo.Helper;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC04_PUT extends TestBase {
	RequestSpecification request;
	Helper help;

	@BeforeClass
	public void setup() throws IOException {
		request = setupRest(generateToken("videoGame"),"videoGame");
		this.help = new Helper(request);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void putRequest() throws Exception {
		ReadJSONFile rjf = new ReadJSONFile();
		Map<String, String> jsonData = rjf.jsonFileReader("payload.json");
		Response response = help.updateVideoGame(jsonData);

		Assert.assertEquals(response.getStatusCode(), 200);

		JsonPath jsonpath = response.getBody().jsonPath();
		Assert.assertEquals(jsonpath.get("name"), "Mario");
	}

}
