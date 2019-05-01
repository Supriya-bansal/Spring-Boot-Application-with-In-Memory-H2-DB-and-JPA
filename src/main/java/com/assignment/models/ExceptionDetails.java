package com.assignment.models;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class ExceptionDetails {
	
	private LocalDateTime timeStamp;
    private int errorCode;
    private String errorMessage;
    private String docs;
    private String url;
    
	public ExceptionDetails() {
		
	}
	public ExceptionDetails( String errorMessage,int errorCode, String docs, String url) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.docs = docs;
		this.timeStamp= LocalDateTime.now();
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getDocs() {
		return docs;
	}
	public void setDocs(String docs) {
		this.docs = docs;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
    
    
	
}
