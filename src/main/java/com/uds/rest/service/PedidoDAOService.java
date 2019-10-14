package com.uds.rest.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.uds.rest.model.Cliente;
import com.uds.rest.model.Pedido;
import com.uds.rest.model.Pizza;

@Component
public class PedidoDAOService {

	
	private static List<Pedido> pedidos = new ArrayList<>();
	
	private static ClienteDAOService clienteService = new ClienteDAOService();
	private static PizzaDAOService pizzaService = new PizzaDAOService();
	
	static {
		Cliente findOneCliente = clienteService.findOne(1);
		Pizza findOnePizza = pizzaService.findOne(1);
		
		pedidos.add(new Pedido(pedidos.size() + 1, findOneCliente, findOnePizza));
	}
	
	
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
	
	
	
	public Pedido deleteById(int id) {
		Iterator<Pedido> iterator = pedidos.iterator();
		while(iterator.hasNext()) {
			Pedido pedido = iterator.next();
			if (pedido.getId() == id) {
				iterator.remove();
				return pedido;
			}
		}
		return null;
	}
}
