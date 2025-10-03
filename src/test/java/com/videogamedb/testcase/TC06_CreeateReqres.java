package com.videogamedb.testcase;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.videogamedb.library.ReadJSONFile;
import com.videogamedb.library.TestBase;
import com.videogamedb.pojo.Helper;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC06_CreeateReqres extends TestBase{
	RequestSpecification request;
	Helper help;
	@BeforeClass
	public void setup() throws IOException {
		request = setupRest("reqres");
		this.help = new Helper(request);
		
	}@Test
	public void testCreateReqres() throws Exception {
		ReadJSONFile rjf= new ReadJSONFile();
	Map<String, String>	jsonData=rjf.jsonFileReader("reqres.json");
	Response response = help.createReqres(jsonData);
	response.prettyPrint();
	}

}
