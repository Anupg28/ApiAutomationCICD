package com.videogamedb.pojo;

import java.io.IOException;
import java.util.Map;

import com.google.gson.Gson;
import com.videogamedb.library.ResourceURI;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Helper {

	RequestSpecification request;
	Gson gson = new Gson();

	public Helper(RequestSpecification request) {
		this.request = request;
	}

	public Response createVideoGame(Map<String, String> jsonData) throws IOException {
		CreateVideoGamePOJO createGame = new CreateVideoGamePOJO();
		String payload = gson.toJson(createGame.videoGamePayload(jsonData));
		request.body(payload);
		Response response = request.post(ResourceURI.CREATE_VIDEO_GAME.getUri());
		return response;
	}

	public Response listOfVideoGames() {
		Response response = request.get(ResourceURI.GET_VIDEO_GAME_LIST.getUri());
		return response;
	}

	public Response singleVideoGame() {
		request.pathParam("id", "2");
		Response response = request.get(ResourceURI.GET_A_VIDEO_GAME.getUri());
		return response;

	}

	public Response updateVideoGame(Map<String, String> jsonData) throws IOException {
		CreateVideoGamePOJO updateGame = new CreateVideoGamePOJO();
		String payload = gson.toJson(updateGame.videoGamePayload(jsonData));
		request.body(payload);
		request.pathParam("id", "1");
		Response response = request.post(ResourceURI.UPDATE_A_VIDEO_GAME.getUri());
		return response;
	}

	public Response deleteaVideoGame() {
		request.pathParam("id", "1");
		Response response = request.delete(ResourceURI.DELETE_A_VIDEO_GAME.getUri());
		return response;
	}

	public Response createReqres(Map<String, String> jsonData) {
		CreateReqresPOJO createreq = new CreateReqresPOJO();
		String reqresPayload = gson.toJson(createreq.reqresPayload(jsonData));
		request.body(reqresPayload);
		Response response = request.post(ResourceURI.CREATE_REQRES.getUri());
		return response;

	}

	public Response getListreqres() {
		request.queryParam("page", 2);
		Response response = request.get(ResourceURI.GET_REQRES_LIST.getUri());
		return response;
	}

	public Response regesterReqres(Map<String, String> jsonData) {
		ReqresRegisterPOJO rrp = new ReqresRegisterPOJO();
		String payLoad = gson.toJson(rrp.regesterreqres(jsonData));
		request.body(payLoad);
		Response response = request.post(ResourceURI.REGESTER_REQRES.getUri());
		return response;
	}

	public Response loginReqres(Map<String, String> jsonData) {
		ReqresRegisterPOJO rrp = new ReqresRegisterPOJO();
		String payLoad = gson.toJson(rrp.regesterreqres(jsonData));
		request.body(payLoad);
		Response response = request.post(ResourceURI.LOGIN_REQRES.getUri());
		return response;
	}

	public Response unsuccessfulLoginReqres(Map<String, String> jsonData) {
		UnsuccessfulLoginPOJO unlog = new UnsuccessfulLoginPOJO();
		String payLoad = gson.toJson(unlog.loginReqresPayload(jsonData));
		request.body(payLoad);
		Response response = request.post(ResourceURI.LOGIN_REQRES.getUri());
		return response;
	}
	public Response delayedResponse() {
		request.queryParam("delay", 3);
		Response response = request.get(ResourceURI.GET_REQRES_LIST.getUri());
		return response;
	}
	public Response unsuccessfulregesterReqres(Map<String, String> jsonData) {
		UnsuccessfulLoginPOJO unlog= new UnsuccessfulLoginPOJO();
		String payLoad = gson.toJson(unlog.loginReqresPayload(jsonData));
		request.body(payLoad);
		Response response = request.post(ResourceURI.REGESTER_REQRES.getUri());
		return response;
	}
	public Response resourceList() {
		Response response = request.get(ResourceURI.GET_REQRES_RESOURCE.getUri());
		return response;
	}

	public Response singleresource() {
		request.pathParam("id", 2);
		Response response = request.get(ResourceURI.GET_REQRES_SINGLE_RESOURCE.getUri());
		return response;
	}
	public Response singleResourceNotFound() {
		request.pathParam("id", 23);
		Response response = request.get(ResourceURI.GET_REQRES_SINGLE_RESOURCE.getUri());
		return response;
	}
	public Response loginReqres111(String email, String passward) {
		ReqresRegisterPOJO rrp = new ReqresRegisterPOJO();
		String payLoad = gson.toJson(rrp.regesterreqres111(email,passward));
		request.body(payLoad);
		Response response = request.post(ResourceURI.LOGIN_REQRES.getUri());
		return response;
	}

}
