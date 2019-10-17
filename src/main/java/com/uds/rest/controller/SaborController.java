package com.uds.rest.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.uds.rest.exception.TamanhoNotFoundException;
import com.uds.rest.model.Sabor;
import com.uds.rest.repository.SaborRepository;

@RestController
public class SaborController {

	@Autowired
	private SaborRepository repository;
	

	@GetMapping(path = "/pizzaria-uds/sabores")
	public List<Sabor> findAll(){
		return repository.findAll();
	}
	
	@GetMapping(path = "/pizzaria-uds/sabores/{id}")
	public Optional<Sabor> findById(@PathVariable int id) {
		Optional<Sabor> sabor = repository.findById(id);
		
		if (!sabor.isPresent()) {
			saborNotFound();
		}
		
		return sabor;
	}
	
	
	@PostMapping(path = "/pizzaria-uds/sabores")
	public ResponseEntity<Object> create(@Valid @RequestBody Sabor sabor) {
		 @Valid
		 Sabor savedTamanho = repository.save(sabor);
		
		 URI location = ServletUriComponentsBuilder
				 			.fromCurrentRequest()
				 			.path("/{id}")
				 			.buildAndExpand(savedTamanho.getId())
				 			.toUri();
		 
		 return ResponseEntity
				 .created(location)
				 .build();
		 
	}
	
	@DeleteMapping(path = "/pizzaria-uds/sabores/{id}")
	public void deleteById(@PathVariable int id) {
		Optional<Sabor> sabor = repository.findById(id);
		
		if (!sabor.isPresent()) {
			saborNotFound();
		}
		
		repository.deleteById(id);
	}


	private void saborNotFound() {
		throw new TamanhoNotFoundException("Sabor não consta em nossa base de dados.");
	}
	
}
