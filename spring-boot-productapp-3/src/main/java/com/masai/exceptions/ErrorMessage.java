package com.masai.exceptions;

import java.time.LocalDateTime;

public class ErrorMessage {

	private LocalDateTime timeStamp;
	private String message;
	private String error;
	
	public ErrorMessage() {
		// TODO Auto-generated constructor stub
	}

	public ErrorMessage(LocalDateTime timeStamp, String message, String error) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.error = error;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
