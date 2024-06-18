package com.ifsp.trabalhoAPI.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ifsp.trabalhoAPI.models.Viagem;
import com.ifsp.trabalhoAPI.services.ViagensService;

@RestController
@RequestMapping("/viagens")
@Validated
public class ViagemController {
	
	@Autowired
	private ViagensService viagemService;
	
	
	// Localhost:8080/Viagem/
	@GetMapping("/{id_Viagem}")
	public ResponseEntity<Viagem> findById(@PathVariable Long id){
		
		Viagem obj = this.viagemService.findbyId(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody Viagem obj){
		
		this.viagemService.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{Id_viagem}").buildAndExpand(obj.getId_Viagem()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	

}
