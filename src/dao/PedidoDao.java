package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import interfaces.ICRUD;
import modelos.Pedido;
import utils.ConectaDB;

public class PedidoDao implements ICRUD<Pedido,Integer> {

	@Override
	public Pedido inserir(Pedido ped) {
		String sql = "insert into tb_pedidos(data, id_status, id_cliente) values (?,?,?)";
		try {
			Connection con = ConectaDB.conectar();
			PreparedStatement stm = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			stm.setDate(1, ped.getData());
			stm.setInt(2, ped.getIdStatus());
			stm.setInt(3, ped.getIdCliente());
			stm.execute();
			ResultSet rs = stm.getGeneratedKeys();
			if(rs.next()) {
				ped.setId(rs.getInt(1));
			}
			rs.close();
			stm.close();
			con.close();
			return ped;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void deletar(Integer id) {
		String sql = "delete from tb_pedidos where id=?";
		try {
			Connection con = ConectaDB.conectar();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1,id);
			stm.execute();
			stm.close();
			con.close();
			System.out.println("deletando pedido: " + id);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void alterar(Pedido ped) {
		String sql = "update tb_pedidos set data=?, id_status=? where id=?"; // nao faz sentido alterar cliente...
		try {
			Connection con = ConectaDB.conectar();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setDate(1, ped.getData());
			stm.setInt(2, ped.getIdStatus());
			stm.setInt(3, ped.getId());
			stm.execute();
			stm.close();
			con.close();
			System.out.println("alterando pedido: " + ped.getId());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public Pedido consultar(Integer id) {
		Pedido ped = null;
		String sql = "select * from tb_pedidos where id=? inner join tb_clientes on tb_clientes.id=tb_pedidos.id_cliente";
		try {
			Connection con = ConectaDB.conectar();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1,id);
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				ped = new Pedido(rs.getInt("id"), rs.getDate("data"), rs.getInt("id_status"), rs.getInt("id_cliente")); //rs.getString("nome"), rs.getInt("quantidade"), rs.getFloat("preco"));
			}
			rs.close();
			stm.close();
			con.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return ped;
	}

	public List<Pedido> consultarCliente(Integer idCliente) {
		List<Pedido> pedidos = new ArrayList<Pedido>();
		String sql = "select * from tb_pedidos inner join tb_clientes on tb_clientes.id=tb_pedidos.id_cliente where id_cliente=?";
		try {
			Connection con = ConectaDB.conectar();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1,idCliente);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				Pedido ped = new Pedido(rs.getInt("id"), rs.getDate("data"), rs.getInt("id_status"), rs.getInt("id_cliente"), rs.getString("nome"));
				pedidos.add(ped);
			}
			rs.close();
			stm.close();
			con.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return pedidos;
	}

	public Pedido consultarAberto(Integer idCliente) {
		Pedido ped = null;
		String sql = "select * from tb_pedidos inner join tb_clientes on tb_clientes.id=tb_pedidos.id_cliente where id_cliente=? and id_status=1";
		try {
			Connection con = ConectaDB.conectar();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1,idCliente);
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				ped = new Pedido(rs.getInt("id"), rs.getDate("data"), 1, (int)idCliente, rs.getString("nome"));
			}
			rs.close();
			stm.close();
			con.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return ped;
	}

	@Override
	public List<Pedido> consultar() {
		List<Pedido> pedidos = new ArrayList<Pedido>();
		try {
			Connection con = ConectaDB.conectar();
			PreparedStatement stm = con.prepareStatement("select * from tb_pedidos");
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				Pedido ped = new Pedido(rs.getInt("id"), rs.getDate("data"), rs.getInt("id_status"), rs.getInt("id_cliente"));
				pedidos.add(ped);
			}
			rs.close();
			stm.close();
			con.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return pedidos;
	}

}
