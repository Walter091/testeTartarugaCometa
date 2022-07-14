package com.example.tartarugaCometaGw.geral.destinatarioRemetente.destinatario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoDestinatario {
	
	@Autowired
	private RepositorioDestinatario repositorio;
	
	public void salvarDestinatario(Destinatario obj) {
		repositorio.salvarDestinatario(obj.getId(), obj.getCnpjCnpf(), obj.getRazaoSocial(), obj.getNome(), obj.getEndereco().getId());
	}
}
