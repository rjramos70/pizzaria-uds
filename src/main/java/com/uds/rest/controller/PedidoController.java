package com.uds.rest.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.uds.rest.exception.ClienteNotFoundException;
import com.uds.rest.exception.PedidoNotFoundException;
import com.uds.rest.exception.PersonalizacaoNotFoundException;
import com.uds.rest.exception.PizzaNotFoundException;
import com.uds.rest.exception.SaborNotFoundException;
import com.uds.rest.exception.TamanhoNotFoundException;
import com.uds.rest.model.Cliente;
import com.uds.rest.model.Pedido;
import com.uds.rest.model.PedidoStatus;
import com.uds.rest.model.Personalizacao;
import com.uds.rest.model.Pizza;
import com.uds.rest.model.Sabor;
import com.uds.rest.model.Tamanho;
import com.uds.rest.service.ClienteDAOService;
import com.uds.rest.service.PedidoDAOService;
import com.uds.rest.service.PersonalizaDAOService;
import com.uds.rest.service.PizzaDAOService;
import com.uds.rest.service.SaborDAOService;
import com.uds.rest.service.TamanhoDAOService;

@RestController
public class PedidoController {

	@Autowired
	private SaborDAOService saborService;

	@Autowired
	private ClienteDAOService clienteService;

	@Autowired
	private TamanhoDAOService tamanhoService;

	@Autowired
	private PedidoDAOService pedidoService;

	@Autowired
	private PizzaDAOService pizzaService;

	@Autowired
	private PersonalizaDAOService personalizacaoService;

	/* ------------ Sabores ---------------------------- */
	@GetMapping(path = "pizzaria-uds/sabores")
	public List<Sabor> findAll() {
		return saborService.findAll();
	}

	@GetMapping(path = "pizzaria-uds/sabores/{id}")
	public Sabor recuperaSabor(@PathVariable int id) {
		Sabor sabor = saborService.findOne(id);
		if (sabor == null) {
			throw new SaborNotFoundException("id: " + id);
		}
		return sabor;
	}

	@PostMapping(path = "pizzaria-uds/sabores")
	public ResponseEntity<Object> criaSabor(@RequestBody Sabor sabor) {
		Sabor saborSalvo = saborService.save(sabor);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saborSalvo.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	/* ------------ Clientes ---------------------------- */
	@GetMapping(path = "pizzaria-uds/clientes")
	public List<Cliente> findAllClientes() {
		return clienteService.findAll();
	}

	@GetMapping(path = "pizzaria-uds/clientes/{id}")
	public Cliente recuperaCliente(@PathVariable int id) {
		Cliente cliente = clienteService.findOne(id);
		if (cliente == null) {
			throw new ClienteNotFoundException("id: " + id);
		}
		return cliente;
	}

	@PostMapping(path = "pizzaria-uds/clientes")
	public ResponseEntity<Object> criaCliente(@RequestBody Cliente cliente) {
		Cliente clienteSalvo = clienteService.save(cliente);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(clienteSalvo.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	/* ------------ Tamanhos ---------------------------- */
	@GetMapping(path = "pizzaria-uds/tamanhos")
	public List<Tamanho> findAllTamanhos() {
		return tamanhoService.findAll();
	}

	@GetMapping(path = "pizzaria-uds/tamanhos/{id}")
	public Tamanho recuperaTamanho(@PathVariable int id) {
		Tamanho tamanho = tamanhoService.findOne(id);

		if (tamanho == null) {
			throw new TamanhoNotFoundException("id: " + id);
		}
		return tamanho;
	}

	@PostMapping(path = "pizzaria-uds/tamanhos")
	public ResponseEntity<Object> criaTamanho(@RequestBody Tamanho tamanho) {
		Tamanho tamanhoSalvo = tamanhoService.save(tamanho);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(tamanhoSalvo.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	/* ------------ Pedidos ---------------------------- */
	@GetMapping(path = "pizzaria-uds/pedidos")
	public List<Pedido> findAllPedidos() {
		return pedidoService.findAll();
	}

	@GetMapping(path = "pizzaria-uds/pedidos/{id}")
	public Pedido recuperaPedido(@PathVariable int id) {
		Pedido pedido = pedidoService.findOne(id);
		if (pedido == null) {
			throw new PedidoNotFoundException("id: " + id);
		}
		return pedido;
	}

	@PostMapping(path = "pizzaria-uds/pedidos/{id}")
	public ResponseEntity<Object> criaPedido(@RequestBody Pedido pedido) {

		Pedido pedidoSalvo = pedidoService.save(pedido);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(pedidoSalvo.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@GetMapping(path = "pizzaria-uds/pedidos/{id}/cancelar")
	public Pedido cancelaPedido(@PathVariable int id) {

		Pedido pedido = pedidoService.findOne(id);

		if (pedido == null) {
			throw new PedidoNotFoundException("Pedido " + id + " não identificada em nossa base de dados.");
		}
		pedido.setStatus(PedidoStatus.CANCELADO);
		pedidoService.deleteById(id);
		pedidoService.save(pedido);
		return pedido;
	}

	/* ------------ Pizzas ---------------------------- */
	@GetMapping(path = "pizzaria-uds/pizzas")
	public List<Pizza> findAllPizzas() {
		return pizzaService.findAll();
	}

	@PostMapping(path = "pizzaria-uds/pizzas")
	public ResponseEntity<Object> criaPizza(@RequestBody Pizza pizza) {

		Tamanho findByTamanho = tamanhoService.findByTamanho(pizza.getTamanho());
		if (findByTamanho == null) {
			throw new TamanhoNotFoundException("Tamanho " + pizza.getTamanho() + " inválido.");
		}
		Sabor findBySabor = saborService.findBySabor(pizza.getSabor());
		if(findBySabor == null) {
			throw new SaborNotFoundException("Sabor " + pizza.getSabor() + " inválido.");
		}
		
		Pizza novaPizza = pizzaService.criaNova(pizza.getTamanho(), pizza.getSabor());
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novaPizza.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@PostMapping(path = "pizzaria-uds/pizzas/{id}/personalizar")
	public Pizza personalizaPizza(@PathVariable int id, @RequestBody Personalizacao personalizacao) {

		Pizza pizza = pizzaService.findOne(id);

		if (pizza == null) {
			throw new PizzaNotFoundException("Pizza " + id + " não identificada em nosso cadastro.");
		}

		Personalizacao per = personalizacaoService.findByName(personalizacao.getPersonalizacao());

		if (per == null) {
			throw new PersonalizacaoNotFoundException(
					"Personalizacao " + personalizacao.getPersonalizacao() + " não identificada em nosso cadastro.");
		}

		System.out.println(" PER :: " + per);
		
		return pizzaService.update(pizzaService.inserePersonalizacao(pizza, per));
	}

}
