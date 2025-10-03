package com.videogamedb.pojo;

import java.util.Map;

public class CreateVideoGamePOJO {
	private String category;
	private String name;
	private String rating;
	private String releaseDate;
	private Integer reviewScore;

	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Integer getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(Integer reviewScore ) {
		this.reviewScore= reviewScore;
	}
	
	
	public CreateVideoGamePOJO videoGamePayload(Map<String, String> jsonData) {
		CreateVideoGamePOJO payLoad= new CreateVideoGamePOJO();
		
		payLoad.setCategory(jsonData.get("category"));
		payLoad.setName(jsonData.get("name"));
		payLoad.setRating(jsonData.get("rating"));
		payLoad.setReleaseDate(jsonData.get("releaseDate"));
		payLoad.setReviewScore(Integer.parseInt(String.valueOf(jsonData.get("reviewScore"))));
		return payLoad;
	}

}
