package com.example.tartarugaCometaGw.geral.destinatarioRemetente.destinatario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DestinatarioController {
	
	@Autowired
	private ServicoDestinatario servico;
	
	@GetMapping("/incluirDestinatario")
	public String incluirDestinatario() {
		return "/geral/dr/cadastroDestinatario";
	}
	
	@PostMapping("/salvarDestinatario")
	public void salvarDestinatario(@ModelAttribute("destinatario")Destinatario destinatario) {
		servico.salvarDestinatario(destinatario);
	}
}
