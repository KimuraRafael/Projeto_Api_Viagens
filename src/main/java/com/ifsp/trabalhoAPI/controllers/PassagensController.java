package com.ifsp.trabalhoAPI.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ifsp.trabalhoAPI.models.Passagens;
import com.ifsp.trabalhoAPI.models.Viagem;
import com.ifsp.trabalhoAPI.services.PassagensService;
import com.ifsp.trabalhoAPI.services.ViagensService;

@RestController
@RequestMapping("/passagens")
@Validated
public class PassagensController {
	@Autowired
	private PassagensService passagemService;
	
	
	// Localhost:8080/passagens/
	@GetMapping("/{id}")
	public ResponseEntity<Passagens> findById(@PathVariable Long id){	
		
		Passagens obj = this.passagemService.findbyId(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<?>create(@RequestBody Passagens obj){
		
		this.passagemService.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id_Viagem}")
				.buildAndExpand(obj.getId())
				.toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody Passagens obj, @PathVariable Long id){
		obj.setId(id);
		this.passagemService.update(obj);
		return ResponseEntity.noContent().build();	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		this.passagemService.delete(id); 
		return ResponseEntity.noContent().build();
	}


}
