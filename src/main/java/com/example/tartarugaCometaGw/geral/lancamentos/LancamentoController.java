package com.example.tartarugaCometaGw.geral.lancamentos;

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
	
	@SuppressWarnings("unused")
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

		String msgErro = servico.getERRO();
		model.addAttribute("msgError", msgErro);
	
		return "geral/lc/cadastroLancamento";
	}
	
	@PostMapping("/salvarLancamento")
	public String salvarlancamento(@ModelAttribute("lancamento") Lancamento lancamento, Model model) {
		if (!servico.salvar(lancamento)) {
			String msgErro = servico.getERRO();
			model.addAttribute("msgError", msgErro);
			
			return "redirect:/incluirLancamento";
		} 
		
		return "redirect:/vizualizarLancamento";
	}
	
	@GetMapping("/indexLancamento/alterar/{id}")
	public String alterarLancamento(@PathVariable("id") Long id, Model model) {
		status = StatusFormularioEnum.ALTERAR;
		Optional<Lancamento> lancOptional = servico.getLancamentoPorId(id);
		if (lancOptional.isEmpty()) {
			throw new IllegalArgumentException("Lançamento Inválido");
		}
		servico.alterar(lancOptional.get());
		model.addAttribute("lancamento", lancOptional);
		return "redirect:/vizualizarLancamento";

	}

	@GetMapping("/indexLancamento/excluir/{id}")
	public String excluirLancamento(@PathVariable("id") Long id, Model model) {
		status = StatusFormularioEnum.EXCLUIR;
		Optional<Lancamento> obj = servico.getLancamentoPorId(id);
		if (obj.isEmpty()) {
			throw new IllegalArgumentException("Lançamento Inválido");
		}
		
		servico.excluir(obj);
		return "redirect:/vizualizarLancamento";
	}

}
