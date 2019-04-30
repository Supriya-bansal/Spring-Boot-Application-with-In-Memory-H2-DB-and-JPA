package com.assignment.models;

import org.springframework.stereotype.Component;

@Component
public class ExceptionDetails {
	
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
    
    
	
}
