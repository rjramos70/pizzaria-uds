package com.uds.rest.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {

	private Integer id;
	private String tamanho;
	private String sabor;
	private List<String> personalizacoes;
	private double valorTotal;
	private int tempoDePreparo;

	private Cliente cliente;
	private Pizza pizza;
	private PedidoStatus status;
	private Date dataCadastramento;

	public Pedido(Integer id, Cliente cliente, Pizza pizza) {
		this.id = id;
		this.cliente = cliente;
		this.pizza = pizza;
		this.status = PedidoStatus.ABERTO;
		this.tamanho = pizza.getTamanho();
		this.sabor = pizza.getSabor();

		 this.personalizacoes = new ArrayList<>();
		 for (Personalizacao personalizacao : pizza.getPersonalizacoes()) {
		 	this.personalizacoes.add(personalizacao.getPersonalizacao());
		 }

		this.valorTotal = pizza.getPrecoTotal();
		this.tempoDePreparo = pizza.getTempoDePreparo();
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

	public List<String> getPersonalizacoes() {
		if(this.personalizacoes.size() != pizza.getPersonalizacoes().size()) {
			this.personalizacoes.clear();
			for (Personalizacao perso : pizza.getPersonalizacoes()) {
				this.personalizacoes.add(perso.getPersonalizacao());
			}
		}
		
		return this.personalizacoes;
	}

	public void setPersonalizacoes(List<String> personalizacoes) {
		this.personalizacoes = personalizacoes;
	}

	public double getValorTotal() {
		return pizza.getPrecoTotal();
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getTempoDePreparo() {
		return pizza.getTempoDePreparo();
	}

	public void setTempoDePreparo(int tempoDePreparo) {
		this.tempoDePreparo = tempoDePreparo;
	}

//	public Cliente getCliente() {
//		return cliente;
//	}
//
//	public void setCliente(Cliente cliente) {
//		this.cliente = cliente;
//	}
//
//	public Pizza getPizza() {
//		return pizza;
//	}
//
//	public void setPizza(Pizza pizza) {
//		this.pizza = pizza;
//	}

//	public PedidoStatus getStatus() {
//		return status;
//	}
//
//	public void setStatus(PedidoStatus status) {
//		this.status = status;
//	}
//
//	public Date getDataCadastramento() {
//		return dataCadastramento;
//	}
//
//	public void setDataCadastramento(Date dataCadastramento) {
//		this.dataCadastramento = dataCadastramento;
//	}

	@Override
	public String toString() {
		return "Pedido [id=" + id 
				+ ", valorTotal=" + valorTotal + ", tempoDePreparo=" + tempoDePreparo + ", cliente=" + cliente
				+ ", pizza=" + pizza + ", status=" + status + ", dataCadastramento=" + dataCadastramento + "]";
	}

}
