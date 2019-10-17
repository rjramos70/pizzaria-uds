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

import com.uds.rest.exception.PersonalizacaoNotFoundException;
import com.uds.rest.exception.TamanhoNotFoundException;
import com.uds.rest.model.Personalizacao;
import com.uds.rest.model.Sabor;
import com.uds.rest.repository.PersonalizacaoRepository;

@RestController
public class PersonalizacaoController {
	
	@Autowired
	private PersonalizacaoRepository personalizacaoRepo;
	
	@GetMapping(path = "/pizzaria-uds/personalizacoes")
	public List<Personalizacao> findAllPersonalizacao(){
		return personalizacaoRepo.findAll();
	}
	
	@GetMapping(path = "/pizzaria-uds/personalizacoes/{id}")
	public Personalizacao findPersonalizacaoById(@PathVariable int id){
		Personalizacao personalizacao = personalizacaoRepo.findById(id).orElseThrow(() -> new TamanhoNotFoundException("Tamanha não existe em nossa base de dados."));
		
		return personalizacao;
	}

	@PostMapping(path = "/pizzaria-uds/personalizacoes")
	public ResponseEntity<Object> create(@Valid @RequestBody Personalizacao personalizacao) {
		System.out.println(" >> TESTE 1 :: personalizacao :: " + personalizacao);
		
		@Valid
		Personalizacao personalizacaoSaved = personalizacaoRepo.save(personalizacao);
		
		URI location = ServletUriComponentsBuilder
	 			.fromCurrentRequest()
	 			.path("/{id}")
	 			.buildAndExpand(personalizacaoSaved.getId())
	 			.toUri();

		return ResponseEntity
			 .created(location)
			 .build();
	}
	
	@DeleteMapping(path = "/pizzaria-uds/personalizacoes/{id}")
	public void deleteById(@PathVariable int id) {
		Optional<Personalizacao> personalizacao = personalizacaoRepo.findById(id);
		
		if (!personalizacao.isPresent()) {
			throw new PersonalizacaoNotFoundException("Personalização não consta em nossa base de dados.");
		}
		
		personalizacaoRepo.deleteById(id);
	}
}
