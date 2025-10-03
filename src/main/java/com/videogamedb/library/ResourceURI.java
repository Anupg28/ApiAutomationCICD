package com.videogamedb.library;

public enum ResourceURI {
	GET_REQRES_SINGLE_RESOURCE("/api/unknown/{id}"),
	DELAY_RESPONCE_REQRES("/api/users"),
	GET_REQRES_RESOURCE("/api/unknown"),
	LOGIN_REQRES("/api/login"),
	REGESTER_REQRES("/api/register"),
	CREATE_REQRES("/api/users"),
	GET_REQRES_LIST("/api/users"),
	UPDATE_A_VIDEO_GAME("/api/videogame/{id}"),
	GET_A_VIDEO_GAME("/api/videogame/{id}"),
	GET_VIDEO_GAME_LIST("/api/videogame"),
	GENERATE_TOKEN("/api/authenticate"),
	CREATE_VIDEO_GAME("/api/videogame"),
	DELETE_A_VIDEO_GAME("/api/videogame/{id}");
	
	String uri;

	ResourceURI(String uri) {
		this.uri = uri;
	}

	public String getUri() {
		return this.uri;
	}

}


