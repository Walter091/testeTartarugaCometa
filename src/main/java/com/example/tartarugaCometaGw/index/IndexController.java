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

//	@GetMapping("/entrar")
//	public String index() {
//		return "index";
//	}		
	
}
