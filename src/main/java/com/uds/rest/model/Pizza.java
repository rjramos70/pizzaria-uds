package com.uds.rest.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pizza {

	private Integer id;
	private String tamanho;
	private String sabor;
	private List<Personalizacao> personalizacoes;
	private double precoOriginal;
	private Integer tempoOriginal;
	private double precoTotal;
	private Integer tempoDePreparo;
	private Date dataCadastramento;

	public Pizza(Integer id, String tamanho, String sabor) {
		super();
		this.id = id;
		this.tamanho = tamanho;
		this.sabor = sabor;
		this.personalizacoes = new ArrayList<>();
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

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public List<Personalizacao> getPersonalizacoes() {
		return personalizacoes;
	}

	public void setPersonalizacoes(List<Personalizacao> personalizacoes) {
		this.personalizacoes = personalizacoes;
	}

	public void inserePersonalizacao(Personalizacao personalizacao) {
		this.personalizacoes.add(personalizacao);
	}

	public double getPrecoOriginal() {
		return precoOriginal;
	}

	public void setPrecoOriginal(double precoOriginal) {
		this.precoOriginal = precoOriginal;
	}

	public Integer getTempoOriginal() {
		return tempoOriginal;
	}

	public void setTempoOriginal(Integer tempoOriginal) {
		this.tempoOriginal = tempoOriginal;
	}

	public double getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(double precoTotal) {
		this.precoTotal = precoTotal;
	}
	
	public void incrementaPrecoTotal(double precoTotal) {
		this.precoTotal += precoTotal;
	}

	public void decrementaPrecoTotal(double precoTotal) {
		this.precoTotal -= precoTotal;
	}
	
	public Integer getTempoDePreparo() {
		return tempoDePreparo;
	}

	public void setTempoDePreparo(Integer tempoDePreparo) {
		this.tempoDePreparo = tempoDePreparo;
	}
	
	public void incrementaTempoDePreparo(Integer tempoDePreparo) {
		this.tempoDePreparo += tempoDePreparo;
	}

	public void decrementaTempoDePreparo(Integer tempoDePreparo) {
		this.tempoDePreparo -= tempoDePreparo;
	}

	public Date getDataCadastramento() {
		return dataCadastramento;
	}

	public void setDataCadastramento(Date dataCadastramento) {
		this.dataCadastramento = dataCadastramento;
	}

	@Override
	public String toString() {
		return "Pizza [id=" + id + ", tamanho=" + tamanho + ", sabor=" + sabor + ", personalizacoes=" + personalizacoes
				+ ", precoTotal=" + precoTotal + ", tempoDePreparo=" + tempoDePreparo + ", dataCadastramento="
				+ dataCadastramento + "]";
	}

}
