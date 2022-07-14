package com.example.tartarugaCometaGw.geral.destinatarioRemetente.remetente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoRemetente {

	@Autowired
	private RepositorioRemetente repositorio;
	
	public void salvarRemetente(Remetente obj) {
		repositorio.salvarRemetente(obj.getId(), obj.getCnpjCnpf(), obj.getNome(), obj.getRazaoSocial());
	}
}
