package com.ifsp.trabalhoAPI.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Veiculo")

public class Veiculos {
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	

	@Column(name = "Descrição_Veículo")
	private String desricao;
	
	@Column(name = "Quantidade_Assentos")
	private short qtd_Assentos;
	
	
	@OneToMany(mappedBy = "veiculos") 
	private List<Viagem> viagem;
	
	@Deprecated
	public Veiculos() {
		
	}


}
