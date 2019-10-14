package com.uds.rest.model;

import java.util.Date;

public class Tamanho {

	private Integer id;
	private String tamanho;
	private double valor;
	private Integer tempoDePrepadro;
	private Date dataCadastramento;

	public Tamanho(Integer id, String tamanho, double valor, Integer tempoDePrepadro) {
		this.id = id;
		this.tamanho = tamanho;
		this.valor = valor;
		this.tempoDePrepadro = tempoDePrepadro;
		this.dataCadastramento = new Date();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Integer getTempoDePrepadro() {
		return tempoDePrepadro;
	}

	public void setTempoDePrepadro(Integer tempoDePrepadro) {
		this.tempoDePrepadro = tempoDePrepadro;
	}

	public Date getDataCadastramento() {
		return dataCadastramento;
	}

	public void setDataCadastramento(Date dataCadastramento) {
		this.dataCadastramento = dataCadastramento;
	}

	@Override
	public String toString() {
		return "Tamanho [id=" + id + ", tamanho=" + tamanho + ", valor=" + valor + ", tempoDePrepadro="
				+ tempoDePrepadro + ", dataCadastramento=" + dataCadastramento + "]";
	}

}
