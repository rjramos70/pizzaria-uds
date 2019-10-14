package com.uds.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.uds.rest.exception.PedidoNotFoundException;
import com.uds.rest.model.Pedido;
import com.uds.rest.model.Personalizacao;

@Component
public class PedidoDAOService {

	private static List<Pedido> pedidos = new ArrayList<>();
	
	
	public List<Pedido> findAll(){
		return pedidos;
	}
	
	public Pedido save(Pedido pedido) {
		if(pedido.getId() == null) {
			pedido.setId(pedidos.size() + 1);
		}
		pedidos.add(pedido);
		return pedido;
	}
	
	public Pedido findOne(int id) {
		for(Pedido pedido : pedidos) {
			if(pedido.getId() == id) {
				return pedido;
			}
		}
		return null;
	}
	
	public Pedido insereListaDePersonalizoes(Pedido pedido, List<Personalizacao> personalizacoes) {
		if(findOne(pedido.getId()) == null) {
			throw new PedidoNotFoundException("id: " + pedido.getId());
		}
		pedido.setPersonalizacoes(personalizacoes);
		return pedido;
	}
	
	public Pedido inserePersonalizoes(Pedido pedido, Personalizacao personalizacao) {
		if(findOne(pedido.getId()) == null) {
			throw new PedidoNotFoundException("id: " + pedido.getId());
		}
		pedido.inserePersonalizacao(personalizacao);
		return pedido;
	}
}
