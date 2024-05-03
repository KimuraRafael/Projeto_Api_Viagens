package com.ifsp.trabalhoAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifsp.trabalhoAPI.models.Veiculos;

@Repository
public interface ViagensRepository extends JpaRepository<Veiculos, Long> {
	


}
