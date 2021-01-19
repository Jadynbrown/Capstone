package com.capstone.webapplication.exception;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorDetails {
	
	private HttpStatus status;
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	private String message;
	private String localizedMessage; 
	
	private ErrorDetails() {
		this.timestamp = LocalDateTime.now(); 
	}
	
	ErrorDetails(HttpStatus status){
		this.status = status; 
	}
	
	public ErrorDetails(HttpStatus status, Throwable exception) {
		this.status = status;
		this.message = "An unexpected error has occured";
		this.localizedMessage = exception.getLocalizedMessage();  
	}
	
	public ErrorDetails(String message, HttpStatus status, Throwable exception) {
		this.status = status;
		this.message = exception.getMessage();
		this.localizedMessage = exception.getLocalizedMessage();  
	}
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getLocalizedMessage() {
		return localizedMessage;
	}

	public void setLocalizedMessage(String localizedMessage) {
		this.localizedMessage = localizedMessage;
	}
	

	
	
}
