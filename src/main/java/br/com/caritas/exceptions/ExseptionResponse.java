package br.com.caritas.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExseptionResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date timestaamp;
	private String message;
	private String details;

	public Date getTimestaamp() {
		return timestaamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

	public ExseptionResponse(Date timestamp, String message, String details) {
		this.timestaamp = timestamp;
		this.message = message;
		this.details = details;
	}

}
