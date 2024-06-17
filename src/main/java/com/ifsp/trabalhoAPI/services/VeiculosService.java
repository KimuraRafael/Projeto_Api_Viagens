package com.ifsp.trabalhoAPI.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ifsp.trabalhoAPI.models.Passagens;
import com.ifsp.trabalhoAPI.models.Veiculos;
import com.ifsp.trabalhoAPI.models.Viagem;
import com.ifsp.trabalhoAPI.repositories.VeiculosRepository;

import jakarta.transaction.Transactional;

public class VeiculosService {
	
	@Autowired
	private VeiculosRepository veiculosRepository;
	
	@Autowired
	private ViagensService viagemService;
	
	
	
	
	public Veiculos findbyId(Long id) {
		Optional<Veiculos> veiculo = this.veiculosRepository.findById(id);
		return veiculo.orElseThrow(() -> new RuntimeException(
				"Veiculo não encontrado! id:"+ id + "Tipo" + Veiculos.class.getName()));
	};
	
	
	@Transactional
	public Veiculos create (Veiculos obj) {
		Viagem viagem = this.viagemService.findbyId(obj.getViagem().getId_Viagem());
		obj.setId((Long) null);
		obj.setViagem(viagem);
		obj = this.veiculosRepository.save(obj);
		return obj;
		
	}
	
	@Transactional
	public Veiculos update(Veiculos obj) {
		Veiculos novoObj = findbyId(obj.getId());
		
		novoObj.setDesricao(obj.getDesricao());
		novoObj.setQtd_Assentos(obj.getQtd_Assentos());
	
		return this.veiculosRepository.save(novoObj);
	}
	
	@Transactional
	public void delete(Long id) {
		
		findbyId(id);
		try {
			
			this.veiculosRepository.deleteById(id);
		}
		catch(Exception e) {
			
			throw new RuntimeException("Não é possível excluir essa passagem");
		}
		
		
	}

}
