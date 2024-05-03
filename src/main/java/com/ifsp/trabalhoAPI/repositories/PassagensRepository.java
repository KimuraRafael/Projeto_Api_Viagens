package com.ifsp.trabalhoAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifsp.trabalhoAPI.models.Passagens;
import java.util.List;


@Repository
public interface PassagensRepository extends JpaRepository<Passagens, Long>{
	

	
}
