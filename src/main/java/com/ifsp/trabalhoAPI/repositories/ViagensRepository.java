package com.ifsp.trabalhoAPI.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.ifsp.trabalhoAPI.models.Viagem;
import com.ifsp.trabalhoAPI.models.Passagens;
import com.ifsp.trabalhoAPI.models.Veiculos;



@Repository
public interface ViagensRepository extends JpaRepository<Viagem, Long> {
	
		List<Viagem> findById_Viagem(long id_Viagem);
	
		List<Viagem> findByLista_Passagens(List<Passagens> lista_Passagens);
		
		List<Viagem> findByLista_Veiculos(List<Veiculos> lista_Veiculos);
		
	

}
