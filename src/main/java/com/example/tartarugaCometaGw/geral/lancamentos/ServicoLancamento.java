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
	
	public String ERRO = " ";
		
	// -----------------------------------------------------------

	public boolean salvar(Lancamento obj) {
		if (getLancamentoRepetido(obj) != null) {
			setERRO("LANÇAMENTO JÁ CADASTRADO!!");
			return false;
		} else {
			repositorio.save(obj);
			return true;
		}
	}
	
	public void alterar(Lancamento obj) {
		Long id = repositorio.obterPelosCampos(obj.getDestinatario(), obj.getRemetente());
		Optional<Lancamento> ls = repositorio.findById(id);
		ls.get().setProduto(obj.getProduto());
		ls.get().setDestinatario(obj.getDestinatario());
		ls.get().setRemetente(obj.getRemetente());
		if (obj.getStatusLancamento() == 1) {
			ls.get().setStatusLancamento(0); 
		} else {
			ls.get().setStatusLancamento(1);
		}
		repositorio.save(ls.get());
	}

	public void excluir(Optional<Lancamento> obj) {
		repositorio.delete(obj.get());
	}
	
	// -----------------------------------------------------------
	
	public Iterable<Lancamento> getLancamentos(){
		return repositorio.findAll();
	}

	public Optional<Lancamento> getLancamentoPorId(Long id){
		return repositorio.findById(id);
	}

	public Lancamento getLancamentoRepetido(Lancamento obj){
		return repositorio.getLancamentoRepetido(obj.getRemetente(), obj.getDestinatario());
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

	// ---------------------------------------------------------------
	
	public String getERRO() {
		return ERRO;
	}

	public void setERRO(String erro) {
		ERRO = erro;
	}
	

}
