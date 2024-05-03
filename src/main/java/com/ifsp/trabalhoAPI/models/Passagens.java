package com.ifsp.trabalhoAPI.models;


import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;

@Entity
@Table(name = "Passagens")
public class Passagens {

	@Id
	private long id; 
	
	
	private boolean passDisponivel;
	
	private BigDecimal valor; 
	
	private String origem;
	
	private String destino;
	

	private LocalDateTime data_inicio;
	
	private LocalDateTime data_fim;
	
	@ManyToOne
	private Veiculos veiculos;
	
	
	public long getId() {
		return id;
	}

	@Deprecated
	public void setId(long id) {
		this.id = id;
	}

	public boolean isPassDisponivel() {
		return passDisponivel;
	}

	public void setPassDisponivel(boolean passDisponivel) {
		this.passDisponivel = passDisponivel;
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

	public Veiculos getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(Veiculos veiculos) {
		this.veiculos = veiculos;
	}
	
	
}
