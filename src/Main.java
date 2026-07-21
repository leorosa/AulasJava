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
		List<Produto> produtos;
		List<Cliente> clientes;
		List<Pedido> pedidos;
		List<ListaPedido> listaPedidos;
		while (true) {
			produtos = prodDao.consultar();
			clientes = cliDao.consultar();
			System.out.print("digite [c] para clientes, [p] para produtos, [n] para compras, ou outra tecla para sair: ");
			String modo = sc.nextLine();
			String opcao = "n";
			if (modo.equals("p")) {
				if (!produtos.isEmpty()) {
					System.out.print("PRODUTO: [n]ovo, [a]lterar, [l]istar, [L]istar todos, [r]emover: ");
					opcao = sc.nextLine();
				}
				if (opcao.equals("n")) {
					Produto prod = new Produto();
					prod.editar();
					prodDao.inserir(prod);
				} else if (opcao.equals("a")) {
					Produto prod = selectProd(produtos);
					if (prod!=null) {
						prod.editar();
						prodDao.alterar(prod);
					}
				} else if (opcao.equals("r")) {
					Produto prod = selectProd(produtos);
					if (prod!=null)
						prodDao.deletar(prod.getId());
				} else if (opcao.equals("l")) {
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
					System.out.print("CLIENTE: [n]ovo, [a]lterar, [l]istar, [L]istar todos, ou [r]emover: ");
					opcao = sc.nextLine();
				}
				if (opcao.equals("n")) {
					Cliente cli = new Cliente();
					cli.editar();
					cliDao.inserir(cli);
				} else if (opcao.equals("a")) {
					Cliente cli = selectCli(clientes);
					if (cli!=null) {
						cli.editar();
						cliDao.alterar(cli);
					}
				} else if (opcao.equals("r")) {
					Cliente cli = selectCli(clientes);
					if (cli!=null)
						cliDao.deletar(cli.getId());
				} else if (opcao.equals("l")) {
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
				Cliente cli = selectCli(clientes);
				PedidoDao pedDao = new PedidoDao();
				ListaPedidoDao lPedDao = new ListaPedidoDao();
				pedidos = pedDao.consultarCliente(cli.getId());
				Pedido ped = pedDao.consultarAberto(cli.getId());
				if (!pedidos.isEmpty()) {
					if (ped==null)
						System.out.print("PEDIDOS: [n]ovo, [l]istar, [L]istar todos: ");
					else
						System.out.print("PEDIDOS: [a]brir, [l]istar, [L]istar todos, [f]inalizar, ou [c]ancelar: ");
					opcao = sc.nextLine();
				}
				if (opcao.equals("f")) {
					if (ped!=null)
						ped.setIdStatus(2);
						pedDao.alterar(ped);
				} else if (opcao.equals("c")) {
					if (ped!=null)
						ped.setIdStatus(3);
						pedDao.alterar(ped);
				} else if (opcao.equals("l")) {
					ped = selectPed(pedidos);
					if (ped!=null) {
						ped.listar();
						listaPedidos = lPedDao.consultar(ped.getId());
						System.out.println("cliente: " + cli.getId() + ", pedido: " + ped.getId() + ", lista: " + listaPedidos.size());
						for(ListaPedido lPed : listaPedidos) {
							lPed.listar();
						}
					}
				} else if (opcao.equals("L")) {
					List<Pedido> lista = pedDao.consultar();
					for(Pedido pedd : lista) {
						pedd.listar();
					}
				} else {
					if (ped==null) {
						ped = new Pedido();
						ped.setIdCliente(selectCli(clientes).getId());
						java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
						ped.setData(sqlDate);
						ped.setIdStatus(1); // carrinho aberto
						pedDao.inserir(ped);
					}
					if (opcao.equals("a")||opcao.equals("n")) {
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
		int i = sc.nextInt();
		sc.nextLine(); // consome o "\n" que sobrou do Enter anterior
		for (Cliente cli : clientes) {
			if (i==cli.getId())
				return cli;
		}
		return null;
	}

	static Pedido selectPed(List<Pedido> pedidos) {
		for (Pedido ped : pedidos) {
			System.out.println(ped.getId() + ", cliente: " + ped.getIdCliente() + ", status: " +ped.getIdStatus());
		}
		int i = sc.nextInt();
		sc.nextLine(); // consome o "\n" que sobrou do Enter anterior
		for (Pedido ped : pedidos) {
			if (i==ped.getId())
				return ped;
		}
		return null;
	}
}
