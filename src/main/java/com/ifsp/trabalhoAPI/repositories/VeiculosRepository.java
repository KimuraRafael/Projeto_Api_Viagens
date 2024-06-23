package com.ifsp.trabalhoAPI.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifsp.trabalhoAPI.models.Veiculos;

@Repository
public interface VeiculosRepository extends JpaRepository<Veiculos, Long>{

}
