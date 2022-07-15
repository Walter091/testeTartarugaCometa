package com.example.tartarugaCometaGw.geral.destinatarioRemetente.destinatario;

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
public class DestinatarioController {
	
	@Autowired
	private ServicoDestinatario servico;
	
	private StatusFormularioEnum status;
	
	@GetMapping("/incluirDestinatario")
	public String incluirDestinatario(@ModelAttribute("destinatario")Destinatario destinatario, Model model) {
		model.addAttribute("idAuto", "O seu id é: " + servico.obterId());
		return "/geral/dr/cadastroDestinatario";
	}
	
	@GetMapping("/vizualizarDestinatario")
	public String vizualizarDestinatario(Model model) {
		model.addAttribute("listDestinatario", servico.obterListaDestinatarios());
		return "geral/dr/vizualizarDestinatarios";
	}
	
	@PostMapping("/salvarDestinatario")
	public String salvarDestinatario(@ModelAttribute("destinatario") Destinatario destinatario, Model model) {
		if (status == StatusFormularioEnum.ALTERAR) {
			if (servico.alterar(destinatario)) {
				return "redirect:/vizualizarDestinatario";
			} 
		}

		if (servico.salvarDestinatario(destinatario)) {
			return "redirect:/incluirLancamento";
		} 

		String msgErro = servico.getERRO();
		model.addAttribute("msgError", msgErro);
		return "/geral/dr/cadastroDestinatario";	
		
	}
	
	@GetMapping("indexDestinatario/alterar/{id}")
	public String alterarDestinatario(@PathVariable("id") Long id, Model model) {
		status = StatusFormularioEnum.ALTERAR;
		Optional<Destinatario> DestOptional = servico.getDestinatarioPorId(id);
		if (DestOptional.isEmpty()) {
			throw new IllegalArgumentException("Destinatario Inválido");
		}
		model.addAttribute("destinatario", DestOptional.get());
		
		return "/geral/dr/cadastroDestinatario";
	}

	@GetMapping("/indexDestinatario/excluir/{id}")
	public String excluirDestinatario(@PathVariable("id") Long id, Model model) {
		status = StatusFormularioEnum.EXCLUIR;
		Destinatario obj = servico.getDestinatarioPorIdNQ(id);
		if (obj == null) {
			throw new IllegalArgumentException("Destinatario Inválido");
		}
		
		servico.excluir(obj.getId());
		return "redirect:/vizualizarDestinatario";
	}
}
