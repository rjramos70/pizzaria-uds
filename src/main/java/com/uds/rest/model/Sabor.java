package com.uds.rest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sabor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String descricao;
	
	@Column
	private Integer tempoAdicional;
	

	public Sabor() {	}
	
	public Sabor(Integer id, String descricao, Integer tempoAdicional) {
		this.id = id;
		this.descricao = descricao;
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

	public Integer getTempoAdicional() {
		return tempoAdicional;
	}

	public void setTempoAdicional(Integer tempoAdicional) {
		this.tempoAdicional = tempoAdicional;
	}

	@Override
	public String toString() {
		return "Sabor [id=" + id + ", descricao=" + descricao + ", tempoAdicional=" + tempoAdicional + "]";
	}

}
