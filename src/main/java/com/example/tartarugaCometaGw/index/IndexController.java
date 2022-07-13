package com.example.tartarugaCometaGw.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/entrar")
	public String index() {
		return "index";
	}

	@GetMapping("/incluirDestinatario")
	public String incluirDestinatario() {
		return "/dr/cadastroDestinatario";
	}

	@GetMapping("/incluirRemetente")
	public String incluirRemetente() {
		return "/dr/cadastroRemetente";
	}

	@GetMapping("/incluirProduto")
	public String incluirProduto() {
		return "/tp/cadastroProduto";
	}
		
	
}
