package interfaces;

import java.util.List;

import modelos.Pig;

public interface ICRUD {
	Pig salvar(Pig pig);
	void deletar(int id);
	void alterar(Pig pig);
	Pig consultar(int id);
	List<Pig> consultar();
}

/*
 * D data
 * A access
 * O object
 * 
 * C criar
 * R remover
 * U update
 * D deletar
 */