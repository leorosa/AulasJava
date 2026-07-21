package modelos;

//import java.util.Scanner;
import java.sql.Date;

public class Pedido {
	private int id;
	private Date data;
	private int idStatus;
	private int idCliente;
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
	public Pedido(Date data, int idStatus, int idCliente) {
		setData(data);
		setIdStatus(idStatus);
		setIdCliente(idCliente);
	}
	public Pedido(int id, Date data, int idStatus, int idCliente) {
		setId(id);
		setData(data);
		setIdStatus(idStatus);
		setIdCliente(idCliente);
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

	public void listar() {
		System.out.println(this.getId() + " - " + this.getData() + ", cliente: " + this.getIdCliente() + ", status: " + this.getIdStatus());
	}
}
