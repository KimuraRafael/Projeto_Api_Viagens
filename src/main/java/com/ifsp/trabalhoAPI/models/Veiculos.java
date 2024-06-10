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
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDesricao() {
		return desricao;
	}

	public void setDesricao(String desricao) {
		this.desricao = desricao;
	}

	public short getQtd_Assentos() {
		return qtd_Assentos;
	}

	public void setQtd_Assentos(short qtd_Assentos) {
		this.qtd_Assentos = qtd_Assentos;
	}

	public List<Viagem> getViagem() {
		return viagem;
	}

	public void setViagem(List<Viagem> viagem) {
		this.viagem = viagem;
	}

	@OneToMany(mappedBy = "veiculos") 
	private List<Viagem> viagem;
	
	@Deprecated
	public Veiculos() {
		
	}


}
