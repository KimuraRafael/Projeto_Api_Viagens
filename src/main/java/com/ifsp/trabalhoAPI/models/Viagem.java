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
	@Column(name = "id_viagen", unique = true)
	private long id_Viagem;
	
	@OneToMany
	@JoinColumn(name = "passagens_id", nullable = false)
	private Passagens passagens;
	
	@ManyToOne
	@JoinColumn(name = "veiculos_id", nullable = false)
	private Veiculos veiculos;

	private List<Veiculos> lista_Veiculos;
	
	private List<Passagens> lista_Passagens;

	public long getId_Viagem() {
		return id_Viagem;
	}

	public void setId_Viagem(long id_Viagem) {
		this.id_Viagem = id_Viagem;
	}

	public Passagens getPassagens() {
		return passagens;
	}

	public void setPassagens(Passagens passagens) {
		this.passagens = passagens;
	}

	public Veiculos getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(Veiculos veiculos) {
		this.veiculos = veiculos;
	}

	public List<Veiculos> getLista_Veiculos() {
		return lista_Veiculos;
	}

	public void setLista_Veiculos(List<Veiculos> lista_Veiculos) {
		this.lista_Veiculos = lista_Veiculos;
	}

	public List<Passagens> getLista_Passagens() {
		return lista_Passagens;
	}

	public void setLista_Passagens(List<Passagens> lista_Passagens) {
		this.lista_Passagens = lista_Passagens;
	}
	
	
	
}
