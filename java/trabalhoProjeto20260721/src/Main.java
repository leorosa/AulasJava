import dao.ClienteDao;
import dao.ItemPedidoDao;
import dao.PedidoDao;
import dao.ProdutoDao;
import java.util.List;
import java.util.Scanner;
import modelos.Cliente;
import modelos.ItemPedido;
import modelos.Pedido;
import modelos.Produto;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		ProdutoDao prodDao = new ProdutoDao();
		ClienteDao cliDao = new ClienteDao();
		List<Produto> produtos;
		List<Cliente> clientes;
		List<Pedido> pedidos;
		List<ItemPedido> itemsPedido = null;
		while (true) {
			produtos = prodDao.consultar();
			clientes = cliDao.consultar();
			System.out.print("digite [c] para clientes, [p] para produtos, [n] para compras, ou outra tecla para sair: ");
			String modo = sc.nextLine();
			String opcao = "n";
			if (modo.equals("p")) {
				if (!produtos.isEmpty()) {
					System.out.print("PRODUTO: [n]ovo, [a]lterar, [l]istar, ou [r]emover: ");
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
					listarProd(produtos);
				}
			} else if (modo.equals("c")) {
				if (!clientes.isEmpty()) {
					System.out.print("CLIENTE: [n]ovo, [a]lterar, [l]istar, ou [r]emover: ");
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
					listarCli(clientes);
				}
			} else if (modo.equals("n")) {
				Cliente cli = selectCli(clientes);
				if (cli==null)
					continue;
				PedidoDao pedDao = new PedidoDao();
				ItemPedidoDao iPedDao = new ItemPedidoDao();
				pedidos = pedDao.consultarCliente(cli.getId());
				Pedido ped = pedDao.consultarAberto(cli.getId());
				if (!pedidos.isEmpty()) {
					if (ped==null)
						System.out.print("PEDIDOS: [n]ovo, [l]istar, [L]istar todos: ");
					else
						System.out.print("PEDIDOS: [a]brir, [l]istar, [L]istar todos, [f]inalizar, ou [c]ancelar: ");
					opcao = sc.nextLine();
				}
				if (opcao.equals("f")) { // somente fechar compra se houver estoque suficiente
					if (ped!=null)
						itemsPedido = iPedDao.consultarPedido(ped.getId());
						Boolean estoqueSuficiente = true;
						if (itemsPedido!=null) {
							for(ItemPedido iPed : itemsPedido) {
								Produto prod = prodDao.consultar(iPed.getIdProduto());
								if (iPed.getQuantidade()>prod.getEstoque()) {
									estoqueSuficiente = false;
									System.out.println("estoque insuficiente para " + prod.getDescricao() + ": " + iPed.getQuantidade() + " > " + prod.getEstoque());
								}
							}
						}
						if (!estoqueSuficiente)
							continue;
						if (itemsPedido!=null) {
							for(ItemPedido iPed : itemsPedido) {
								Produto prod = prodDao.consultar(iPed.getIdProduto());
								prod.setEstoque(prod.getEstoque() - iPed.getQuantidade());
								prodDao.alterar(prod);
							}
						}
						ped.setIdStatus(2);
						pedDao.alterar(ped);
				} else if (opcao.equals("c")) {
					if (ped!=null)
						ped.setIdStatus(3);
						pedDao.alterar(ped); // ou remover?
				} else if (opcao.equals("l")) {
					listarPed(pedidos);
				} else if (opcao.equals("L")) {
					List<Pedido> pedidosGeral = pedDao.consultar();
					if (pedidosGeral!=null)
						listarPed(pedidosGeral);
				} else { // abrir/novo
					if (ped==null) {
						ped = new Pedido();
						ped.setIdCliente(cli.getId());
						java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
						ped.setData(sqlDate);
						ped.setIdStatus(1); // carrinho aberto
						pedDao.inserir(ped);
					}
					if (opcao.equals("a")||opcao.equals("n")) {
						while (true) {
							itemsPedido = iPedDao.consultarPedido(ped.getId());
							System.out.print("ITEMS: [l]istar, [a]dicionar, [e]ditar, ou [r]emover: ");
							opcao = sc.nextLine();
							if(opcao.equals("a")) {
								ItemPedido iPed = null;
								Produto prod = selectProd(produtos);
								if (prod!=null) {
									for (ItemPedido itemPed : itemsPedido) { // checar se produto já está no carrinho
										if (prod.getId()==itemPed.getIdProduto())
											iPed=itemPed;
									}
									if (iPed==null) {
										iPed = new ItemPedido();
										iPed.setIdProduto(prod.getId());
										iPed.setIdPedido(ped.getId());
										iPedDao.inserir(iPed);
									}
									System.out.print("entre com a quantidade: ");
									int qtd = sc.nextInt();
									sc.nextLine(); // consumir linha ignorada por nextInt()
									iPed.setQuantidade(qtd);
									iPedDao.alterar(iPed);
								}
							} else if(opcao.equals("e")) {
								ItemPedido iPed = selectIPed(itemsPedido);
								if (iPed!=null) {
									System.out.print("entre com a quantidade: ");
									int qtd = sc.nextInt();
									sc.nextLine(); // consome o "\n" que sobrou do Enter anterior
									iPed.setQuantidade(qtd);
									iPedDao.alterar(iPed);
								}
							} else if(opcao.equals("r")) {
								ItemPedido iPed = selectIPed(itemsPedido);
								System.out.print("entre com a quantidade: ");
								if (iPed!=null)
									iPedDao.deletar(iPed.getId());
							} else if(opcao.equals("l")) {
								listarIPed(itemsPedido);
							} else {
								break;
							}
						}
					}
				}
			} else {
				sc.close();
				break;
			}
		}
	}

	static void listarProd(List<Produto> produtos) {
		for (Produto prod : produtos) {
			prod.listar();
		}
	}
	static Produto selectProd(List<Produto> produtos) {
		listarProd(produtos);
		int i = sc.nextInt();
		sc.nextLine(); // consome o "\n" que sobrou do Enter anterior
		for (Produto prod : produtos) {
			if (i==prod.getId())
				return prod;
		}
		return null;
	}

	static void listarCli(List<Cliente> clientes) {
		for (Cliente cli : clientes) {
			cli.listar();
		}
	}
	static Cliente selectCli(List<Cliente> clientes) {
		listarCli(clientes);
		int i = sc.nextInt();
		sc.nextLine(); // consome o "\n" que sobrou do Enter anterior
		for (Cliente cli : clientes) {
			if (i==cli.getId())
				return cli;
		}
		return null;
	}

	static void listarPed(List<Pedido> pedidos) {
		for (Pedido ped : pedidos) {
			ped.listar();
		}
	}
	static Pedido selectPed(List<Pedido> pedidos) {
		listarPed(pedidos);
		int i = sc.nextInt();
		sc.nextLine(); // consome o "\n" que sobrou do Enter anterior
		for (Pedido ped : pedidos) {
			if (i==ped.getId())
				return ped;
		}
		return null;
	}

	static void listarIPed(List<ItemPedido> itemsPedido) {
		for (ItemPedido iPed : itemsPedido) {
			iPed.listar();
		}
	}
	static ItemPedido selectIPed(List<ItemPedido> itemsPedido) {
		listarIPed(itemsPedido);
		int i = sc.nextInt();
		sc.nextLine(); // consome o "\n" que sobrou do Enter anterior
		for (ItemPedido iPed : itemsPedido) {
			if (i==iPed.getId())
				return iPed;
		}
		return null;
	}
}
