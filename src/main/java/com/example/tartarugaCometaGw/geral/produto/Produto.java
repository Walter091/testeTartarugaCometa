package com.example.tartarugaCometaGw.geral.produto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.tartarugaCometaGw.nucleo.utils.StringUtils;

@Entity
@Table(name = "produto")
public class Produto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PRODUTO")
	private Long id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "PESO")
	private Float peso;
	
	@Column(name = "VOLUME")
	private String volume;
	
	@Column(name = "VALOR")
	private Float valor;
	
	// ---------------------------------------------------------------------
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getValorFormatado() {
		return StringUtils.formatedDinheiro(valor);
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

}
