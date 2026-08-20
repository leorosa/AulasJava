package com.aulaAPI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aulaAPI.entities.Produto;
import com.aulaAPI.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository repository;
	
	public Produto salvar(Produto produto) {
		if (produto.getDescricao().isEmpty()) {
			throw new RuntimeException("A descrição deve ser informada");
		}
		if (produto.getPreco()<0) {
			throw new RuntimeException("O preço não pode ser negativo");
		}
		if (produto.getEstoque()<0) {
			produto.setEstoque(1);
		}
		repository.save(produto);
		return produto;
	}
	
	public List<Produto> consultar() {
		return repository.findAll();
	}
	public Produto consultarUm(Long id) {
		Optional<Produto> opt = repository.findById(id);
		Produto prod = opt.orElseThrow(() -> new RuntimeException("produto não encontrado"));
		return prod;
	}
	public Produto alterar(Long id, Produto produto) {
		Produto prod = consultarUm(id);
		prod.setDescricao(produto.getDescricao());
		prod.setPreco(produto.getPreco());
		prod.setEstoque(produto.getEstoque());
		return repository.save(prod);
	}
	public void excluir(Long id) {
		repository.deleteById(id);
	}
}
