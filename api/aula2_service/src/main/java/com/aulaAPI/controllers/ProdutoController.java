package com.aulaAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulaAPI.entities.Produto;
import com.aulaAPI.services.ProdutoService;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

	//private List<Produto> produtos = new ArrayList<Produto>();
	@Autowired
	private ProdutoService service;

	@GetMapping
	public ResponseEntity<List<Produto>> getProdutos() {
		return ResponseEntity.status(HttpStatus.OK).body(service.consultar());
	}

	@GetMapping("/{id}") // sub-pasta?
	public ResponseEntity<?> getUmProduto(@PathVariable long id) {
//		Produto produto = service.consultarUm(id);
//		if (produto!=null)
//			return ResponseEntity.status(HttpStatus.OK).body(produto);
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Produto não encontrado");
		try {
			Produto produto = service.consultarUm(id);
			return ResponseEntity.status(HttpStatus.OK).body(produto);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Produto não encontrado");
		}
	}
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Produto produto) { // requestbody para pegar produto da requisicao
//		produto.setId(produtos.size()+1l);
//		produtos.add(produto);
		try {
			produto = service.salvar(produto);
			return ResponseEntity.status(HttpStatus.CREATED).body(produto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@PutMapping("/{id}") // sub-pasta?
	public ResponseEntity<?> alterar(@PathVariable long id, @RequestBody Produto produto) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.alterar(id, produto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
			
		}
	}

	@DeleteMapping("/{id}") // sub-pasta?
	public ResponseEntity<?> deletar(@PathVariable long id) {
		service.excluir(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
