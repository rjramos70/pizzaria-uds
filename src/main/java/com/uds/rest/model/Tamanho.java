package com.uds.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tamanho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private String tamanho;
	@Column
	private double valor;
	@Column
	private Integer tempoDePrepadro;
	
	public Tamanho() {	}
	
	public Tamanho(Integer id, String tamanho, double valor, Integer tempoDePrepadro) {
		this.id = id;
		this.tamanho = tamanho;
		this.valor = valor;
		this.tempoDePrepadro = tempoDePrepadro;
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

	@Override
	public String toString() {
		return "Tamanho [id=" + id + ", tamanho=" + tamanho + ", valor=" + valor + ", tempoDePrepadro="
				+ tempoDePrepadro + "]";
	}
	
	

}
