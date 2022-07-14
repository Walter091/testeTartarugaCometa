package com.example.tartarugaCometaGw.geral.destinatarioRemetente.destinatario;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.tartarugaCometaGw.geral.destinatarioRemetente.Endereco;
import com.example.tartarugaCometaGw.geral.lancamentos.Lancamento;

@Entity
@Table(name = "destinatario")
public class Destinatario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_DESTINATARIO")
	private Long id;
	
	@Column(name = "ID_LANCAMENTO")
	private Lancamento lancamento;
	
	@Column(name = "CNPJ_CNPF")
	private String cnpjCnpf;
	
	@Column(name = "RAZAO_SOCIAL")
	private String razaoSocial;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "ID_ENDERECO")
	private Endereco endereco;
	
	// ----------------------------------------------------
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
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
