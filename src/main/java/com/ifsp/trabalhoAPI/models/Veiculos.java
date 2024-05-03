package com.ifsp.trabalhoAPI.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Veiculos")

public class Veiculos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_veiculo;
	
	@OneToMany
	private List<Passagens>assentos_disp;
	
	
	
	
	@Deprecated
	public Veiculos() {
		
	}


}
