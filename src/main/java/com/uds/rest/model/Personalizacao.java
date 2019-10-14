package com.uds.rest.model;

import java.util.Date;

public class Personalizacao {

	private Integer id;
	private String personalizacao;
	private double valorAdicional;
	private Integer tempoAdicional;
	private Date dataCadastramento;

	public Personalizacao(Integer id, String personalizacao, double valorAdicional, Integer tempoAdicional) {
		this.id = id;
		this.personalizacao = personalizacao;
		this.tempoAdicional = tempoAdicional;
		this.valorAdicional = valorAdicional;
		this.dataCadastramento = new Date();
	}

	public Personalizacao() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPersonalizacao() {
		return personalizacao;
	}

	public void setPersonalizacao(String personalizacao) {
		this.personalizacao = personalizacao;
	}

	public double getValorAdicional() {
		return valorAdicional;
	}

	public Integer getTempoAdicional() {
		return tempoAdicional;
	}

	public void setTempoAdicional(Integer tempoAdicional) {
		this.tempoAdicional = tempoAdicional;
	}

	public void setValorAdicional(double valorAdicional) {
		this.valorAdicional = valorAdicional;
	}

	public Date getDataCadastramento() {
		return dataCadastramento;
	}

	public void setDataCadastramento(Date dataCadastramento) {
		this.dataCadastramento = dataCadastramento;
	}

	@Override
	public String toString() {
		return "Personalizacao [id=" + id + ", personalizacao=" + personalizacao + ", valorAdicional=" + valorAdicional
				+ ", dataCadastramento=" + dataCadastramento + "]";
	}

}
