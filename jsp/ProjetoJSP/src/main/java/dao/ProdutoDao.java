package dao;

import java.util.ArrayList;
import java.util.List;
import modelos.Produto;

public class ProdutoDao {
	private static List<Produto> produtos = new ArrayList<>();
	public void salvar(Produto prod) {
		produtos.add(prod);
	}

	public List<Produto> consultar() {
		return produtos;
	}
}