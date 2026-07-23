package dao;

import java.util.ArrayList;
import java.util.List;
import modelos.Cliente;

public class ClienteDao {
	private static List<Cliente> clientes = new ArrayList<>();
	public void salvar(Cliente cli) {
		clientes.add(cli);
	}

	public List<Cliente> consultar() {
		return clientes;
	}
}