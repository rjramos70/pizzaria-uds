package com.uds.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonalizacaoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public PersonalizacaoNotFoundException(String mensagem) {
		super(mensagem);
	}


}
