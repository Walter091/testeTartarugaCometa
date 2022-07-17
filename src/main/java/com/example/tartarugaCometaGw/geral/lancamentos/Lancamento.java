package com.example.tartarugaCometaGw.geral.lancamentos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lancamento")
public class Lancamento implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_LANCAMENTO")
	private Long id;
	
	@Column(name = "ID_PRODUTO")
	private Long produto;
	
	@Column(name = "ID_REMETENTE")
	private Long remetente;
	
	@Column(name = "ID_DESTINATARIO")
	private Long destinatario;
		
	@Column(name = "IND_STATUS_LANCAMENTO")
	private int statusLancamento = 1;
	
	// -----------------------------------------------------------
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProduto() {
		return produto;
	}

	public void setProduto(Long produto) {
		this.produto = produto;
	}

	public Long getRemetente() {
		return remetente;
	}

	public void setRemetente(Long remetente) {
		this.remetente = remetente;
	}

	public Long getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Long destinatario) {
		this.destinatario = destinatario;
	}

	public int getStatusLancamento() {
		return statusLancamento;
	}

	public void setStatusLancamento(int statusLancamento) {
		this.statusLancamento = statusLancamento;
	}
		
}
