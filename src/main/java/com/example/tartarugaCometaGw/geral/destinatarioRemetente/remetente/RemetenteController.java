package com.example.tartarugaCometaGw.geral.destinatarioRemetente.remetente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RemetenteController {
	
	@Autowired
	private ServicoRemetente servico;
	
	@GetMapping("/incluirRemetente")
	public String incluirRemetente(@ModelAttribute("remetente")Remetente remetente, Model model) {
		return "/geral/dr/cadastroRemetente";
	}
	
	@PostMapping("/salvarRemetente")
	public String salvarRemetente(@RequestBody Remetente remetente) {
		servico.salvarRemetente(remetente);
		return "index";
	}
}
