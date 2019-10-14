package com.uds.rest.model;

import java.util.Date;

public class Sabor {

	private Integer id;
	private String sabor;
	private Integer tempoAdicional;
	private Date dataCadastramento;

	public Sabor(Integer id, String sabor, Integer tempoAdicional) {
		super();
		this.id = id;
		this.sabor = sabor;
		this.tempoAdicional = tempoAdicional;
		this.dataCadastramento = new Date();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public Integer getTempoAdicional() {
		return tempoAdicional;
	}

	public void setTempoAdicional(Integer tempoAdicional) {
		this.tempoAdicional = tempoAdicional;
	}

	public Date getDataCadastramento() {
		return dataCadastramento;
	}

	public void setDataCadastramento(Date dataCadastramento) {
		this.dataCadastramento = dataCadastramento;
	}

	@Override
	public String toString() {
		return "Sabor [id=" + id + ", sabor=" + sabor + ", tempoAdicional=" + tempoAdicional + ", dataCadastramento="
				+ dataCadastramento + "]";
	}

}
