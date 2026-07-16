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

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		if (cpf.length()>0)
			this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if (nome.length()>0)
			this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if (email.length()>0)
			this.email = email;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		if (rua.length()>0)
			this.rua = rua;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		if (numero>0) // nao ha nada gratis
			this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		if (bairro.length()>0)
			this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		if (cep.length()>0)
			this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		if (cidade.length()>0)
			this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		if (estado.length()==2)
			this.estado = estado;
		else
			System.out.println("use código de duas letras para estado");
	}

	public void listar() {
		System.out.println(this.getId() + " - " + this.getNome() + " " + this.getEmail());
	}
	public void editar() {
		Scanner sc = new Scanner(System.in);
		System.out.print("CPF: ");
		this.setCpf(sc.nextLine());
		System.out.print("nome: ");
		this.setNome(sc.nextLine());
		System.out.print("e-mail: ");
		this.setEmail(sc.nextLine());
		System.out.print("rua: ");
		this.setRua(sc.nextLine());
		System.out.print("numero: ");
		this.setNumero(sc.nextInt());
		sc.next(); // consumir nova linha ignorada por nextInt()
		System.out.print("bairro: ");
		this.setBairro(sc.nextLine());
		System.out.print("CEP: ");
		this.setCep(sc.nextLine());
		System.out.print("cidade: ");
		this.setCidade(sc.nextLine());
		System.out.print("estado: ");
		this.setEstado(sc.nextLine());
//		sc.close();
	}
}
