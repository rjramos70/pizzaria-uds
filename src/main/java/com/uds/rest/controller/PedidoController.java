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
import com.uds.rest.exception.SaborNotFoundException;
import com.uds.rest.exception.TamanhoNotFoundException;
import com.uds.rest.model.Cliente;
import com.uds.rest.model.Pedido;
import com.uds.rest.model.Sabor;
import com.uds.rest.model.Tamanho;
import com.uds.rest.service.ClienteDAOService;
import com.uds.rest.service.PedidoDAOService;
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
	
	/* ------------ Sabores ---------------------------- */
	@GetMapping(path = "pizzaria-uds/sabores")
	public List<Sabor> findAll(){
		return saborService.findAll();
	}
	
	@GetMapping(path = "pizzaria-uds/sabores/{id}")
	public Sabor recuperaSabor(@PathVariable int id) {
		Sabor sabor = saborService.findOne(id);
		if(sabor == null) {
			throw new SaborNotFoundException("id: " + id);
		}
		return sabor;
	}
	
	@PostMapping(path = "pizzaria-uds/sabores")
	public ResponseEntity<Object> criaSabor(@RequestBody Sabor sabor) {
		Sabor saborSalvo = saborService.save(sabor);
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(saborSalvo.getId())
			.toUri();
		
		
		return ResponseEntity.created(location).build();
	}
	
	/* ------------ Clientes ---------------------------- */
	@GetMapping(path = "pizzaria-uds/clientes")
	public List<Cliente> findAllClientes(){
		return clienteService.findAll();
	}
	
	@GetMapping(path = "pizzaria-uds/clientes/{id}")
	public Cliente recuperaCliente(@PathVariable int id) {
		Cliente cliente = clienteService.findOne(id);
		if(cliente == null) {
			throw new ClienteNotFoundException("id: " + id);
		}
		return cliente;
	}
	
	@PostMapping(path = "pizzaria-uds/clientes")
	public ResponseEntity<Object> criaCliente(@RequestBody Cliente cliente) {
		Cliente clienteSalvo = clienteService.save(cliente);
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(clienteSalvo.getId())
			.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
	/* ------------ Tamanhos ---------------------------- */
	@GetMapping(path = "pizzaria-uds/tamanhos")
	public List<Tamanho> findAllTamanhos(){
		return tamanhoService.findAll();
	}
	
	@GetMapping(path = "pizzaria-uds/tamanhos/{id}")
	public Tamanho recuperaTamanho(@PathVariable int id) {
		Tamanho tamanho = tamanhoService.findOne(id);
		
		if(tamanho == null) {
			throw new TamanhoNotFoundException("id: " + id);
		}
		return tamanho;
	}
	
	@PostMapping(path = "pizzaria-uds/tamanhos")
	public ResponseEntity<Object> criaTamanho(@RequestBody Tamanho tamanho) {
		Tamanho tamanhoSalvo = tamanhoService.save(tamanho);
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(tamanhoSalvo.getId())
			.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
	/* ------------ Clientes ---------------------------- */
	@GetMapping(path = "pizzaria-uds/pedidos")
	public List<Pedido> findAllPedidos(){
		return pedidoService.findAll();
	}
	
	@PostMapping(path = "pizzaria-uds/pedidos/{id}")
	public ResponseEntity<Object> criaPedido(@RequestBody Pedido pedido) {
		
		Pedido pedidoSalvo = pedidoService.save(pedido);
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(pedidoSalvo.getId())
			.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
}
