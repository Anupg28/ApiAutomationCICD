package com.videogamedb.testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.videogamedb.library.TestBase;
import com.videogamedb.pojo.Helper;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC01_GETVideoGameLIst extends TestBase {
	RequestSpecification request;
	Helper help;

	@BeforeClass
	public void setup() throws IOException {
		request = setupRest("videoGame");
		this.help = new Helper(request);
	}

	@Test
	public void getVideoGameList() {
		Response response = help.listOfVideoGames();
		response.prettyPrint();
		
		String header = response.getHeader("Content-Type");
		Assert.assertEquals(header, "application/json");
		
		JsonPath jsonpath = response.getBody().jsonPath();
		String gamename = jsonpath.get("[1].name");
		Assert.assertEquals(gamename, "Gran Turismo 3");

	}

}
