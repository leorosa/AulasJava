import dao.ProdutoDao;
import java.util.List;
import java.util.Scanner;
import modelos.Produto;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		ProdutoDao dao = new ProdutoDao();
		List<Produto> produtos = dao.consultar();
		while (true) {
			if (produtos.size()==0)
				System.out.println("PRODUTO: [n]ovo ou [s]air");
			else
				System.out.println("PRODUTO: [n]ovo, [a]lterar, [l]istar, [L]istar todos, [r]emover ou [s]air");
			String opcao = sc.nextLine();
			if (opcao.equals("n")) {
				Produto p = new Produto();
				p.editar();
				dao.inserir(p);
			} else if (opcao.equals("s")) {
				sc.close();
				break;
			} else if (produtos.size()==0) {
				continue;
			} else if (opcao.equals("a")) {
				int i = selectItem(produtos);
				Produto p = produtos.get(i-1); // i-1 porque arrays iniciam em 0, enquanto tabelas iniciam em 1
				p.editar();
				dao.alterar(p);
			} else if (opcao.equals("r")) {
				int i = selectItem(produtos);
				dao.deletar(i);
				Produto p = dao.consultar(i);
				if (p!=null) {
					System.out.println(p.getId() + " - " + p.getDescricao() + " R$" + p.getPreco());
				} else {
					System.out.println("Produto removido");
				}
			} else if (opcao.equals("l")) {
				int i = selectItem(produtos);
				Produto p = dao.consultar(i);
				p.listar();
			} else if (opcao.equals("L")) {
				List<Produto> lista = dao.consultar();
				for(Produto p : lista) {
					p.listar();
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
