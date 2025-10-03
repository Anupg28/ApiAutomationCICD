package com.videogamedb.testcase;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.videogamedb.library.ReadJSONFile;
import com.videogamedb.library.TestBase;
import com.videogamedb.pojo.Helper;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC08_POSTRegister extends TestBase {
	RequestSpecification request;
	Helper help;

	@BeforeClass
	public void setup() throws IOException {
		request = setupRest("reqres");
		this.help = new Helper(request);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testRegesterReqres() throws Exception {
		ReadJSONFile rjf = new ReadJSONFile();
		JSONObject jsonData = rjf.jsonFileReader("registerreqres.json");
		 JSONArray credentials = (JSONArray)jsonData.get("credentials");
		for (int i = 0; i < credentials.size(); i++) {
		        Map<String, String> dataEntry = (Map<String, String>) credentials.get(i);
		
		Response response = help.regesterReqres(dataEntry);
		System.out.println("********************");
		response.prettyPrint();
		
	//To get the key of an objet from body
		List<Object> keys = response.jsonPath().getMap("").keySet().stream().collect(Collectors.toList());
		System.out.println(keys.get(0));
		for (Object key : keys) {
			System.out.println(key);
		}
		}	
		}
	}
		






