package dao;

import interfaces.ICRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelos.ItemPedido;
import utils.ConectaDB;

public class ItemPedidoDao implements ICRUD<ItemPedido,Integer> {

//	@Override
	public ItemPedido inserir(ItemPedido iPed) {
		String sql = "insert into tb_items_pedido(id_pedido, id_produto, quantidade) values (?,?,?)";
		try {
			Connection con = ConectaDB.conectar();
			PreparedStatement stm = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			stm.setInt(1, iPed.getIdPedido());
			stm.setInt(2, iPed.getIdProduto());
			stm.setInt(3, iPed.getQuantidade());
			stm.execute();
			ResultSet rs = stm.getGeneratedKeys();
			if(rs.next()) {
				iPed.setId(rs.getInt(1));
			}
			rs.close();
			stm.close();
			con.close();
			return iPed;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

//	@Override
	public void deletar(Integer id) {
		String sql = "delete from tb_items_pedido where id=?";
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
	public void alterar(ItemPedido iPed) {
		String sql = "update tb_items_pedido set id_pedido=?, id_produto=?, quantidade=? where id=?"; // nao faz sentido alterar cliente...
		try {
			Connection con = ConectaDB.conectar();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, iPed.getIdPedido());
			stm.setInt(2, iPed.getIdProduto());
			stm.setInt(3, iPed.getQuantidade());
			stm.setInt(4, iPed.getId());
			stm.execute();
			stm.close();
			con.close();
			System.out.println("alterando pedido: " + iPed.getId());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public ItemPedido consultar(Integer id) {
		ItemPedido iPed = null;
		String sql = "select * from tb_items_pedido inner join tb_produtos on tb_produtos.id=tb_items_pedido.id_produto where id=?";
		try {
			Connection con = ConectaDB.conectar();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1,id);
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				iPed = new ItemPedido(rs.getInt("id"), rs.getInt("id_pedido"), rs.getInt("id_produto"), rs.getString("descricao"), rs.getInt("quantidade"));
			}
			rs.close();
			stm.close();
			con.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return iPed;
	}

	@Override
	public List<ItemPedido> consultar() {
		return null;
	}

	public List<ItemPedido> consultarPedido(Integer idPedido) {
		List<ItemPedido> lPed = new ArrayList<ItemPedido>();
		String sql = "select * from tb_items_pedido inner join tb_produtos on tb_produtos.id=tb_items_pedido.id_produto where id_pedido=?";
		try {
			Connection con = ConectaDB.conectar();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1,idPedido);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				ItemPedido pedItem = new ItemPedido(rs.getInt("id"), rs.getInt("id_pedido"), rs.getInt("id_produto"), rs.getString("descricao"), rs.getInt("quantidade"));
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
