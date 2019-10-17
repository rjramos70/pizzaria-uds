package com.uds.rest.exception;

import java.util.Date;

public class ExceptionResponse {

	private Date timeStamp;
	private String mensagem;
	private String detalhes;

	public ExceptionResponse(Date timeStamp, String mensagem, String detalhes) {
		this.timeStamp = timeStamp;
		this.mensagem = mensagem;
		this.detalhes = detalhes;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

	@Override
	public String toString() {
		return "ExceptionResponse [timeStamp=" + timeStamp + ", mensagem=" + mensagem + ", detalhes=" + detalhes + "]";
	}

}
