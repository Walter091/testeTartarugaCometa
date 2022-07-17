package com.example.tartarugaCometaGw.geral.produto;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoProduto {
	
	@Autowired
	private RepositorioProduto repositorio;
	
	// -----------------------------------------------------------------------------
	
	public void salvarProduto(Produto obj) {
		repositorio.save(obj);
	}
		
	public void alterar(Produto obj) {
		repositorio.alterar(obj.getId(), obj.getNome(), obj.getPeso(), obj.getVolume(), obj.getValor());
	}
	
	// -----------------------------------------------------------------------------
	
	public Optional<Produto> getProdutoPorId(Long id){
		return repositorio.findById(id);
	}
	
}
