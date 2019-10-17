package com.uds.rest.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uds.rest.exception.PersonalizacaoNotFoundException;

@Entity
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String tamanho;
	private String sabor;
	private double valorInicial;
	private Integer tempoInicial;
	private double valorTotal;
	private Integer tempoTotal;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Personalizacao> personalizacoes;

	@OneToOne(mappedBy = "pizza")
	@JsonIgnore
	private Pedido pedido;

	public Pizza() {
	}

	public Pizza(Integer id, String tamanho, String sabor, double valorInicial, Integer tempoInicial, double valorTotal,
			Integer tempoTotal) {
		super();
		this.id = id;
		this.tamanho = tamanho;
		this.sabor = sabor;
		this.valorInicial = valorInicial;
		this.tempoInicial = tempoInicial;
		this.valorTotal = valorTotal;
		this.tempoTotal = tempoTotal;
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

	public double getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(double valorInicial) {
		this.valorInicial = valorInicial;
	}

	public Integer getTempoInicial() {
		return tempoInicial;
	}

	public void setTempoInicial(Integer tempoInicial) {
		this.tempoInicial = tempoInicial;
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

	public void inserePersonalizacao(Personalizacao personalizacao) {
		if (personalizacao == null) {
			throw new PersonalizacaoNotFoundException("Personalização não cosnta em nossa base de dados.");
		}
		setValorTotal(getValorTotal() + personalizacao.getValorAdicional());
		setTempoTotal(getTempoTotal() + personalizacao.getTempoAdicional());
		personalizacoes.add(personalizacao);
	}

	public List<Personalizacao> getPersonalizacoes() {
		return personalizacoes;
	}

	public void setPersonalizacoes(List<Personalizacao> personalizacoes) {
		this.personalizacoes = personalizacoes;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public String toString() {
		return "Pizza [id=" + id + ", tamanho=" + tamanho + ", sabor=" + sabor + ", valorInicial=" + valorInicial
				+ ", tempoInicial=" + tempoInicial + ", valorTotal=" + valorTotal + ", tempoTotal=" + tempoTotal
				+ ", personalizacoes=" + personalizacoes + ", pedido=" + pedido + "]";
	}

}
