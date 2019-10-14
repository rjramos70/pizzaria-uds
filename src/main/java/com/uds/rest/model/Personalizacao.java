package com.uds.rest.model;

import java.util.Date;

public class Personalizacao {

	private Integer id;
	private String pesonalizacao;
	private double valorAdicional;
	private Date dataCadastramento;

	public Personalizacao(Integer id, String pesonalizacao, double valorAdicional) {
		this.id = id;
		this.pesonalizacao = pesonalizacao;
		this.valorAdicional = valorAdicional;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPesonalizacao() {
		return pesonalizacao;
	}

	public void setPesonalizacao(String pesonalizacao) {
		this.pesonalizacao = pesonalizacao;
	}

	public double getValorAdicional() {
		return valorAdicional;
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
		return "Personalizacao [id=" + id + ", pesonalizacao=" + pesonalizacao + ", valorAdicional=" + valorAdicional
				+ ", dataCadastramento=" + dataCadastramento + "]";
	}

}
