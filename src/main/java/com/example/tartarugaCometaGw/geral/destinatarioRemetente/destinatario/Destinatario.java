package com.example.tartarugaCometaGw.geral.destinatarioRemetente.destinatario;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.tartarugaCometaGw.nucleo.utils.Validation;

@Entity
@Table(name = "destinatario")
public class Destinatario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_DESTINATARIO")
	private Long id;
	
	@Column(name = "CNPJ")
	private String cnpj;

	@Column(name = "CPF")
	private String cpf;
	
	@Column(name = "RAZAO_SOCIAL")
	private String razaoSocial;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "ENDERECO")
	private String endereco;
	
	// ----------------------------------------------------
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getCnpjFormatado() {
		return Validation.imprimeCNPJ(cnpj);
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getCpf() {
		return cpf;
	}

	public String getCpfFormatado() {
		return Validation.formatCPF(cpf);
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String toString() {
		return id + " | " + cnpj + " | " + cpf + " | " + razaoSocial +  " | " 
				+  nome + " | " + endereco;
		
	}
}
