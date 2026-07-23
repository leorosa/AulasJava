package dao;

import java.util.ArrayList;
import java.util.List;
import modelos.Contato;

public class ContatoDao {
	private static List<Contato> contatos = new ArrayList<>();
	public void salvar(Contato ct) {
		contatos.add(ct);
	}

	public List<Contato> consultar() {
		return contatos;
	}
}
