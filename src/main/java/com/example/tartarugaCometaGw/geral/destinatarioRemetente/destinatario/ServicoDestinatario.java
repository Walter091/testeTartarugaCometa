package com.example.tartarugaCometaGw.geral.destinatarioRemetente.destinatario;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tartarugaCometaGw.nucleo.utils.Validation;

@Service
public class ServicoDestinatario {
	
	@Autowired
	private RepositorioDestinatario repositorio;
	
	public String ERRO = " ";
	
	public boolean salvarDestinatario(Destinatario obj) {
		try {
			if (doAntesDeSalvar(obj)) {
				repositorio.save(obj);
				return true;
			} 
			
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}
	
	public boolean alterar(Destinatario obj) {
		try {
			if (doAntesDeAlterar(obj)) {
				repositorio.alterar(obj.getId(), obj.getCnpj(), obj.getCpf(), obj.getRazaoSocial(), obj.getNome(), obj.getEndereco());
				return true;				
			}
			
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}
	
	public Optional<Destinatario> getDestinatarioPorId(Long id){
		return repositorio.findById(id);
	}

	// --------------------------------------------------------------
	
	public boolean doAntesDeAlterar(Destinatario obj) {
		if (repositorio.validarCnpjRepetido(obj.getCnpj()) != null) {
			setERRO("CNPJ JÁ CADASTRADO");
			return false;
		} else if (repositorio.validarCpfRepetido(obj.getCpf()) != null) {
			setERRO("CPF JÁ CADASTRADO");
			return false;
		}
		return true;
	}
	
	public boolean doAntesDeSalvar(Destinatario obj) {
		Validation vl = new Validation();
		if (obj.getCnpj() != null) {
			if((vl.isCNPJ(obj.getCnpj()))) {
				setERRO("CNPJ INVÁLIDO");
				return false;
			} else if (repositorio.validarCnpjRepetido(obj.getCnpj()) != null) {
				setERRO("CNPJ JÁ CADASTRADO");
				return false;
			}
		}
		if (obj.getCpf() != null) {
			if (!vl.isValidCpf(obj.getCpf())) {
				setERRO("CPF INVÁLIDO");
				return false;			
			} else if (repositorio.validarCpfRepetido(obj.getCpf()) != null) {
				setERRO("CPF JÁ CADASTRADO");
				return false;
			}
		}
		
		return true;
	}
	
	// --------------------------------------------------------------
	
	public String getERRO() {
		return ERRO;
	}

	public void setERRO(String eRRO) {
		ERRO = eRRO;
	}
	
}
