package com.example.tartarugaCometaGw.geral.destinatarioRemetente.remetente;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tartarugaCometaGw.nucleo.utils.Validation;

@Service
public class ServicoRemetente {

	@Autowired
	private RepositorioRemetente repositorio;
	
	public String ERRO = " ";
	
	public boolean salvarRemetente(Remetente obj) {
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
	
	public boolean alterar(Remetente obj) {
		try {
			if (doAntesDeAlterar(obj)) {
				Long id = repositorio.obterPelosCampos(obj.getCnpj(), obj.getCpf());
				Optional<Remetente> rs = repositorio.findById(id);
				rs.get().setCnpj(obj.getCnpj());
				rs.get().setCpf(obj.getCpf());
				rs.get().setEndereco(obj.getEndereco());
				rs.get().setRazaoSocial(obj.getRazaoSocial());
				rs.get().setNome(obj.getNome());
				repositorio.save(rs.get());
				return true;
			}
			
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}
	
	public Optional<Remetente> getRemetentePorId(Long id){
		return repositorio.findById(id);
	}

	// --------------------------------------------------------------
	
	public boolean doAntesDeAlterar(Remetente obj) {
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
	
	public boolean doAntesDeSalvar(Remetente obj) {
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

	public void setERRO(String erro) {
		ERRO = erro;
	}
	
}
