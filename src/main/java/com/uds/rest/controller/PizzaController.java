package com.uds.rest.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.uds.rest.exception.PersonalizacaoNotFoundException;
import com.uds.rest.exception.PizzaNotFoundException;
import com.uds.rest.exception.TamanhoNotFoundException;
import com.uds.rest.model.Pedido;
import com.uds.rest.model.Personalizacao;
import com.uds.rest.model.Pizza;
import com.uds.rest.model.Sabor;
import com.uds.rest.model.Tamanho;
import com.uds.rest.repository.PedidoRepository;
import com.uds.rest.repository.PersonalizacaoRepository;
import com.uds.rest.repository.PizzaRepository;
import com.uds.rest.repository.SaborRepository;
import com.uds.rest.repository.TamanhoRepository;

@RestController
public class PizzaController {
	
	@Autowired
	private PizzaRepository pizzaRepo;
	
	@Autowired
	private PersonalizacaoRepository personalizacaoRepo;
	
	@Autowired
	private TamanhoRepository tamanhoRepo;
	
	@Autowired
	private SaborRepository saborRepo;
	
	@Autowired
	private PedidoRepository pedidoRepo;
	
	@GetMapping(path = "/pizzaria-uds/pizzas")
	public List<Pizza> findAll(){
		return pizzaRepo.findAll();
	}
	
	
	@PostMapping(path = "/pizzaria-uds/pizzas")
	public ResponseEntity<Object> create(@Valid @RequestBody Pizza pizza) {
		
		 System.out.println(" >> TESTE :: pizza :: " + pizza);
		 Tamanho tamanho = null;
		 List<Tamanho> tamanhos = tamanhoRepo.findAll();
		 for (Tamanho tam : tamanhos) {
			if(tam.getTamanho().equals(pizza.getTamanho())) {
				tamanho = tam;
			}
		 }
		 
		 Sabor sabor = null;
		 List<Sabor> sabores = saborRepo.findAll();
		 for (Sabor sab : sabores) {
			if(sab.getDescricao().equals(pizza.getSabor())) {
				sabor = sab;
			}
		 }
		
		 pizza.setValorInicial(tamanho.getValor());
		 pizza.setTempoInicial(tamanho.getTempoDePrepadro() + sabor.getTempoAdicional());
		 
		 pizza.setValorTotal(tamanho.getValor());
		 pizza.setTempoTotal(tamanho.getTempoDePrepadro() + sabor.getTempoAdicional());
		 
		 @Valid
		 Pizza savedTamanho = pizzaRepo.save(pizza);
		
		 URI location = ServletUriComponentsBuilder
				 			.fromCurrentRequest()
				 			.path("/{id}")
				 			.buildAndExpand(savedTamanho.getId())
				 			.toUri();
		 
		 return ResponseEntity
				 .created(location)
				 .build();
		
	}
	
	@DeleteMapping(path = "/pizzaria-uds/pizzas/{id}")
	public void deleteById(@PathVariable int id) {
		Optional<Pizza> pizza = pizzaRepo.findById(id);
		
		if (!pizza.isPresent()) {
			pizzaNotFoundMessage();
		}
		
		List<Pedido> pedidos = pedidoRepo.findAll();
		for (Pedido pedido : pedidos) {
			if(pedido.getPizza().getId().equals(pizza.get().getId())) {
				throw new PizzaNotFoundException("Pizza não pode ser removida por ter Pedido atrelado, remova antes o Pedido.");
			}
		}
		
		pizzaRepo.deleteById(id);
	}


	private void pizzaNotFoundMessage() {
		throw new PizzaNotFoundException("Pizza não consta em nossa base de dados.");
	}
	
	
	@GetMapping(path = "/pizzaria-uds/pizzas/{id}")
	public Optional<Pizza> findById(@PathVariable int id) {
		Optional<Pizza> pizza = pizzaRepo.findById(id);
		if(!pizza.isPresent()) {
			pizzaNotFoundMessage();
		}
		return pizza;
	}
	
	@PutMapping(path = "/pizzaria-uds/pizzas/{id}/personalizar")
	public ResponseEntity<Object> personalizar(@PathVariable int id, @Valid @RequestBody Personalizacao personalizacao) {
		
		Pizza pizza = pizzaRepo.findById(id).orElseThrow(() -> new PizzaNotFoundException("Pizza consta em nossa base de dados."));
		
		System.out.println("Personalizacao :: " + personalizacao);
		
		List<Personalizacao> personalizacoes = personalizacaoRepo.findAll();
		Personalizacao per = null;
		for (Personalizacao perso : personalizacoes) {
			if(perso.getDescricao().equals(personalizacao.getDescricao())) {
				per = perso;
			}
		}
		
		if(per == null) {
			throw new PersonalizacaoNotFoundException("Personalização não existe.");
		}
		
		pizza.inserePersonalizacao(per);
		
		Pizza updatedPizza = pizzaRepo.save(pizza);
		
		System.out.println(" TESTE :: updatedPizza :: " + updatedPizza);
		
		return ResponseEntity.ok(updatedPizza);
		
		
	}

	
	
}
