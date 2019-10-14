package com.uds.rest.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.uds.rest.exception.PizzaNotFoundException;
import com.uds.rest.model.Personalizacao;
import com.uds.rest.model.Pizza;
import com.uds.rest.model.Sabor;
import com.uds.rest.model.Tamanho;

@Component
public class PizzaDAOService {

	private static List<Pizza> pizzas = new ArrayList<>();
	
	private static TamanhoDAOService tamanhoService = new TamanhoDAOService();
	private static SaborDAOService saborService = new SaborDAOService();
	
	static {
		Tamanho tamanho1 = tamanhoService.findOne(1);
		Sabor sabor1 = saborService.findOne(1);
		
		Pizza pizza1 = new Pizza(1, tamanho1.getTamanho(), sabor1.getSabor());
		pizza1.setPrecoOriginal(tamanho1.getValor());
		pizza1.setPrecoTotal(tamanho1.getValor());
		
		pizza1.setTempoOriginal(tamanho1.getTempoDePrepadro() + sabor1.getTempoAdicional());
		pizza1.setTempoDePreparo(tamanho1.getTempoDePrepadro() + sabor1.getTempoAdicional());
		
		pizzas.add(pizza1);
	}
	
	
	public List<Pizza> findAll(){
		return pizzas;
	}
	
	public Pizza save(Pizza pizza) {
		if(pizza.getId() == null) {
			pizza.setId(pizzas.size() + 1);
		}
		pizzas.add(pizza);
		return pizza;
	}
	
	public Pizza criaNova(String tamanho, String sabor) {
	
		Tamanho tamanhoTmp = tamanhoService.findByTamanho(tamanho);
		Sabor saborTmp = saborService.findBySabor(sabor);
		
		Pizza pizzaTmp = new Pizza(pizzas.size() + 1, tamanhoTmp.getTamanho(), saborTmp.getSabor());
		
		pizzaTmp.setPrecoOriginal(tamanhoTmp.getValor());
		pizzaTmp.setPrecoTotal(tamanhoTmp.getValor());
		
		pizzaTmp.setTempoOriginal(tamanhoTmp.getTempoDePrepadro() + saborTmp.getTempoAdicional());
		pizzaTmp.setTempoDePreparo(tamanhoTmp.getTempoDePrepadro() + saborTmp.getTempoAdicional());
	
		pizzas.add(pizzaTmp);
		
		return pizzaTmp;
	}
	
	public Pizza findOne(int id) {
		for(Pizza pizza : pizzas) {
			if(pizza.getId() == id) {
				return pizza;
			}
		}
		return null;
	}
	
	public Pizza deleteById(int id) {
		Iterator<Pizza> iterator = pizzas.iterator();
		while(iterator.hasNext()) {
			Pizza pizza = iterator.next();
			if (pizza.getId() == id) {
				iterator.remove();
				return pizza;
			}
		}
		return null;
	}
	
	public Pizza update(Pizza pizza) {
		Pizza pizzaDeletada = deleteById(pizza.getId());
		pizzas.add(pizza);
		return pizza;
	}
	
	public Pizza inserePersonalizacao(Pizza pizza, Personalizacao personalizacao) {
		if(findOne(pizza.getId()) == null) {
			throw new PizzaNotFoundException("id: " + pizza.getId());
		}
		pizza.inserePersonalizacao(personalizacao);
		pizza.incrementaPrecoTotal(personalizacao.getValorAdicional());
		pizza.incrementaTempoDePreparo(personalizacao.getTempoAdicional());
		
		return pizza;
	}
	
}
