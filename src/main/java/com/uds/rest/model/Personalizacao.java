package com.uds.rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Personalizacao {

	@Id
	@GeneratedValue
	private Integer id;

	private String descricao;

	private double valorAdicional;

	private Integer tempoAdicional;

	public Personalizacao() {
	}

	public Personalizacao(Integer id, String descricao, double valorAdicional, Integer tempoAdicional) {
		this.id = id;
		this.descricao = descricao;
		this.valorAdicional = valorAdicional;
		this.tempoAdicional = tempoAdicional;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValorAdicional() {
		return valorAdicional;
	}

	public void setValorAdicional(double valorAdicional) {
		this.valorAdicional = valorAdicional;
	}

	public Integer getTempoAdicional() {
		return tempoAdicional;
	}

	public void setTempoAdicional(Integer tempoAdicional) {
		this.tempoAdicional = tempoAdicional;
	}

	@Override
	public String toString() {
		return "Personalizacao [id=" + id + ", descricao=" + descricao + ", valorAdicional=" + valorAdicional
				+ ", tempoAdicional=" + tempoAdicional + "]";
	}

}
