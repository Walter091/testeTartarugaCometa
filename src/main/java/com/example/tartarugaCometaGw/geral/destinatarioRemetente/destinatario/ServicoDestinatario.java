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
			repositorio.alterar(obj.getId(), obj.getCnpjCnpf(), obj.getRazaoSocial(), obj.getNome(), obj.getEndereco());
			return true;
			
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}
	
	public void excluir(long id) {
		repositorio.deleteById(id);
	}

	public Integer obterId() {
		return repositorio.obterId()+1;
	}
	
	public Iterable<Destinatario> obterListaDestinatarios(){
		return repositorio.findAll();
	}
	
	public Optional<Destinatario> getDestinatarioPorId(Long id){
		return repositorio.findById(id);
	}

	public Destinatario getDestinatarioPorIdNQ(Long id){
		return repositorio.getByIdQN(id);
	}

	// --------------------------------------------------------------
	
	public boolean doAntesDeSalvar(Destinatario obj) {
		if((Validation.isCNPJ(obj.getCnpjCnpf()))) {
			setERRO("CNPJ INVÁLIDO");
			return false;
		} 
		if (repositorio.validarCnpjRepetido(obj.getCnpjCnpf()) != null) {
			setERRO("CNPJ Já CADASTRADO");
			return false;
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
