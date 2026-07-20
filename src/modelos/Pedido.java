package modelos;

//import java.util.Scanner;
import java.sql.Date;

public class Pedido {
	private int id;
	private Date data;
	private int idStatus;
	private int idCliente;
// no banco de dados MySQL:
//      create table tb_pedidos(id int primary key auto_increment,data date,status int,constraint fk_status foreign key (status) references tb_status(id),cliente int,constraint fk_cliente foreign key (cliente) references tb_clientes(id));
//      create table tb_status ( id int primary key auto_increment, descricao varchar(100) );
//      insert into tb_status (descricao) values ("aberto");
//      insert into tb_status (descricao) values ("finalizado");
//      insert into tb_status (descricao) values ("cancelado");

	public Pedido() {
	}
	public Pedido(Date data, int idStatus, int idCliente) {
		setData(data);
		setStatus(idStatus);
		setCliente(idCliente);
	}
	public Pedido(int id, Date data, int idStatus, int idCliente) {
		setId(id);
		setData(data);
		setStatus(idStatus);
		setCliente(idCliente);
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
	public int getStatus() {
		return idStatus;
	}
	public void setStatus(int idStatus) {
		if (idStatus>0)
			this.idStatus = idStatus;
	}
	public int getCliente() {
		return idCliente;
	}
	public void setCliente(int idCliente) {
		if (idCliente>0)
			this.idCliente = idCliente;
	}

	public void listar() {
		System.out.println(this.getId() + " - " + this.getData() + this.getCliente() + " " + this.getStatus());
	}
}
