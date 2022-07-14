package com.example.tartarugaCometaGw.geral.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProdutoController {
	
	@Autowired
	private ServicoProduto servicoProduto;
	
	@GetMapping("/incluirProduto")
	public String produto() {
		return "geral/tp/cadastroProduto";
	}
	
	@PostMapping("/salvarProduto")
	public void salvarProduto(@ModelAttribute("produto")Produto produto) {
		servicoProduto.salvarProduto(produto);
	}
}	
