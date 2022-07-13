package com.example.tartarugaCometaGw.geral.lancamentos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tartarugaCometaGw.geral.destinatarioRemetente.destinatario.Destinatario;
import com.example.tartarugaCometaGw.geral.destinatarioRemetente.remetente.Remetente;
import com.example.tartarugaCometaGw.geral.transportadora.Produto;

@Service
public class ServicoLancamento {
	
	@Autowired
	private RepositorioLancamento repositorio;
	
	public void salvar(Lancamento obj) {
		repositorio.salvar(obj.getProduto().getId(), obj.getRemetente().getId(), obj.getDestinatario().getId());
	}
	
	public void alterar(Lancamento obj) {
		repositorio.alterar(obj.getId(), obj.getProduto().getId(), obj.getRemetente().getId(), obj.getDestinatario().getId());
	}
	
	public void excluir(Integer id) {
		repositorio.excluir(id);
	}
	// -----------------------------------------------------------
	
	public List<Produto> getListProdutos() {
		return repositorio.getListProdutos();
	}
	
	public List<Remetente> getListRemetentes() {
		return repositorio.getListRemetentes();
	}
	
	public List<Destinatario> getListDestinatarios() {
		return repositorio.getListDestinatarios();
	}
	
	public List<Lancamento> getLancamentos(){
		return (List<Lancamento>) repositorio.findAll();
	}
	
	public Optional<Lancamento> getLancamentoPorId(Integer id){
		return repositorio.getById(id);
	}

	public Lancamento getLancamentoPorIdNQ(Integer id){
		return repositorio.getByIdQN(id);
	}
		
}
