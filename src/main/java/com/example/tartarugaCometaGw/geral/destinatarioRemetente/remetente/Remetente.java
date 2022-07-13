package com.example.tartarugaCometaGw.geral.destinatarioRemetente.remetente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.tartarugaCometaGw.geral.destinatarioRemetente.Endereco;

@Entity
@Table(name = "remetente")
public class Remetente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_REMETENTE")
	private Integer id;
	
	@Column(name = "CNPJ_CNPF")
	private String cnpjCnpf;
	
	@Column(name = "RAZAO_SOCIAL")
	private String razaoSocial;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "ID_ENDERECO")
	private Endereco endereco;
	
	// ----------------------------------------------------
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCnpjCnpf() {
		return cnpjCnpf;
	}
	
	public void setCnpjCnpf(String cnpjCnpf) {
		this.cnpjCnpf = cnpjCnpf;
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	
}
