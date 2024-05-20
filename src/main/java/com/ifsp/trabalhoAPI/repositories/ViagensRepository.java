package com.ifsp.trabalhoAPI.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.ifsp.trabalhoAPI.models.Viagem;

@Repository
public interface ViagensRepository extends JpaRepository<Viagem, Long> {
	
		List<Viagem> findByPassagens_id(Long id);
		List<Viagem> findByVeiculos_id(Long id);
		
	

}
