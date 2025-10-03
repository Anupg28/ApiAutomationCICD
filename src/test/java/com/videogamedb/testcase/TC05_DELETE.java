package com.videogamedb.testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.videogamedb.library.TestBase;
import com.videogamedb.pojo.Helper;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC05_DELETE extends TestBase {
	RequestSpecification request;
	Helper help;

	@BeforeClass
	public void setup() throws IOException {
		request = setupRest("videoGame");
		this.help = new Helper(request);
	}

	@Test
	public void testDeleteVideoGame() {
		Response response = help.listOfVideoGames();
		String body = response.getBody().asString();
		Assert.assertEquals(body, "Video game deleted	");
		Assert.assertEquals(response.getStatusCode(), 200);

	}

}
