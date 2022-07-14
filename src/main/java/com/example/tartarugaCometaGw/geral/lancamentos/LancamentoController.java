package com.example.tartarugaCometaGw.geral.lancamentos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.tartarugaCometaGw.geral.destinatarioRemetente.destinatario.Destinatario;
import com.example.tartarugaCometaGw.geral.destinatarioRemetente.remetente.Remetente;
import com.example.tartarugaCometaGw.geral.produto.Produto;
import com.example.tartarugaCometaGw.nucleo.StatusFormularioEnum;

@Controller
public class LancamentoController {
	
	@Autowired
	private ServicoLancamento servico;
	
	private StatusFormularioEnum status;
	
	@GetMapping("/vizualizarLancamento")
	public String vizualizarLancamento(Model model) {
		status = StatusFormularioEnum.VIZUALIZAR;
		model.addAttribute("listLancamentos", servico.getLancamentos());
		return "/geral/lc/vizualizarLancamentos";
	}
	
	@GetMapping("/incluirLancamento")
	public String lancamento(Model model) {
		status = StatusFormularioEnum.INCLUIR;
		List<Produto> lsProduto = servico.getListProdutos();
		model.addAttribute("listProdutos", lsProduto);

		List<Remetente> lsRemetente= servico.getListRemetentes();
		model.addAttribute("listRemetentes", lsRemetente);

		List<Destinatario> lsDestinatario = servico.getListDestinatarios();
		model.addAttribute("listDestinatarios", lsDestinatario);
		
		return "/geral/lc/cadastroLancamento";
	}
	
	
	@PostMapping("/salvarLancamento")
	public String Inserirlancamento(@ModelAttribute("lancamento")Lancamento lancamento) {
		if(status == StatusFormularioEnum.ALTERAR) {
			servico.alterar(lancamento);
		} else {
			servico.salvar(lancamento);
		}
		return "index";
	}
	
	@GetMapping("indexLancamento/alterar/{id}")
	public String alterarColaborador(@PathVariable("id") Integer id, Model model) {
		status = StatusFormularioEnum.ALTERAR;
		Optional<Lancamento> lancOptional = servico.getLancamentoPorId(id);
		if (lancOptional.isEmpty()) {
			throw new IllegalArgumentException("Lançamento Inválido");
		}
		model.addAttribute("lancamento", lancOptional.get());
		
		return "/lc/cadastroLancamento";
	}

	@GetMapping("/indexLancamento/excluir/{id}")
	public String excluirColaborador(@PathVariable("id") Integer id, Model model) {
		status = StatusFormularioEnum.EXCLUIR;
		Lancamento obj = servico.getLancamentoPorIdNQ(id);
		if (obj == null) {
			throw new IllegalArgumentException("Lançamento Inválido");
		}
		
		servico.excluir(obj.getId());
		return "redirect:/index";
	}

}
