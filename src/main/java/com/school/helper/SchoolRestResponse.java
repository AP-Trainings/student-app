package com.school.helper;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SchoolRestResponse<E> {
	
	private HttpStatus statusCode;
	private String responseMessage;
	private E responsePayload;
	
	public SchoolRestResponse() {
	}

	public SchoolRestResponse(HttpStatus statusCode, String responseMessage, E responsePayload) {
		this.statusCode = statusCode;
		this.responseMessage = responseMessage;
		this.responsePayload = responsePayload;
	}
	
}
