package br.com.caritas.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.caritas.exceptions.ExseptionResponse;
import br.com.caritas.exceptions.ResourceNotFoundExeption;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHeandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExseptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
		ExseptionResponse exceptionResponse = new ExseptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ResourceNotFoundExeption.class)
	public final ResponseEntity<ExseptionResponse> handleNotFoundAllExceptions(Exception ex, WebRequest request) {
		ExseptionResponse exceptionResponse = new ExseptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
}
