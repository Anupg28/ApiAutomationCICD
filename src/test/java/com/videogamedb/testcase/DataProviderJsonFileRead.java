package com.videogamedb.testcase;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class DataProviderJsonFileRead {
	 @DataProvider(name="jsonFile")
	    public Object[][] jsonData() throws FileNotFoundException, IOException, ParseException {
		String jsonFilepath = System.getProperty("user.dir") + File.separator + "src\\test\\resources\\registerreqres.json";
	        File file =new File(jsonFilepath);
	        JSONParser parser=new JSONParser();
	        JSONObject data=(JSONObject) parser.parse(new FileReader(file));
	        JSONArray data1=(JSONArray)data.get("credentials");
	 
	        Object[][]  value = new Object[data1.size()][];
	        for (int i = 0; i < data1.size(); i++) {
			JSONObject	jsonObj=(JSONObject) data1.get(i);
			
			Object[] entry = jsonObj.values().toArray();
			value[i]=entry;
			}
	        return value;
	        	     
	    }
	    @SuppressWarnings({ "unused" })
	    
	    @Test(dataProvider = "jsonFile")
	    public void response(String email,String password ) {
	        RestAssured.baseURI="https://reqres.in";
	        RequestSpecification request = RestAssured.given().log().all();
	        JSONObject job= new JSONObject();
	        job.put("email", email);
	        job.put("password", password);
	        request.body(job.toJSONString());
	       Response response = request.post("/api/login");
	      System.out.println("*****************************");
	       response.prettyPrint();
	    }

	}


