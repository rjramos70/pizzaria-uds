package com.uds.rest.model;

import java.util.Date;

public class Cliente {
	
	private Integer id;
	private String nome;
	private String ultimoNome;
	private Date dataCadastramento;

	public Cliente(Integer id, String nome, String ultimoNome) {
		this.id = id;
		this.nome = nome;
		this.ultimoNome = ultimoNome;
		this.dataCadastramento = new Date();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public Date getDataCadastramento() {
		return dataCadastramento;
	}

	public void setDataCadastramento(Date dataCadastramento) {
		this.dataCadastramento = dataCadastramento;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", ultimoNome=" + ultimoNome + ", dataCadastramento="
				+ dataCadastramento + "]";
	}
	
	

}
