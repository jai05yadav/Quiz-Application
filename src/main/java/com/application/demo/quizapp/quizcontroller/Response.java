package com.application.demo.quizapp.quizcontroller;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class Response {
	private Integer id;
	private String Response;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getResponse() {
		return Response;
	}
	public void setResponse(String response) {
		Response = response;
	}
	
	
	
	
}
