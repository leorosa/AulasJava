import dao.ClienteDao;
import dao.ListaPedidoDao;
import dao.PedidoDao;
import dao.ProdutoDao;
import java.util.List;
import java.util.Scanner;
import modelos.Cliente;
import modelos.ListaPedido;
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
		List<ListaPedido> itemsPedido = null;
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
				if (cli==null)
					continue;
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
				if (opcao.equals("f")) { // somente fechar compra se houver estoque suficiente
					if (ped!=null)
						itemsPedido = lPedDao.consultarPedido(ped.getId());
						Boolean estoqueSuficiente = true;
						if (itemsPedido!=null) {
							for(ListaPedido lPed : itemsPedido) {
								Produto prod = prodDao.consultar(lPed.getIdProduto());
								if (lPed.getQuantidade()>prod.getEstoque()) {
									estoqueSuficiente = false;
									System.out.println("estoque insuficiente para " + prod.getDescricao() + ": " + lPed.getQuantidade() + " > " + prod.getEstoque());
								}
							}
						}
						if (!estoqueSuficiente)
							continue;
						if (itemsPedido!=null) {
							for(ListaPedido lPed : itemsPedido) {
								Produto prod = prodDao.consultar(lPed.getIdProduto());
								prod.setEstoque(prod.getEstoque() - lPed.getQuantidade());
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
					ped = selectPed(pedidos);
					if (ped!=null) {
						ped.listar();
						itemsPedido = lPedDao.consultarPedido(ped.getId());
						System.out.println("cliente: " + cli.getNome() + ", pedido: " + ped.getId() + ", lista: " + itemsPedido.size() + " items");
						for(ListaPedido lPed : itemsPedido) {
							lPed.listar();
						}
					}
				} else if (opcao.equals("L")) {
					List<Pedido> pedidosGeral = pedDao.consultar();
					for(Pedido pedGeral : pedidosGeral) {
						pedGeral.listar();
					}
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
							itemsPedido = lPedDao.consultarPedido(ped.getId());
							System.out.print("ITEMS: [l]istar, [a]dicionar, [e]ditar, ou [r]emover: ");
							opcao = sc.nextLine();
							if(opcao.equals("a")) {
								ListaPedido lPed = null;
								Produto prod = selectProd(produtos);
								if (prod!=null) {
									for (ListaPedido itemPed : itemsPedido) { // checar se produto já está no carrinho
										if (prod.getId()==itemPed.getIdProduto())
											lPed=itemPed;
									}
									if (lPed==null) {
										lPed = new ListaPedido();
										lPed.setIdProduto(prod.getId());
										lPed.setIdPedido(ped.getId());
										lPedDao.inserir(lPed);
									}
									System.out.print("entre com a quantidade: ");
									int qtd = sc.nextInt();
									sc.nextLine(); // consumir linha ignorada por nextInt()
									lPed.setQuantidade(qtd);
									lPedDao.alterar(lPed);
								}
							} else if(opcao.equals("e")) {
								ListaPedido lPed = selectLPed(itemsPedido);
								if (lPed!=null) {
									System.out.print("entre com a quantidade: ");
									int qtd = sc.nextInt();
									sc.nextLine(); // consome o "\n" que sobrou do Enter anterior
									lPed.setQuantidade(qtd);
									lPedDao.alterar(lPed);
								}
							} else if(opcao.equals("r")) {
								ListaPedido lPed = selectLPed(itemsPedido);
								System.out.print("entre com a quantidade: ");
								if (lPed!=null)
									lPedDao.deletar(lPed.getId());
							} else if(opcao.equals("l")) {
								for (ListaPedido lPed : itemsPedido) {
									Produto prod = prodDao.consultar(lPed.getIdProduto());
									System.out.println(lPed.getId() + ", produto: " + prod.getDescricao() + ", quantidade: " + lPed.getQuantidade());
								}
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
			System.out.println(ped.getId() + ", status: " +ped.getIdStatus());
		}
		int i = sc.nextInt();
		sc.nextLine(); // consome o "\n" que sobrou do Enter anterior
		for (Pedido ped : pedidos) {
			if (i==ped.getId())
				return ped;
		}
		return null;
	}

	static ListaPedido selectLPed(List<ListaPedido> listaPedidos) {
		for (ListaPedido lPed : listaPedidos) {
			System.out.println(lPed.getId() + ", produto: " + lPed.getIdProduto() + ", quantidade: " + lPed.getQuantidade());
		}
		int i = sc.nextInt();
		sc.nextLine(); // consome o "\n" que sobrou do Enter anterior
		for (ListaPedido lPed : listaPedidos) {
			if (i==lPed.getId())
				return lPed;
		}
		return null;
	}
}
