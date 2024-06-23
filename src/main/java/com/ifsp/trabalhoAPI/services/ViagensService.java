package com.ifsp.trabalhoAPI.services;

import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifsp.trabalhoAPI.models.Viagem;
import com.ifsp.trabalhoAPI.repositories.PassagensRepository;
import com.ifsp.trabalhoAPI.repositories.VeiculosRepository;
import com.ifsp.trabalhoAPI.repositories.ViagensRepository;

import jakarta.transaction.Transactional;

@Service
public class ViagensService {
	
	@Autowired
	private PassagensRepository passagemRepository;
	
	@Autowired
	private VeiculosRepository veiculosRepository;
	
	@Autowired
	private ViagensRepository viagemRepository;
	
	
	public Viagem findbyId(Long id) {
		Optional<Viagem> viagem = this.viagemRepository.findById(id);
		
		return viagem.orElseThrow(() -> new RuntimeException(
				"Viagem não encontrada! id:"+ id + "Tipo" + Viagem.class.getName()));
	};

	
	@Transactional
	public Viagem create(Viagem obj){ 
		obj = this.viagemRepository.save(obj);
		obj.setDescricao(obj.getDescricao());
		this.passagemRepository.saveAll(obj.getLista_Passagens());
		this.veiculosRepository.saveAll(obj.getLista_Veiculos());
		return obj;
	}
	
	@Transactional
	public Viagem update(Viagem obj) {
		Viagem novoObj = findbyId(obj.getId_Viagem());
		novoObj.setDescricao(novoObj.getDescricao());
		novoObj.setLista_Passagens(novoObj.getLista_Passagens());
		novoObj.setLista_Veiculos(novoObj.getLista_Veiculos());
		return this.viagemRepository.save(novoObj);
	}
	
	@Transactional
	public void delete(Long id) {
		findbyId(id);
		try {
			this.viagemRepository.deleteById(id);
		}catch(Exception e) {
			
			throw new RuntimeException("Não é possível excluir pois há entidade relacionadas!");
			
		}
	}
	
}
