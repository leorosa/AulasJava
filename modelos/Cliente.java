package modelos;

import java.util.Scanner;

public class Cliente { // id, cpf, nome, email, rua, numero, bairro, cep, cidade e estado
	private int id;
	private String cpf;
	private String nome;
	private String email;
	private String rua;
	private int numero;
	private String bairro;
	private String cep;
	private String cidade;
	private String estado;
// no banco de dados MySQL:
//create table tb_clientes (
//	id int primary key auto_increment,
//    cpf varchar(14),
//    nome varchar(200),
//    email varchar(200),
//    rua varchar(200),
//    numero int,
//    bairro varchar(200),
//    cep varchar(9),
//    cidade varchar(200),
//    estado varchar(2)
//);

	public Cliente() {
	}
	public Cliente(String cpf, String nome, String email, String rua, int numero, String bairro, String cep, String cidade, String estado) {
		setCpf(cpf);
		setNome(nome);
		setEmail(email);
		setRua(rua);
		setNumero(numero);
		setBairro(bairro);
		setCep(cep);
		setCidae(cidade);
		setEstado(estado);
	}
	public Cliente(int id, String cpf, String nome, String email, String rua, int numero, String bairro, String cep, String cidade, String estado) {
		setId(id);
		setCpf(cpf);
		setNome(nome);
		setEmail(email);
		setRua(rua);
		setNumero(numero);
		setBairro(bairro);
		setCep(cep);
		setCidae(cidade);
		setEstado(estado);
	}

}
