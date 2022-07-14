package com.example.tartarugaCometaGw.geral.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoProduto {

	@Autowired
	private RepositorioProduto repositorioProduto;
	
	public void salvarProduto(Produto obj) {
		repositorioProduto.salvarDestinatario(obj.getId(), obj.getNome(), obj.getPeso(), obj.getVolume(), obj.getValor());
	}
}
