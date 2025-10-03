package com.videogamedb.testcase;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.videogamedb.library.ReadJSONFile;
import com.videogamedb.library.TestBase;
import com.videogamedb.pojo.Helper;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC09_POSTLoginReqres extends TestBase {
	RequestSpecification request;
	Helper help;
@BeforeClass
	public void setup() throws IOException {
		request = setupRest("reqres");
		this.help = new Helper(request);
	}
	
	@Test
	public void testLoginReqres() throws FileNotFoundException, IOException, ParseException {
		ReadJSONFile rjf= new ReadJSONFile();
		Map<String, String> jsonData = rjf.jsonFileReader("loginreqres.json");
		Response response = help.loginReqres(jsonData);
		response.prettyPrint();
		
	}
}
