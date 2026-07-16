import dao.ClienteDao;
import dao.ProdutoDao;
import java.util.List;
import java.util.Scanner;
import modelos.Produto;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		ProdutoDao prodDao = new ProdutoDao();
		List<Produto> produtos = prodDao.consultar();
		while (true) {
			if (produtos.size()==0)
				System.out.println("PRODUTO: [n]ovo ou [s]air");
			else
				System.out.println("PRODUTO: [n]ovo, [a]lterar, [l]istar, [L]istar todos, [r]emover ou [s]air");
			String opcao = sc.nextLine();
			if (opcao.equals("n")) {
				Produto prod = new Produto();
				prod.editar();
				prodDao.inserir(prod);
			} else if (opcao.equals("s")) {
				sc.close();
				break;
			} else if (produtos.size()==0) {
				continue;
			} else if (opcao.equals("a")) {
				int i = selectItem(produtos);
				Produto prod = produtos.get(i-1); // i-1 porque arrays iniciam em 0, enquanto tabelas iniciam em 1
				prod.editar();
				prodDao.alterar(prod);
			} else if (opcao.equals("r")) {
				int i = selectItem(produtos);
				prodDao.deletar(i);
				Produto prod = prodDao.consultar(i);
				if (prod!=null) {
					System.out.println(prod.getId() + " - " + prod.getDescricao() + " R$" + prod.getPreco());
				} else {
					System.out.println("Produto removido");
				}
			} else if (opcao.equals("l")) {
				int i = selectItem(produtos);
				Produto prod = prodDao.consultar(i);
				prod.listar();
			} else if (opcao.equals("L")) {
				List<Produto> lista = prodDao.consultar();
				for(Produto prod : lista) {
					prod.listar();
				}
			}
		}
	}

	static int selectItem(List<Produto> produtos) {
		int i = 1;
		for (Produto p : produtos) {
			System.out.println(i + " " + p.getDescricao());
			i++;
		}
		i = 0;
		while (i<1||i>produtos.size())
			i = sc.nextInt();
		sc.nextLine(); // consome o "\n" que sobrou do Enter anterior
		return i;
	}
}
