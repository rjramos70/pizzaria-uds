package com.uds.rest.model;

import org.junit.Assert;
import org.junit.Test;

public class ModelosTest {

	@Test
	public void testCreateTamanho() {
		Integer id = 999;
		String strTamanho = "gigante";
		double valor = 50;
		Integer tempo = 25;
		Tamanho tamanho = new Tamanho(id, strTamanho, valor, tempo);

		Assert.assertTrue(id == tamanho.getId());
		Assert.assertTrue(strTamanho.equals(tamanho.getTamanho()));
		Assert.assertTrue(valor == tamanho.getValor());
		Assert.assertTrue(tempo == tamanho.getTempoDePrepadro());
	}
	
	@Test
	public void testCreateSabor() {
		Integer id = 999;
		String descricao = "banana";
		Integer tempo = 5;
		
		Sabor sabor = new Sabor(id, descricao, tempo);

		Assert.assertTrue(id == sabor.getId());
		Assert.assertTrue(descricao.equals(sabor.getDescricao()));
		Assert.assertTrue(tempo == sabor.getTempoAdicional());
	}
	
	@Test
	public void testCreatePersonalizacao() {
		Integer id = 999;
		String descricao = "extra catupiry";
		double valorAdicional = 6;
		Integer tempoAdicional = 5;
		
		Personalizacao personalizacao = new Personalizacao(id, descricao, valorAdicional, tempoAdicional);

		Assert.assertTrue(id == personalizacao.getId());
		Assert.assertTrue(descricao.equals(personalizacao.getDescricao()));
		Assert.assertTrue(valorAdicional == personalizacao.getValorAdicional());
		Assert.assertTrue(tempoAdicional == personalizacao.getTempoAdicional());
	}

	@Test
	public void testCreatePizza() {
		Integer id = 999;
		String tamanho = "grande";
		String sabor = "portuguesa";
		double valorInicial = 30;
		Integer tempoInicial = 15;
		double valorTotal = 30;
		Integer tempoTotal = 15;
		
		Pizza pizza = new Pizza(id, tamanho, sabor, valorInicial, tempoInicial, valorTotal, tempoTotal);

		Assert.assertTrue(id == pizza.getId());
		Assert.assertTrue(tamanho.equals(pizza.getTamanho()));
		Assert.assertTrue(sabor.equals(pizza.getSabor()));
		Assert.assertTrue(valorInicial == pizza.getValorInicial());
		Assert.assertTrue(tempoInicial == pizza.getTempoInicial());
		Assert.assertTrue(valorTotal == pizza.getValorTotal());
		Assert.assertTrue(tempoTotal == pizza.getTempoTotal());
	}
	
	
		@Test
		public void testCreatePedido() {
			Integer id = 999;
			String tamanho = "grande";
			String sabor = "portuguesa";
			double valorTotal = 30;
			Integer tempoTotal = 15;
			
			Pedido pedido = new Pedido(id, tamanho, sabor, valorTotal, tempoTotal);
			
			Assert.assertTrue(id == pedido.getId());
			Assert.assertTrue(tamanho.equals(pedido.getTamanho()));
			Assert.assertTrue(sabor.equals(pedido.getSabor()));
			Assert.assertTrue(valorTotal == pedido.getValorTotal());
			Assert.assertTrue(tempoTotal == pedido.getTempoTotal());
		}
}
