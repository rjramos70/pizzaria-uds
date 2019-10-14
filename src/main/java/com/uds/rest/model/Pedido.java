package com.uds.rest.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {

	private Integer id;
	private String tamanho;
	private String sabor;
	private List<Personalizacao> personalizacoes;
	private Date dataCadastramento;

	public Pedido(Integer id, String tamanho, String sabor) {
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

	public Date getDataCadastramento() {
		return dataCadastramento;
	}

	public void setDataCadastramento(Date dataCadastramento) {
		this.dataCadastramento = dataCadastramento;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", tamanho=" + tamanho + ", sabor=" + sabor + ", personalizacoes=" + personalizacoes
				+ ", dataCadastramento=" + dataCadastramento + "]";
	}

}