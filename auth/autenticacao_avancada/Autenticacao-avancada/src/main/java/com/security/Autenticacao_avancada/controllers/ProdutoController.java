package com.security.Autenticacao_avancada.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.Autenticacao_avancada.entidades.Produto;
import com.security.Autenticacao_avancada.repositories.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	private final ProdutoRepository repository;

	public ProdutoController(ProdutoRepository repository) {

		this.repository = repository;
	}

	@PostMapping
	public Produto salvar(@RequestBody Produto produto) {

		return repository.save(produto);
	}

	@GetMapping
	public List<Produto> listar() {

		return repository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> consultar(@PathVariable Long id) {

		return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Produto> alterar(@PathVariable Long id, @RequestBody Produto produto) {

		return repository.findById(id).map(p -> {

			p.setDescricao(produto.getDescricao());

			p.setPreco(produto.getPreco());

			p.setEstoque(produto.getEstoque());

			return ResponseEntity.ok(repository.save(p));
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {

		if (!repository.existsById(id)) {

			return ResponseEntity.notFound().build();
		}

		repository.deleteById(id);

		return ResponseEntity.noContent().build();
	}
}