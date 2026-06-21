package com.videogamedb.library;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataProviderReader {
	 public Object[][] readJson(String jsonFilePath) throws IOException {
	        // Define the file path to the JSON file
	        File file = new File(jsonFilePath);

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

}
