package com.example.tartarugaCometaGw.geral.destinatarioRemetente.remetente;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.tartarugaCometaGw.nucleo.StatusFormularioEnum;

@Controller
public class RemetenteController {
	
	@Autowired
	private ServicoRemetente servico;
	
	private StatusFormularioEnum status;
	
	@GetMapping("/incluirRemetente")
	public String incluirRemetente(@ModelAttribute("remetente")Remetente remetente, Model model) {
		return "geral/dr/cadastroRemetente";
	}
	
	@PostMapping("/salvarRemetente")
	public String salvarRemetente(@ModelAttribute("remetente") Remetente remetente, Model model) {
		if (status == StatusFormularioEnum.ALTERAR) {
			if (servico.alterar(remetente)) {
				return "redirect:/vizualizarLancamento";
			} 
		}
		if (servico.salvarRemetente(remetente)) {
			return "redirect:/incluirProduto";
		} 

		String msgErro = servico.getERRO();
		model.addAttribute("msgError", msgErro);
		return "/geral/dr/cadastroRemetente";	

	}

	@GetMapping("indexRemetente/alterar/{id}")
	public String alterarRemetente(@PathVariable("id") Long id, Model model) {
		status = StatusFormularioEnum.ALTERAR;
		Optional<Remetente> RemetenteOptional = servico.getRemetentePorId(id);
		if (RemetenteOptional.isEmpty()) {
			throw new IllegalArgumentException("Remetente Inválido");
		}
		model.addAttribute("remetente", RemetenteOptional.get());
		
		return "/geral/dr/cadastroRemetente";
	}

}
