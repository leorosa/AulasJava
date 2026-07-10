package dao;

import java.util.List;

import interfaces.ICRUD;
import modelos.Produto;

public class ProdutoDao implements ICRUD {

	@Override
	public Produto salvar(Produto prod) {
		prod.setId(1);
		return prod;
	}

	@Override
	public void deletar(int id) {
		System.out.println("deletando produto: " + id);
	}

	@Override
	public void alterar(Produto prod) {
		System.out.println("alterando produto: " + prod.getId());
	}

	@Override
	public Produto consultar(int id) {
		return null;
	}

	@Override
	public List<Produto> consultar() {
		return null;
	}

}
