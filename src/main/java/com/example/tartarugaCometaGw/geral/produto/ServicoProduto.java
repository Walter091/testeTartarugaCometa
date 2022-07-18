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
		Long id = repositorio.obterPelosCampos(obj.getNome(), obj.getValor());
		Optional<Produto> pr = repositorio.findById(id);
		pr.get().setNome(obj.getNome());
		pr.get().setPeso(obj.getPeso());
		pr.get().setVolume(obj.getVolume());
		pr.get().setValor(obj.getValor());
		repositorio.save(pr.get());
	}
	
	// -----------------------------------------------------------------------------
	
	public Optional<Produto> getProdutoPorId(Long id){
		return repositorio.findById(id);
	}
	
}
