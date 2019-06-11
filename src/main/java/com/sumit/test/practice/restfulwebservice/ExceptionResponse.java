package com.sumit.test.practice.restfulwebservice;

import java.util.Date;

import org.springframework.web.context.request.WebRequest;

public class ExceptionResponse {
	private Date date;
	private String message;
	private String details;
	private WebRequest request;
	
	

	public ExceptionResponse(Date date, String message, String details,WebRequest request) {
		super();
		this.date = date;
		this.message = message;
		this.details = details;
	}

	public Date getDate() {
		return date;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
	
	public WebRequest getRequest() {
		return request;
	}
	
	

}
