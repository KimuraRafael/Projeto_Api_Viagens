package com.ifsp.trabalhoAPI.models;


import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
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
@Table(name = "Passagens")
public class Passagens {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", unique = true)
	private long id; 
	
	
	@Column(name = "valor_passagem")
	private BigDecimal valor; 
	
	@Column(name = "origem_viagem")
	private String origem;
	
	@Column(name = "destino_viagem")
	private String destino;
	
	@Column(name = "Data_Inicio")
	private LocalDateTime data_inicio;
	
	@Column(name = "Data_Fim")
	private LocalDateTime data_fim;
	
	@ManyToOne
	@JoinColumn(name = "id_viagem")	
	private Viagem viagem;
	
	
	public Passagens() {
		
	}
	
	public Passagens(long id, BigDecimal valor, String origem, String destino, LocalDateTime data_inicio,
			LocalDateTime data_fim, Viagem viagem) {
		super();
		this.id = id;
		this.valor = valor;
		this.origem = origem;
		this.destino = destino;
		this.data_inicio = data_inicio;
		this.data_fim = data_fim;
		this.viagem = viagem;
	}
	
	
	
	public long getId() {
		return id;
	}

	@Deprecated
	public void setId(long id) {
		this.id = id;
	}


	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public LocalDateTime getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(LocalDateTime data_inicio) {
		this.data_inicio = data_inicio;
	}

	public LocalDateTime getData_fim() {
		return data_fim;
	}

	public void setData_fim(LocalDateTime data_fim) {
		this.data_fim = data_fim;
	}

	public Viagem getViagem() {
		return viagem;
	}

	public void setViagem(Viagem viagem) {
		this.viagem = viagem;
	}


	
}
