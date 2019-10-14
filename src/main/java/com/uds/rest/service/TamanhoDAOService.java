package com.uds.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.uds.rest.model.Tamanho;

@Component
public class TamanhoDAOService {

	private static List<Tamanho> tamanhos = new ArrayList<>();
	
	static {
		tamanhos.add(new Tamanho(1, "pequena", 20, 15));
		tamanhos.add(new Tamanho(2, "média", 30, 20));
		tamanhos.add(new Tamanho(3, "grande", 40, 25));
	}
	
	public List<Tamanho> findAll(){
		return tamanhos;
	}
	
	public Tamanho save(Tamanho tamanho) {
		if(tamanho.getId() == null) {
			tamanho.setId(tamanhos.size() + 1);
		}
		tamanhos.add(tamanho);
		return tamanho;
	}
	
	public Tamanho findOne(int id) {
		for(Tamanho tamanho : tamanhos) {
			if(tamanho.getId() == id) {
				return tamanho;
			}
		}
		return null;
	}
	
}
