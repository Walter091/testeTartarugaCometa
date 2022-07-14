package com.example.tartarugaCometaGw.geral.produto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoProduto {

	@Autowired
	private RepositorioProduto repositorio;
	
	public void salvarProduto(Produto obj) {
		repositorio.salvarProduto(obj.getId(), obj.getNome(), obj.getPeso(), obj.getVolume(), obj.getValor());
	}
		
	public void alterar(Produto obj) {
		repositorio.alterar(obj.getId(), obj.getNome(), obj.getPeso(), obj.getVolume(), obj.getValor());
	}
	
	public void excluir(long id) {
		repositorio.excluir(id);
	}

	public Integer obterId() {
		return repositorio.obterId() == null ? 1 : repositorio.obterId()+1;
	}

	public List<Produto> obterListaProduto(){
		return repositorio.obterListaProduto() == null ? null : repositorio.obterListaProduto();
	}

	public Optional<Produto> getProdutoPorId(Long id){
		return repositorio.getById(id);
	}

	public Produto getProdutoPorIdNQ(Long id){
		return repositorio.getByIdQN(id);
	}
	

}
