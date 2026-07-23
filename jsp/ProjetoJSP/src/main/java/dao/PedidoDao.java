package dao;

import java.util.ArrayList;
import java.util.List;
import modelos.Pedido;

public class PedidoDao {
	private static List<Pedido> pedidos = new ArrayList<>();
	public void salvar(Pedido ped) {
		pedidos.add(ped);
	}

	public List<Pedido> consultar() {
		return pedidos;
	}
}