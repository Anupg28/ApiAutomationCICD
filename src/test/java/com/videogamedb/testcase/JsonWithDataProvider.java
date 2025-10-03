package com.videogamedb.testcase;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.videogamedb.library.ReadJSONFile;
import com.videogamedb.library.TestBase;
import com.videogamedb.pojo.Helper;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JsonWithDataProvider extends TestBase {

	RequestSpecification request;
	Helper help;

	@BeforeClass
	public void setup() throws IOException {
		request = setupRest("reqres");
		this.help = new Helper(request);
	}
	@DataProvider(name="jsonTestData")
	public Object[][] datajsonProvider() throws FileNotFoundException, IOException, ParseException {
		ReadJSONFile rjf= new ReadJSONFile();
		Object[][] 
				value = rjf.jsonData11();
		return value;
	}
	@Test (dataProvider ="jsonTestData" )
	public void postTestWithDataProvider(String passward , String email ) {
		Response response = help.loginReqres111(email,passward);
		response.prettyPrint();
		
	}
	
}
