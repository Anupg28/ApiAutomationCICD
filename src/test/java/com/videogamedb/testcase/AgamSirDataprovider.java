package com.videogamedb.testcase;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.videogamedb.library.TestBase;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Dataprovider extends TestBase {

    @DataProvider(name = "test")
    public Object[][] readJson() throws IOException {
        // Define the file path to the JSON file
        File file = new File("D:\\eclipse-workspace\\VideoGamedb\\src\\test\\resources\\registerreqres.json");

        // Create an ObjectMapper to read the JSON
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read the root node of the JSON
            JsonNode rootNode = objectMapper.readTree(file);

            // Get the "credentials" node from the root node
            JsonNode credentialsNode = rootNode.get("credentials");

            // Create a 2D array to hold the data we're going to read
            Object[][] data = new Object[credentialsNode.size()][];

            // Iterate over each node within the "credentials" node
            for (int i = 0; i < credentialsNode.size(); i++) {
                // Get the current node
                JsonNode currentNode = credentialsNode.get(i);

                // Create a list to hold the data for this row
                List<String> row = new ArrayList<>();

                // Iterate over each field in the current node, adding its value to the row list
                currentNode.fields().forEachRemaining(field -> row.add(field.getValue().asText()));

                // Convert the row list to an array and add it to the data array
                data[i] = row.toArray();
            }

            // Return the data array
            return data;
        } catch (IOException e) {
            // If an error occurs, print the stack trace and rethrow the exception
            e.printStackTrace();
            throw e;
        }
    }	
    @Test(dataProvider = "test")
    public void testGenericJson(String email, String password) {
    	  RestAssured.baseURI="https://reqres.in";
	        RequestSpecification request = RestAssured.given().log().all();
	        JSONObject job= new JSONObject();
	        job.put("email", email);
	        job.put("password", password);
	        request.body(job.toJSONString());
	       Response response = request.post("/api/login");
	      System.out.println("*****************************");
	       response.prettyPrint();

        System.out.println(email	 + "," + password);
    }
}

//<dependency>
//<groupId>com.fasterxml.jackson.core</groupId>
//<artifactId>jackson-databind</artifactId>
//<version>2.13.0</version>
//</dependency>
//<dependency>
//<groupId>com.fasterxml.jackson.core</groupId>
//<artifactId>jackson-core</artifactId>
//<version>2.13.0</version>
//</dependency>
//<dependency>
//<groupId>com.fasterxml.jackson.core</groupId>
//<artifactId>jackson-annotations</artifactId>
//<version>2.13.0</version>
//</dependency>

