package com.example.tartarugaCometaGw.geral.produto;

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
public class ProdutoController {
	
	@Autowired
	private ServicoProduto servico;
	
	private StatusFormularioEnum status;
	
	@GetMapping("/incluirProduto")
	public String produto(@ModelAttribute("produto") Produto produto, Model model) {
		model.addAttribute("idAuto", "O seu id é: " + servico.obterId());
		return "geral/tp/cadastroProduto";
	}
		
	@GetMapping("/vizualizarProduto")
	public String vizualizarProduto(Model model) {
		model.addAttribute("listProduto", servico.obterListaProduto());
		return "geral/tp/vizualizarProduto";
	}
	
	@PostMapping("/salvarProduto")
	public String salvarProduto(@ModelAttribute("produto") Produto produto, Model model) {
		if (status == StatusFormularioEnum.ALTERAR) {
			servico.alterar(produto);
			return "redirect:/vizualizarProduto";
		} 
		servico.salvarProduto(produto);
		return "redirect:/vizualizarProduto";		
	}
	
	@GetMapping("indexProduto/alterar/{id}")
	public String alterarProduto(@PathVariable("id") Long id, Model model) {
		status = StatusFormularioEnum.ALTERAR;
		Optional<Produto> prodOptional = servico.getProdutoPorId(id);
		if (prodOptional.isEmpty()) {
			throw new IllegalArgumentException("Produto Inválido");
		}
		model.addAttribute("produto", prodOptional.get());
		
		return "/geral/tp/cadastroProduto";
	}

	@GetMapping("/indexProduto/excluir/{id}")
	public String excluirProduto(@PathVariable("id") Long id, Model model) {
		status = StatusFormularioEnum.EXCLUIR;
		Produto obj = servico.getProdutoPorIdNQ(id);
		if (obj == null) {
			throw new IllegalArgumentException("Produto Inválido");
		}
		
		servico.excluir(obj.getId());
		return "redirect:/vizualizarProduto";
	}

}	
