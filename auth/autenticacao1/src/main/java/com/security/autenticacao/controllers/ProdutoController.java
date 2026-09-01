package com.security.autenticacao.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {
	 @GetMapping("/publico") 
	    public String publico() { 
	        return "Endpoint público"; 
	    } 
	 
	    @GetMapping("/produtos") 
	    public String produtos() { 
	        return "Lista de produtos"; 
	    } 
	 
	    @GetMapping("/admin") 
	    public String admin() { 
	        return "Área administrativa"; 
	    }
}
