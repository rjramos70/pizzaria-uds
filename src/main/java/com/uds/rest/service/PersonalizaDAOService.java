package com.uds.rest.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.uds.rest.model.Personalizacao;

@Component
public class PersonalizaDAOService {

	private static List<Personalizacao> personalizacoes = new ArrayList<>();
	
	static {
		personalizacoes.add(new Personalizacao(1, "extra bacon", 3, 0));
		personalizacoes.add(new Personalizacao(2, "sem cebola", 0, 0));
		personalizacoes.add(new Personalizacao(3, "borda recheada", 5, 5));
	}
	
	public List<Personalizacao> findAll(){
		return personalizacoes;
	}
	
	public Personalizacao save(Personalizacao personalizacao) {
		if(personalizacao.getId() == null) {
			personalizacao.setId(personalizacoes.size() + 1);
		}
		personalizacoes.add(personalizacao);
		return personalizacao;
	}
	
	public Personalizacao findOne(int id) {
		for(Personalizacao personalizacao : personalizacoes) {
			if(personalizacao.getId() == id) {
				return personalizacao;
			}
		}
		return null;
	}
	
	public Personalizacao findByName(String descricao) {
		System.out.println(" Personalizacao findByName :: " + descricao);
		for(Personalizacao personalizacao : personalizacoes) {
			System.out.println(" >> personalizacao :: " + personalizacao);
			if(personalizacao.getPersonalizacao().equalsIgnoreCase(descricao)) {
				return personalizacao;
			}
		}
		return null;
	}
	
	public Personalizacao deleteById(int id) {
		Iterator<Personalizacao> iterator = personalizacoes.iterator();
		while(iterator.hasNext()) {
			Personalizacao personalizacao = iterator.next();
			if (personalizacao.getId() == id) {
				iterator.remove();
				return personalizacao;
			}
		}
		return null;
	}
}
