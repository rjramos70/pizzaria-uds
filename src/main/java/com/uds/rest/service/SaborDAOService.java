package com.uds.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.uds.rest.model.Sabor;

@Component
public class SaborDAOService {

	private static List<Sabor> sabores = new ArrayList<>();

	static {
		sabores.add(new Sabor(1, "calabresa", 0));
		sabores.add(new Sabor(2, "marguerita", 0));
		sabores.add(new Sabor(3, "portuguesa", 5));
	}
	
	public List<Sabor> findAll(){
		return sabores;
	}
	
	public Sabor save(Sabor sabor) {
		if(sabor.getId() == null) {
			sabor.setId(sabores.size() + 1);
		}
		sabores.add(sabor);
		return sabor;
	}
	
	public Sabor findOne(int id) {
		for(Sabor sabor : sabores) {
			if(sabor.getId() == id) {
				return sabor;
			}
		}
		return null;
	}
}
