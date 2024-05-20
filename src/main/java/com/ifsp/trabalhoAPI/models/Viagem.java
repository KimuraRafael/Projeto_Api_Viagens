package com.ifsp.trabalhoAPI.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Viagens")
public class Viagem {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_Viagem;
	
	@ManyToOne
	@JoinColumn(name = "passagens_id", nullable = false)
	private Passagens passagens;
	
	@ManyToOne
	@JoinColumn(name = "veiculos_id", nullable = false)
	private Veiculos veiculos;
	
}
