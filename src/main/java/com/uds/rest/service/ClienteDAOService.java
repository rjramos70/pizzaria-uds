package com.uds.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.uds.rest.model.Cliente;

@Component
public class ClienteDAOService {

	private static List<Cliente> clientes = new ArrayList<>();
	
	static {
		clientes.add(new Cliente(1, "Renato", "Ramos"));
		clientes.add(new Cliente(2, "Maria", "Silva"));
		clientes.add(new Cliente(3, "Marcelo", "Almeida"));
	}
	
	public List<Cliente> findAll(){
		return clientes;
	}
	
	public Cliente save(Cliente cliente) {
		if(cliente.getId() == null) {
			cliente.setId(clientes.size() + 1);
		}
		clientes.add(cliente);
		return cliente;
	}
	
	public Cliente findOne(int id) {
		for(Cliente cliente : clientes) {
			if(cliente.getId() == id) {
				return cliente;
			}
		}
		return null;
	}
}
