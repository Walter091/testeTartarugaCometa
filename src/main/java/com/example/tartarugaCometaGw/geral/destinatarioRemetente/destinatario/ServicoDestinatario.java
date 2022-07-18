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
				Long id = repositorio.obterPelosCampos(obj.getCnpj(), obj.getCpf());
				Optional<Destinatario> ds = repositorio.findById(id);
				ds.get().setCnpj(obj.getCnpj());
				ds.get().setCpf(obj.getCpf());
				ds.get().setEndereco(obj.getEndereco());
				ds.get().setRazaoSocial(obj.getRazaoSocial());
				ds.get().setNome(obj.getNome());
				repositorio.save(ds.get());
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
		Validation vl = new Validation();
		if (obj.getCnpj() != null) {
			if((vl.isCNPJ(obj.getCnpj()))) {
				setERRO("CNPJ INVÁLIDO");
				return false;
			}
		} else if (obj.getCpf() != null) {
				if (!vl.isValidCpf(obj.getCpf())) {
					setERRO("CPF INVÁLIDO");
					return false;
				}
		}
		return true;
	}
	
	public boolean doAntesDeSalvar(Destinatario obj) {
		if (!validarCnpj(obj.getCnpj()) && validarCpf(obj.getCpf())) {
			return false;
		}
		return true;
	}
		
	// --------------------------------------------------------------
	
	public boolean validarCnpj(String cnpj) {
		Validation vl = new Validation();
		if (cnpj != null) {
			if((vl.isCNPJ(cnpj))) {
				setERRO("CNPJ INVÁLIDO");
				return false;
			} else if (repositorio.validarCnpjRepetido(cnpj) != null) {
				setERRO("CNPJ JÁ CADASTRADO");
				return false;
			}
		}
		return true;
	}
	
	public boolean validarCpf(String cpf) {
		Validation vl = new Validation();
		if (cpf != null) {
			if (!vl.isValidCpf(cpf)) {
				setERRO("CPF INVÁLIDO");
				return false;			
			} else if (repositorio.validarCpfRepetido(cpf) != null) {
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
