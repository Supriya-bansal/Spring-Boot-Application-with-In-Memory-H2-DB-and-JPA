package com.assignment.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException.Forbidden;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.assignment.constants.MessageConstants;
import com.assignment.models.ExceptionDetails;

@ControllerAdvice
class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(MemberNotFoundException.class)
	public ResponseEntity<ExceptionDetails> handleMemberNotFound(MemberNotFoundException ex, WebRequest request) {
		ExceptionDetails exception = new ExceptionDetails(ex.getMessage(), 404, MessageConstants.LINK_TO_DOCS, request.getContextPath());
		return new ResponseEntity<ExceptionDetails>(exception, HttpStatus.NOT_FOUND);
	}
		
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ResponseEntity<ExceptionDetails> handleUnAuthorised(Forbidden ex, WebRequest request) {
		ExceptionDetails exception = new ExceptionDetails(ex.getMessage(), 403, MessageConstants.LINK_TO_DOCS, request.getContextPath());
		return new ResponseEntity<ExceptionDetails>(exception, HttpStatus.FORBIDDEN);
	}

	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String errorMessage = ex.getBindingResult().getFieldErrors().stream()
				.map(DefaultMessageSourceResolvable::getDefaultMessage).findFirst().orElse(ex.getMessage());
		return response(ex, headers, request, HttpStatus.BAD_REQUEST, errorMessage);
	}

	@Override
	public ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return response(ex, headers, request, HttpStatus.UNSUPPORTED_MEDIA_TYPE, MessageConstants.MEDIA_TYPE_NOT_SUPPORTED_EXCEPTION);
	}

	@Override
	public ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		return response(ex, headers, request, HttpStatus.NOT_FOUND, MessageConstants.NO_METHOD_HANDLER_EXCEPTION);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionDetails> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionDetails error = new ExceptionDetails("Server Error", 500, MessageConstants.LINK_TO_DOCS, request.getContextPath());
		return new ResponseEntity<ExceptionDetails>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private ResponseEntity<Object> response(Exception ex, HttpHeaders headers, WebRequest request, HttpStatus status,
			String message) {
		return handleExceptionInternal(ex, message, headers, status, request);
	}

}
