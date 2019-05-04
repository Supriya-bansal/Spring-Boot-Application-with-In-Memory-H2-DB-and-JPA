package com.assignment.models;

import java.time.LocalTime;

import org.springframework.stereotype.Component;

@Component
public class ExceptionDetails {
	
	private LocalTime timeStamp;
    private int errorCode;
    private String errorMessage;
    private String docs;
    private String baseUrl;
    
	public ExceptionDetails() {
		
	}
	public ExceptionDetails( String errorMessage,int errorCode, String docs, String url,LocalTime timeStamp) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.docs = docs;
		this.baseUrl=url;
		this.timeStamp= timeStamp;
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
	
	public String getBaseUrl() {
		return baseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	public LocalTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalTime timeStamp) {
		this.timeStamp = timeStamp;
	}
    
    
	
}
