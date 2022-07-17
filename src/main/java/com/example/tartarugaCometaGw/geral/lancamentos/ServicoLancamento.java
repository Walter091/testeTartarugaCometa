package com.example.tartarugaCometaGw.geral.lancamentos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tartarugaCometaGw.geral.destinatarioRemetente.destinatario.Destinatario;
import com.example.tartarugaCometaGw.geral.destinatarioRemetente.destinatario.RepositorioDestinatario;
import com.example.tartarugaCometaGw.geral.destinatarioRemetente.remetente.Remetente;
import com.example.tartarugaCometaGw.geral.destinatarioRemetente.remetente.RepositorioRemetente;
import com.example.tartarugaCometaGw.geral.produto.Produto;
import com.example.tartarugaCometaGw.geral.produto.RepositorioProduto;

@Service
public class ServicoLancamento {
	
	@Autowired
	private RepositorioLancamento repositorio;

	@Autowired
	private RepositorioProduto repositorioProduto;
	
	@Autowired
	private RepositorioRemetente repositorioRemetente;

	@Autowired
	private RepositorioDestinatario repositorioDestinatario;
		
	// -----------------------------------------------------------

	public void salvar(Lancamento obj) {
		repositorio.save(obj);
	}
	
	public void alterar(Lancamento obj) {
		repositorio.alterar(obj.getId(), obj.getProduto(), obj.getRemetente(), obj.getDestinatario(), obj.getStatusLancamento());		
	}

	public void excluir(Lancamento obj) {
		repositorio.delete(obj);
	}
	
	// -----------------------------------------------------------
	
	public Iterable<Lancamento> getLancamentos(){
		return repositorio.findAll();
	}

	public Optional<Lancamento> getLancamentoPorId(Long id){
		return repositorio.findById(id);
	}

	public Lancamento getLancamentoPorIdNQ(Long id){
		return repositorio.getByIdQN(id);
	}

	// -----------------------------------------------------------

	public Optional<Produto> getProduto(Long id) {
		return repositorioProduto.findById(id);
	}

	public Optional<Remetente> getRemetente(Long id) {
		return repositorioRemetente.findById(id);
	}

	public Optional<Destinatario> getDestinario(Long id) {
		return repositorioDestinatario.findById(id);
	}
	
	public Iterable<Produto> getListProdutos() {
		return repositorioProduto.findAll();
	}
	
	public Iterable<Remetente> getListRemetentes() {
		return repositorioRemetente.findAll();
	}

	public Iterable<Destinatario> getListDestinatarios() {
		return repositorioDestinatario.findAll();
	}

}
