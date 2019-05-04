package com.assignment.exception;

import java.io.IOException;
import java.time.LocalTime;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.assignment.constants.MessageConstants;
import com.assignment.models.ExceptionDetails;

@RestControllerAdvice
class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(MemberNotFoundException.class)
	public ResponseEntity<ExceptionDetails> handleMemberNotFound(MemberNotFoundException ex, WebRequest request) {
		ExceptionDetails exception = new ExceptionDetails(ex.getMessage(), HttpStatus.NOT_FOUND.value(), MessageConstants.LINK_TO_DOCS, request.getContextPath(),LocalTime.now());
		return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
	}
	
	@Override
	public ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionDetails exception = new ExceptionDetails(ex.getMessage(), HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), MessageConstants.LINK_TO_DOCS, request.getContextPath(),LocalTime.now());
		return response(ex, headers, request, HttpStatus.UNSUPPORTED_MEDIA_TYPE, exception);
	}

	@Override
	public ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ExceptionDetails exception = new ExceptionDetails(ex.getMessage(), HttpStatus.NOT_FOUND.value(), MessageConstants.LINK_TO_DOCS, request.getContextPath(),LocalTime.now());
		return response(ex, headers, request, HttpStatus.NOT_FOUND, exception);
	}
		
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ExceptionDetails> handleUnAuthorised(AccessDeniedException ex, WebRequest request) {
		ExceptionDetails exception = new ExceptionDetails(ex.getMessage(), HttpStatus.UNAUTHORIZED.value(), MessageConstants.LINK_TO_DOCS, request.getContextPath(),LocalTime.now());
		return new ResponseEntity<>(exception, HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
    public void constraintViolationException(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }

	@Override
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String errorMessage = ex.getBindingResult().getFieldErrors().stream()
				.map(DefaultMessageSourceResolvable::getDefaultMessage).findFirst().orElse(ex.getMessage());
		ExceptionDetails exception = new ExceptionDetails(errorMessage, HttpStatus.BAD_REQUEST.value(), MessageConstants.LINK_TO_DOCS, request.getContextPath(),LocalTime.now());
		return response(ex, headers, request, HttpStatus.BAD_REQUEST, exception);
	}

	

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionDetails> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionDetails error = new ExceptionDetails("Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageConstants.LINK_TO_DOCS, request.getContextPath(),LocalTime.now());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private ResponseEntity<Object> response(Exception ex, HttpHeaders headers, WebRequest request, HttpStatus status,
			ExceptionDetails exceptionDetails) {
		return handleExceptionInternal(ex, exceptionDetails, headers, status, request);
	}

}
