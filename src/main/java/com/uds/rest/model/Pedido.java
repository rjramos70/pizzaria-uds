package com.uds.rest.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	 @OneToOne
	 // @JoinColumn(name = "pizza_id", referencedColumnName = "id")
	 @JsonIgnore
	 private Pizza pizza;

	private String tamanho;
	private String sabor;
	private double valorTotal;
	private Integer tempoTotal;

	public Pedido() {
	}

	public Pedido(Integer id, String tamanho, String sabor, double valorTotal, Integer tempoTotal) {
		super();
		this.id = id;
		this.tamanho = tamanho;
		this.sabor = sabor;
		this.valorTotal = valorTotal;
		this.tempoTotal = tempoTotal;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
		this.tamanho = pizza.getTamanho();
		this.sabor = pizza.getSabor();
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

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Integer getTempoTotal() {
		return tempoTotal;
	}

	public void setTempoTotal(Integer tempoTotal) {
		this.tempoTotal = tempoTotal;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", tamanho=" + tamanho + ", sabor=" + sabor + ", valorTotal=" + valorTotal
				+ ", tempoTotal=" + tempoTotal + "]";
	}

}
