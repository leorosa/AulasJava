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
			System.out.println("opções: [n]ovo produto ou [s]air");
		else
			System.out.println("opções: [n]ovo produto, [a]lterar produto, [l]istar produto, [L]istar todos, [r]emover ou [s]air");
		String opcao = sc.nextLine();
		if (opcao.equals("n")) {
			Produto p = new Produto();
			editar(p);
			dao.inserir(p);
		} else if (opcao.equals("s")) {
			sc.close();
			break;
		} else if (produtos.size()==0) {
			continue;
		} else if (opcao.equals("a")) {
			int i = selectItem(produtos);
			dao.alterar(produtos.get(i));
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
			System.out.println(p.getId() + " - " + p.getDescricao() + " R$" + p.getPreco());
		} else if (opcao.equals("L")) {
			List<Produto> lista = dao.consultar();
			for(Produto p : lista) {
				System.out.println(p.getId() + " - " + p.getDescricao() + " R$" + p.getPreco());
			}
		}
	}

/*		Produto p1 = new Produto("Arroz", 10.85);
		Produto retorno = dao.inserir(p1);
//		System.out.println(retorno.getId() + " " + retorno.getDescricao());
//		dao.consultar();
		p1.setDescricao("Picanha");
		dao.alterar(p1);
		List<Produto> lista = dao.consultar();
		for(Produto p : lista) {
			System.out.println(p.getId() + " - " + p.getDescricao() + " R$" + p.getPreco());
		}
		System.out.println("---");
		Produto p = dao.consultar(3);
		System.out.println(p.getId() + " - " + p.getDescricao() + " R$" + p.getPreco());
*/
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

	static void editar(Produto produto) {
		System.out.print("descrição: ");
		produto.setDescricao(sc.nextLine());
		System.out.print("preço: ");
		produto.setPreco(sc.nextFloat());
	}

}
