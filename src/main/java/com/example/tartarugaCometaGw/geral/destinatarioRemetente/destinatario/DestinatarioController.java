package com.example.tartarugaCometaGw.geral.destinatarioRemetente.destinatario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DestinatarioController {
	
	@Autowired
	private ServicoDestinatario servico;
	
	@GetMapping("/incluirDestinatario")
	public String incluirDestinatario(@ModelAttribute("destinatario")Destinatario destinatario, Model model) {
		model.addAttribute("idAuto", "O seu id é: " + servico.obterId());
		return "/geral/dr/cadastroDestinatario";
	}
	
	@GetMapping("/vizualizarDestinatario")
	public String vizualizarDestinatario(Model model) {
		model.addAttribute("listDestinatario", servico.obterListaDestinatarios());
		return "/geral/dr/vizualizarDestinatarios";
	}
	
	@PostMapping("/salvarDestinatario")
	public String salvarDestinatario(@ModelAttribute("destinatario") Destinatario destinatario, Model model) {
		if (servico.salvarDestinatario(destinatario)) {
			return "redirect:/geral/dr/vizualizarDestinatario";
		} else {
			String msgErro = servico.getERRO();
			model.addAttribute("msgError", msgErro);
			return "/geral/dr/cadastroDestinatario";	
		}
		
	}
}
