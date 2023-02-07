package com.app.dto;

import java.time.LocalDateTime;

public class ApiResponse {
	private LocalDateTime timestamp;
	private String message;
	public ApiResponse(String message) {
		super();
		this.timestamp = LocalDateTime.now();
		this.message = message;
	}
	
	


}
