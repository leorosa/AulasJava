package modelos;

//import java.util.Scanner;
import java.sql.Date;

public class Pedido {
	private int id;
	private Date data;
	private int idStatus;
	private int idCliente;
	private String nomeCliente;
//no banco de dados MySQL:
//create table tb_pedidos (
//    id int primary key auto_increment,
//    data date,
//    id_status int,
//    constraint fk_status foreign key (id_status) references tb_status(id),
//    id_cliente int,
//    constraint fk_cliente foreign key (id_cliente) references tb_clientes(id) );
//create table tb_status (
//    id int primary key auto_increment,
//    descricao varchar(100) );
//insert into tb_status (descricao) values ("aberto");
//insert into tb_status (descricao) values ("finalizado");
//insert into tb_status (descricao) values ("cancelado");

	public Pedido() {
	}
	public Pedido(Date data, int idStatus, int idCliente, String nomeCliente) {
		setData(data);
		setIdStatus(idStatus);
		setIdCliente(idCliente);
		setNomeCliente(nomeCliente);
	}
	public Pedido(int id, Date data, int idStatus, int idCliente, String nomeCliente) {
		setId(id);
		setData(data);
		setIdStatus(idStatus);
		setIdCliente(idCliente);
		setNomeCliente(nomeCliente);
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		if (id>0)
			this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
//		if (data!=null && data.length()>0)
			this.data = data;
	}
	public int getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(int idStatus) {
		if (idStatus>0)
			this.idStatus = idStatus;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		if (idCliente>0)
			this.idCliente = idCliente;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		if (nomeCliente!=null && nomeCliente.length()>0)
			this.nomeCliente = nomeCliente;
	}

	public void listar() {
		System.out.println(this.getId() + " - " + this.getData() + ", cliente: " + this.getNomeCliente() + ", status: " + this.getIdStatus());
	}
}
