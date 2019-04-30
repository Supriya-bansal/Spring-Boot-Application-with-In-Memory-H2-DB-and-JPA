package com.assignment.exception;

public class MemberNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 5343004683871373705L;

	public MemberNotFoundException(String message) {
		super(message);
	}
}
