package com.ifsp.trabalhoAPI.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifsp.trabalhoAPI.models.Passagens;
import com.ifsp.trabalhoAPI.models.Viagem;
import com.ifsp.trabalhoAPI.repositories.PassagensRepository;
import com.ifsp.trabalhoAPI.repositories.ViagensRepository;

import jakarta.transaction.Transactional;

@Service
public class PassagensService {
	
	
	@Autowired
	private PassagensRepository passagensRepository;
	
	@Autowired
	private ViagensService viagemService;
	
	
	
	
	public Passagens findbyId(Long id) {
		Optional<Passagens> passagem = this.passagensRepository.findById(id);
		return passagem.orElseThrow(() -> new RuntimeException(
				"Passagem não encontrada! id:"+ id + "Tipo" + Passagens.class.getName()));
	};
	
	
	@Transactional
	public Passagens create (Passagens obj) {
		Viagem viagem = this.viagemService.findbyId(obj.getViagem().getId_Viagem());
		obj.setId((Long) null);
		obj.setViagem(viagem);
		obj = this.passagensRepository.save(obj);
		return obj;
		
	}
	
	@Transactional
	public Passagens update(Passagens obj) {
		Passagens novoObj = findbyId(obj.getId());
		
		novoObj.setData_inicio(obj.getData_inicio());
		novoObj.setData_fim(obj.getData_fim());
		novoObj.setDestino(obj.getDestino());
		novoObj.setOrigem(obj.getOrigem());
		novoObj.setValor(obj.getValor());
	
		return this.passagensRepository.save(novoObj);
	}
	
	@Transactional
	public void delete(Long id) {
		
		findbyId(id);
		try {
			
			this.passagensRepository.deleteById(id);
		}
		catch(Exception e) {
			
			throw new RuntimeException("Não é possível excluir essa passagem");
		}
		
		
	}
	
	
}


