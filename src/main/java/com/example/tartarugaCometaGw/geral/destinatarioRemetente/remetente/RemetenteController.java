package com.example.tartarugaCometaGw.geral.destinatarioRemetente.remetente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RemetenteController {
	
	@Autowired
	private ServicoRemetente servico;
	
	@GetMapping("/incluirRemetente")
	public String incluirRemetente(Model model) {
		return "cadastroRemetente";
	}
	
	@PostMapping("/salvarRemetente")
	public void salvarRemetente(@ModelAttribute("remetente")Remetente remetente) {
		servico.salvarRemetente(remetente);
	}
}
