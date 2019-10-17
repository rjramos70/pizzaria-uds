package com.uds.rest.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.uds.rest.exception.PedidoNotFoundException;
import com.uds.rest.exception.PizzaNotFoundException;
import com.uds.rest.model.Pedido;
import com.uds.rest.model.Pizza;
import com.uds.rest.repository.PedidoRepository;
import com.uds.rest.repository.PizzaRepository;

@RestController
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepo;
	
	@Autowired
	private PizzaRepository pizzaRepo;
	
	@GetMapping(path = "/pizzaria-uds/pedidos")
	public List<Pedido> findAll(){
		return pedidoRepo.findAll();
	}

	@PostMapping(path = "/pizzaria-uds/pedidos")
	public ResponseEntity<Object> create(@RequestBody Pizza id) {
		
		System.out.println("ID : " + id);
		
		Optional<Pizza> pizzaOptional = pizzaRepo.findById(id.getId());
		if (!pizzaOptional.isPresent()) {
			throw new PizzaNotFoundException("Código da pizza não existe");
		}
		
		Pizza pizza = pizzaOptional.get();
		// verifica se esta Pizza já foi inserida em algum pedido anterior.
		List<Pedido> pedidosAnteriores = pedidoRepo.findAll();
		for (Pedido pedido : pedidosAnteriores) {
			if (pedido.getPizza().getId().equals(pizza.getId())) {
				throw new PedidoNotFoundException("Pedido não pode ser criado, pois esta Pizza já pertence a outro pedido.");
			}
		}
		
		Pedido pedido = new Pedido();
		pedido.setTamanho(pizza.getTamanho());
		pedido.setSabor(pizza.getSabor());
		pedido.setValorTotal(pizza.getValorTotal());
		pedido.setTempoTotal(pizza.getTempoTotal());
		
		pedido.setPizza(pizza);
		
		Pedido pedidoSaved = pedidoRepo.save(pedido);
		
		URI location = ServletUriComponentsBuilder
	 			.fromCurrentRequest()
	 			.path("/{id}")
	 			.buildAndExpand(pedidoSaved.getId())
	 			.toUri();

		return ResponseEntity
			 .created(location)
			 .build();
		
		
	}
	
	@GetMapping(path = "/pizzaria-uds/pedidos/{id}")
	public Optional<Pedido> findById(@PathVariable int id) {
		Optional<Pedido> pedido = pedidoRepo.findById(id);
		if(!pedido.isPresent()) {
			pedidoNotFoundMessage();
		}
		return pedido;
	}
	
	
	@DeleteMapping(path = "/pizzaria-uds/pedidos/{id}")
	public void deleteById(@PathVariable int id) {
		Optional<Pedido> pedido = pedidoRepo.findById(id);
		
		if (!pedido.isPresent()) {
			pedidoNotFoundMessage();
		}
		
		pedidoRepo.deleteById(id);
	}

	private void pedidoNotFoundMessage() {
		throw new PedidoNotFoundException("Pedido não consta em nossa base de dados.");
	}
}
