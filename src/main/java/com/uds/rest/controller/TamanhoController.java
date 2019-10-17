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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.uds.rest.exception.TamanhoNotFoundException;
import com.uds.rest.model.Tamanho;
import com.uds.rest.repository.TamanhoRepository;

@RestController
public class TamanhoController {

	
	@Autowired
	private TamanhoRepository repository;
	
	@GetMapping(path = "/pizzaria-uds/tamanhos")
	public List<Tamanho> findAll(){
		return repository.findAll();
	}
	
	
	@GetMapping(path = "/pizzaria-uds/tamanhos/{id}")
	public Optional<Tamanho> findById(@PathVariable int id) {
		Optional<Tamanho> tamanho = repository.findById(id);
		
		if (!tamanho.isPresent()) {
			tamanhoNotFound();
		}
		
		return tamanho;
	}
	
	
	@PostMapping(path = "/pizzaria-uds/tamanhos")
	public ResponseEntity<Object> create(@Valid @RequestBody Tamanho tamanho) {
		 @Valid
		 Tamanho savedTamanho = repository.save(tamanho);
		
		 URI location = ServletUriComponentsBuilder
				 			.fromCurrentRequest()
				 			.path("/{id}")
				 			.buildAndExpand(savedTamanho.getId())
				 			.toUri();
		 
		 return ResponseEntity
				 .created(location)
				 .build();
		 
	}
	
	@DeleteMapping(path = "/pizzaria-uds/tamanhos/{id}")
	public void deleteById(@PathVariable int id) {
		Optional<Tamanho> tamanho = repository.findById(id);
		
		if (!tamanho.isPresent()) {
			tamanhoNotFound();
		}
		
		repository.deleteById(id);
	}


	private void tamanhoNotFound() {
		throw new TamanhoNotFoundException("Tamanho não consta em nossa base de dados.");
	}
	
	
}
