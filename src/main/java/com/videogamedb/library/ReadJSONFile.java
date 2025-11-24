package com.videogamedb.library;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSONFile {
	public JSONObject jsonData;
	public String jsonFilepath;

	public JSONObject jsonFileReader(String jsonfile) throws FileNotFoundException, IOException, ParseException {
		// Define the path to the JSON file

		jsonFilepath = System.getProperty("user.dir") + File.separator + "src\\test\\resources\\" + jsonfile;

		// Load the JSON file into a File object
		File jsonFile = new File(jsonFilepath);

		JSONParser parse = new JSONParser();
		jsonData = (JSONObject) parse.parse(new FileReader(jsonFile));

		return jsonData;

	}
	
	//***********************************************************************************************************
	
	 
	    public Object[][] jsonData11() throws FileNotFoundException, IOException, ParseException {
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
	 }




//public void name() throws FileNotFoundException, IOException, ParseException {
//String jsonFilepath = System.getProperty("user.dir") + File.separator + "src\\test\\resources\\registerreqres.json";
//
//JsonReader reader = Json.createReader(new FileReader(jsonFilepath));
//
//// Step 3: Parse the JSON data into a suitable data structure
//JsonArray jsonArray = reader.readArray();
//
//// Step 4: Access each data entry
//for (int i = 0; i < jsonArray.size(); i++) {
// // Map<String, String> dataEntry = (Map<String,String>)jsonArray.getJsonObject(i);
// // Response response = help.regesterReqres(dataEntry);
// //   System.out.println(dataEntry.toString());
//	}
