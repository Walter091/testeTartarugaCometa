package com.example.tartarugaCometaGw.geral.destinatarioRemetente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_ENDERECO")
	private Integer id;
	
	@Column(name = "NOME_RUA")
	private String nomeRua;
	
	@Column(name = "NUMERO")
	private String numero;
	
	@Column(name = "BAIRRO")
	private String bairro;
	
	@Column(name = "MUNICIPIO")
	private String municipio;
	
	@Column(name = "UF")
	private String uf;
	
	// ------------------------------------------------------
	
	public String getNomeRua() {
		return nomeRua;
	}

	public void setNomeRua(String nomeRua) {
		this.nomeRua = nomeRua;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getMunicipio() {
		return municipio;
	}
	
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	
	public String getUf() {
		return uf;
	}
	
	public void setUf(String uf) {
		this.uf = uf;
	}
	
}
