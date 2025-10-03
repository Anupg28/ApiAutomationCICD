package com.videogamedb.testcase;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.videogamedb.library.TestBase;
import com.videogamedb.pojo.Helper;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC11_GETDelayResponse extends TestBase {
	RequestSpecification request;
	Helper help;
	@BeforeClass
	public void setup() throws IOException {
		request = setupRest("reqres");
		this.help = new Helper(request);
		
	}
	@Test
	public void testDelayResponse() {
		Response response = help.delayedResponse();
		response.prettyPrint();
		
	}
}
