package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import interfaces.ICRUD;
import modelos.ListaPedido;
import utils.ConectaDB;

public class ListaPedidoDao implements ICRUD<ListaPedido,Integer> {

//	@Override
	public ListaPedido inserir(ListaPedido lPed) {
		String sql = "insert into lista_pedido(id_pedido, id_produto, quantidade) values (?,?,?)";
		try {
			Connection con = ConectaDB.conectar();
			PreparedStatement stm = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			stm.setInt(1, lPed.getIdPedido());
			stm.setInt(2, lPed.getIdProduto());
			stm.setInt(3, lPed.getQuantidade());
			stm.execute();
			ResultSet rs = stm.getGeneratedKeys();
			if(rs.next()) {
				lPed.setId(rs.getInt(1));
			}
			rs.close();
			stm.close();
			con.close();
			return lPed;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

//	@Override
	public void deletar(Integer id) {
		String sql = "delete from lista_pedido where id=?";
		try {
			Connection con = ConectaDB.conectar();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1,id);
			stm.execute();
			stm.close();
			con.close();
			System.out.println("deletando item: " + id);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

//	@Override
	public void alterar(ListaPedido lPed) {
		String sql = "update lista_pedido set id_pedido=?, id_produto=?, quantidade=? where id=?"; // nao faz sentido alterar cliente...
		try {
			Connection con = ConectaDB.conectar();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, lPed.getIdPedido());
			stm.setInt(2, lPed.getIdProduto());
			stm.setInt(3, lPed.getQuantidade());
			stm.setInt(4, lPed.getId());
			stm.execute();
			stm.close();
			con.close();
			System.out.println("alterando pedido: " + lPed.getId());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public ListaPedido consultar(Integer id) {
		ListaPedido lPed = null;
		String sql = "select * from lista_pedido where id=?";
		try {
			Connection con = ConectaDB.conectar();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1,id);
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				lPed = new ListaPedido(rs.getInt("id"), rs.getInt("id_pedido"), rs.getInt("id_produto"), rs.getInt("quantidade"));
			}
			rs.close();
			stm.close();
			con.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return lPed;
	}

	@Override
	public List<ListaPedido> consultar() {
		return null;
	}

	public List<ListaPedido> consultarPedido(Integer idPedido) {
		List<ListaPedido> lPed = new ArrayList<ListaPedido>();
		String sql = "select * from lista_pedido where id_pedido=?";
		try {
			Connection con = ConectaDB.conectar();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1,idPedido);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				ListaPedido pedItem = new ListaPedido(rs.getInt("id"), rs.getInt("id_pedido"), rs.getInt("id_produto"), rs.getInt("quantidade"));
				lPed.add(pedItem);
			}
			rs.close();
			stm.close();
			con.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return lPed;
	}

}
