package com.school.helper;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class SchoolRestResponse<E> {
	
	private Integer statusCode;
	private String responseMessage;
	private List<E> responsePayload;
	
	public SchoolRestResponse() {
	}

	public SchoolRestResponse(Integer statusCode, String responseMessage, List<E> responsePayload) {
		this.statusCode = statusCode;
		this.responseMessage = responseMessage;
		this.responsePayload = responsePayload;
	}
	
}
