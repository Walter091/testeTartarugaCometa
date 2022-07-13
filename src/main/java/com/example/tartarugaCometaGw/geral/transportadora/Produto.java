package com.example.tartarugaCometaGw.geral.transportadora;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_DESTINATARIO")
	private Integer id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "PESO")
	private Float peso;
	
	@Column(name = "VOLUME")
	private String volume;
	
	@Column(name = "VALOR")
	private Float valor;
	
	// ---------------------------------------------------------------------
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Float getPeso() {
		return peso;
	}
	
	public void setPeso(Float peso) {
		this.peso = peso;
	}
	
	public String getVolume() {
		return volume;
	}
	
	public void setVolume(String volume) {
		this.volume = volume;
	}
	
	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}
	
}
