package com.example.tartarugaCometaGw.geral.lancamentos;

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
	
	// -------------------------------------------------------------------

	@GetMapping("/vizualizarLancamento")
	public String vizualizarLancamento(Model model) {
		status = StatusFormularioEnum.VIZUALIZAR;
		model.addAttribute("listLancamentos", servico.getLancamentos());
		return "geral/lc/vizualizarLancamentos";
	}

	// -------------------------------------------------------------------

	@GetMapping("/incluirLancamento")
	public String inserirLancamento(@ModelAttribute("lancamento")Lancamento lancamento, Model model) {
		status = StatusFormularioEnum.INCLUIR;
		Iterable<Produto> lsProduto = servico.getListProdutos();
		model.addAttribute("listProdutos", lsProduto == null ? " " : lsProduto);

		Iterable<Remetente> lsRemetente= servico.getListRemetentes();
		model.addAttribute("listRemetentes", lsRemetente == null ? " " : lsRemetente);

		Iterable<Destinatario> lsDestinatario = servico.getListDestinatarios();
		model.addAttribute("listDestinatarios", lsDestinatario == null ? " " : lsDestinatario);
		
		return "geral/lc/cadastroLancamento";
	}
	
	@PostMapping("/salvarLancamento")
	public String salvarlancamento(@ModelAttribute("lancamento") Lancamento lancamento) {
		if(status == StatusFormularioEnum.ALTERAR) {
			servico.alterar(lancamento);
		} else {
			servico.salvar(lancamento);
		}
		return "redirect:/vizualizarLancamento";
	}
	
	@GetMapping("/indexLancamento/alterar/{id}")
	public String alterarLancamento(@PathVariable("id") Long id, Model model) {
		status = StatusFormularioEnum.ALTERAR;
		Lancamento lancOptional = servico.getLancamentoPorIdNQ(id);
		if (lancOptional == null) {
			throw new IllegalArgumentException("Lançamento Inválido");
		}
	
		model.addAttribute("lancamento", lancOptional);
		return "redirect:/incluirLancamento";

	}

	@GetMapping("/indexLancamento/excluir/{id}")
	public String excluirLancamento(@PathVariable("id") Long id, Model model) {
		status = StatusFormularioEnum.EXCLUIR;
		Lancamento obj = servico.getLancamentoPorIdNQ(id);
		if (obj == null) {
			throw new IllegalArgumentException("Lançamento Inválido");
		}
		
		servico.excluir(obj);
		return "redirect:/vizualizarLancamento";
	}

}
