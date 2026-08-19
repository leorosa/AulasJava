package com.aulaAPI.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("home")
public class HomeController {

	@GetMapping
	public String ola() {
		return "Ola mundo";
	}

}

/* Verbos do http
 * GET    http://localhost:8080/produtos ou http://localhost:8080/produtos/1
 * POST   http://localhost:8080/produtos
 * PUT    http://localhost:8080/produtos/1
 * DELETE http://localhost:8080/produtos/1
 * PATCH
 */