package dao;

import java.util.List;

import interfaces.ICRUD;
import modelos.Produto;
import utils.ConectaDB;

public class ProdutoDao implements ICRUD {

	@Override
	public Produto salvar(Produto prod) {
		if (ConectaDB.conectar() != null)
			System.out.println("conectado");
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
