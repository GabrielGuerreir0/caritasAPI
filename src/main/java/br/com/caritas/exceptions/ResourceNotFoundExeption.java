package br.com.caritas.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundExeption extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundExeption(String ex) {
		super(ex);
	}
	
	
	
}
