package com.example.tartarugaCometaGw.geral.lancamentos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.tartarugaCometaGw.geral.destinatarioRemetente.destinatario.Destinatario;
import com.example.tartarugaCometaGw.geral.destinatarioRemetente.remetente.Remetente;
import com.example.tartarugaCometaGw.geral.produto.Produto;

@Entity
@Table(name = "lancamento")
public class Lancamento implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_LANCAMENTO")
	private Long id;
	
	@Column(name = "ID_PRODUTO")
	private Produto produto;
	
	@Column(name = "ID_REMETENTE")
	private Remetente remetente;
	
	@Column(name = "ID_DESTINATARIO")
	private Destinatario destinatario;
		
	@Column(name = "IND_STATUS_LANCAMENTO")
	private int statusLancamento;
	
	// -----------------------------------------------------------
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public Remetente getRemetente() {
		return remetente;
	}
	
	public void setRemetente(Remetente remetente) {
		this.remetente = remetente;
	}
	
	public Destinatario getDestinatario() {
		return destinatario;
	}
	
	public void setDestinatario(Destinatario destinatario) {
		this.destinatario = destinatario;
	}

	public int getStatusLancamento() {
		return statusLancamento;
	}

	public void setStatusLancamento(int statusLancamento) {
		this.statusLancamento = statusLancamento;
	}
}
