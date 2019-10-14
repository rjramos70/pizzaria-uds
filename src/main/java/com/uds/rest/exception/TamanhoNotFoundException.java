package com.uds.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TamanhoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public TamanhoNotFoundException(String mensagem) {
		super(mensagem);
	}


}