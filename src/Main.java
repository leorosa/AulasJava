import dao.ClienteDao;
import dao.ProdutoDao;
import dao.PedidoDao;
import dao.ListaPedidoDao;
import java.util.List;
import java.util.Scanner;
import modelos.Cliente;
import modelos.Produto;
import modelos.Pedido;
import modelos.ListaPedido;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		ProdutoDao prodDao = new ProdutoDao();
		ClienteDao cliDao = new ClienteDao();
		PedidoDao pedDao = new PedidoDao();
		ListaPedidoDao lPedDao = new ListaPedidoDao();
		List<Produto> produtos;
		List<Cliente> clientes;
		List<Pedido> pedidos;
		List<ListaPedido> listaPedidos;
		while (true) {
			produtos = prodDao.consultar();
			clientes = cliDao.consultar();
			pedidos = pedDao.consultar();
			System.out.println("digite [c] para clientes, [p] para produtos, [n] para compras, ou outra tecla para sair");
			String modo = sc.nextLine();
			String opcao = "n";
			if (modo.equals("p")) {
				if (!produtos.isEmpty()) {
					System.out.println("PRODUTO: [n]ovo, [a]lterar, [l]istar, [L]istar todos, [r]emover");
					opcao = sc.nextLine();
				}
				if (opcao.equals("n")) {
					Produto prod = new Produto();
					prod.editar();
					prodDao.inserir(prod);
				} else if (opcao.equals("a")) {
//					int i = selectProd(produtos);
//					Produto prod = produtos.get(i-1); // i-1 porque arrays iniciam em 0, enquanto tabelas iniciam em 1
					Produto prod = selectProd(produtos);
					if (prod!=null) {
						prod.editar();
						prodDao.alterar(prod);
					}
				} else if (opcao.equals("r")) {
//					int i = selectProd(produtos);
//					prodDao.deletar(i);
					Produto prod = selectProd(produtos);
					if (prod!=null)
						prodDao.deletar(prod.getId());
//					Produto prod = prodDao.consultar(i);
//					if (prod!=null) {
//						System.out.println(prod.getId() + " - " + prod.getDescricao() + " R$" + prod.getPreco());
//					} else {
//						System.out.println("Produto removido");
//					}
				} else if (opcao.equals("l")) {
//					int i = selectProd(produtos);
//					Produto prod = prodDao.consultar(i);
					Produto prod = selectProd(produtos);
					prod.listar();
				} else if (opcao.equals("L")) {
					List<Produto> lista = prodDao.consultar();
					for(Produto prod : lista) {
						prod.listar();
					}
				}
			} else if (modo.equals("c")) {
				if (!clientes.isEmpty()) {
					System.out.println("CLIENTE: [n]ovo, [a]lterar, [l]istar, [L]istar todos, ou [r]emover");
					opcao = sc.nextLine();
				}
				if (opcao.equals("n")) {
					Cliente cli = new Cliente();
					cli.editar();
					cliDao.inserir(cli);
				} else if (opcao.equals("a")) {
//					int i = selectCli(clientes);
//					Cliente cli = clientes.get(i-1); // i-1 porque arrays iniciam em 0, enquanto tabelas iniciam em 1
					Cliente cli = selectCli(clientes);
					if (cli!=null) {
						cli.editar();
						cliDao.alterar(cli);
					}
				} else if (opcao.equals("r")) {
//					int i = selectCli(clientes);
//					cliDao.deletar(i);
					Cliente cli = selectCli(clientes);
					if (cli!=null)
						cliDao.deletar(cli.getId());
//					if (cli!=null) {
//						System.out.println(cli.getId() + " - " + cli.getNome());
//					} else {
//						System.out.println("Cliente removido");
//					}
				} else if (opcao.equals("l")) {
//					int i = selectCli(clientes);
//					Cliente cli = cliDao.consultar(i);
					Cliente cli = selectCli(clientes);
					if (cli!=null)
						cli.listar();
				} else if (opcao.equals("L")) {
					List<Cliente> lista = cliDao.consultar();
					for(Cliente cli : lista) {
						cli.listar();
					}
				}
			} else if (modo.equals("n")) {
				if (opcao.equals("n")) {
					Pedido ped = new Pedido();
					ped.setIdCliente(selectCli(clientes).getId());
					java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
					ped.setData(sqlDate);
					ped.setIdStatus(1); // carrinho aberto
					pedDao.inserir(ped);
					while (true) {
						System.out.print("tecle [p] para adicionar produto: ");
						if(!sc.nextLine().equals("p"))
							break;
						ListaPedido lPed = new ListaPedido();
						lPed.setIdPedido(ped.getId());
						lPed.setIdProduto(selectProd(produtos).getId());
						System.out.print("quantidade? ");
						int qtd = sc.nextInt();
						sc.nextLine(); // consumir linha ignorada por nextInt()
						lPed.setQuantidade(qtd);
						lPedDao.inserir(lPed);
					}
				}
			} else {
				sc.close();
				break;
			}
		}
	}

	static Produto selectProd(List<Produto> produtos) {
		for (Produto prod : produtos) {
			System.out.println(prod.getId() + " " + prod.getDescricao());
		}
//		i = 0;
//		while (i<1||i>produtos.size())
			int i = sc.nextInt();
		sc.nextLine(); // consome o "\n" que sobrou do Enter anterior
		for (Produto prod : produtos) {
			if (i==prod.getId())
				return prod;
		}
		return null;
	}

	static Cliente selectCli(List<Cliente> clientes) {
		for (Cliente cli : clientes) {
			System.out.println(cli.getId() + " " + cli.getNome());
		}
//		while (i<1||i>clientes.size())
			int i = sc.nextInt();
		sc.nextLine(); // consome o "\n" que sobrou do Enter anterior
		for (Cliente cli : clientes) {
			if (i==cli.getId())
				return cli;
		}
		return null;
	}

}
