import dao.ClienteDao;
import dao.ProdutoDao;
import java.util.List;
import java.util.Scanner;
import modelos.Cliente;
import modelos.Produto;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		ProdutoDao prodDao = new ProdutoDao();
		ClienteDao cliDao = new ClienteDao();
		List<Produto> produtos;
		List<Cliente> clientes;
		while (true) {
			produtos = prodDao.consultar();
			clientes = cliDao.consultar();
			System.out.println(produtos.size() + " " + clientes.size());
			System.out.println("digite [c] para clientes, [p] para produtos, ou [s] para sair");
			String modo = sc.nextLine();
			String opcao = "n";
			if (modo.equals("p")) {
				if (produtos.size()!=0) {
					System.out.println("PRODUTO: [n]ovo, [a]lterar, [l]istar, [L]istar todos, ou [r]emover");
					opcao = sc.nextLine();
				}
				if (opcao.equals("n")) {
					Produto prod = new Produto();
					prod.editar();
					prodDao.inserir(prod);
				} else if (opcao.equals("s")) {
					sc.close();
					break;
				} else if (opcao.equals("a")) {
					int i = selectProd(produtos);
					Produto prod = produtos.get(i-1); // i-1 porque arrays iniciam em 0, enquanto tabelas iniciam em 1
					prod.editar();
					prodDao.alterar(prod);
				} else if (opcao.equals("r")) {
					int i = selectProd(produtos);
					prodDao.deletar(i);
					Produto prod = prodDao.consultar(i);
					if (prod!=null) {
						System.out.println(prod.getId() + " - " + prod.getDescricao() + " R$" + prod.getPreco());
					} else {
						System.out.println("Produto removido");
					}
				} else if (opcao.equals("l")) {
					int i = selectProd(produtos);
					Produto prod = prodDao.consultar(i);
					prod.listar();
				} else if (opcao.equals("L")) {
					List<Produto> lista = prodDao.consultar();
					for(Produto prod : lista) {
						prod.listar();
					}
				}
			} else if (modo.equals("c")) {
				if (clientes.size()!=0) {
					System.out.println("CLIENTE: [n]ovo, [a]lterar, [l]istar, [L]istar todos, ou [r]emover");
					opcao = sc.nextLine();
				}
				if (opcao.equals("n")) {
					Cliente cli = new Cliente();
					cli.editar();
					cliDao.inserir(cli);
				} else if (opcao.equals("a")) {
					int i = selectCli(clientes);
					Cliente cli = clientes.get(i-1); // i-1 porque arrays iniciam em 0, enquanto tabelas iniciam em 1
					cli.editar();
					cliDao.alterar(cli);
				} else if (opcao.equals("r")) {
					int i = selectCli(clientes);
					cliDao.deletar(i);
					Cliente cli = cliDao.consultar(i);
					if (cli!=null) {
						System.out.println(cli.getId() + " - " + cli.getNome());
					} else {
						System.out.println("Cliente removido");
					}
				} else if (opcao.equals("l")) {
					int i = selectCli(clientes);
					Cliente cli = cliDao.consultar(i);
					cli.listar();
				} else if (opcao.equals("L")) {
					List<Cliente> lista = cliDao.consultar();
					for(Cliente cli : lista) {
						cli.listar();
					}
				}
			} else if (modo.equals("s")) {
				sc.close();
				break;
			}
		}
	}

	static int selectProd(List<Produto> produtos) {
		int i = 1;
		for (Produto prod : produtos) {
			System.out.println(i + " " + prod.getDescricao());
			i++;
		}
		i = 0;
		while (i<1||i>produtos.size())
			i = sc.nextInt();
		sc.nextLine(); // consome o "\n" que sobrou do Enter anterior
		return i;
	}

	static int selectCli(List<Cliente> clientes) {
		int i = 1;
		for (Cliente cli : clientes) {
			System.out.println(i + " " + cli.getNome());
			i++;
		}
		i = 0;
		while (i<1||i>clientes.size())
			i = sc.nextInt();
		sc.nextLine(); // consome o "\n" que sobrou do Enter anterior
		return i;
	}
}
