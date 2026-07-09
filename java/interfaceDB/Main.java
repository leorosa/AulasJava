import dao.ProdutoDao;
import modelos.Produto;

public class Main {

	public static void main(String[] args) {
		Produto p1 = new Produto("Milho", 20.85);
		ProdutoDao dao = new ProdutoDao();
		Produto retorno = dao.salvar(p1);
		System.out.println(retorno.getId() + " " + retorno.getDescricao());
	}

}
