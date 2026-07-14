import java.util.List;

import dao.ProdutoDao;
import modelos.Produto;

public class Main {

	public static void main(String[] args) {
		ProdutoDao dao = new ProdutoDao();
/*		Produto p1 = new Produto("Arroz", 10.85);
		Produto retorno = dao.inserir(p1);
//		System.out.println(retorno.getId() + " " + retorno.getDescricao());
//		dao.consultar();
		p1.setDescricao("Picanha");
		dao.alterar(p1);
*/
		List<Produto> lista = dao.consultar();
		for(Produto p : lista) {
			System.out.println(p.getId() + " - " + p.getDescricao() + " R$" + p.getPreco());
		}
		System.out.println("---");
		Produto p = dao.consultar(3);
		System.out.println(p.getId() + " - " + p.getDescricao() + " R$" + p.getPreco());
	}

}
