package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import interfaces.ICRUD;
import modelos.Produto;
import utils.ConectaDB;

public class ProdutoDao implements ICRUD {

	@Override
	public Produto inserir(Produto prod) {
		String sql = "insert into tb_produtos(descricao, preco) values (?,?)";
		try {
			Connection con = ConectaDB.conectar();
			PreparedStatement stm = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			stm.setString(1, prod.getDescricao());
			stm.setDouble(2, prod.getPreco());
			stm.execute();
			ResultSet rs = stm.getGeneratedKeys();
			if(rs.next()) {
				prod.setId(rs.getInt(1));
			}
			rs.close();
			stm.close();
			con.close();
			return prod;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void deletar(int id) {
		String sql = "delete from tb_produtos where id=?";
		try {
			Connection con = ConectaDB.conectar();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1,id);
			stmt.execute();
			stmt.close();
			con.close();
			System.out.println("deletando produto: " + id);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void alterar(Produto prod) {
		String sql = "update tb_produtos set descricao=?, preco=? where id=?";
		try {
			Connection con = ConectaDB.conectar();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, prod.getDescricao());
			stmt.setDouble(2, prod.getPreco());
			stmt.setInt(3, prod.getId());
			stmt.execute();
			stmt.close();
			con.close();
			System.out.println("alterando produto: " + prod.getId());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public Produto consultar(int id) {
		Produto produto = null;
		String sql = "select * from tb_produtos where id=?";
		try {
			Connection con = ConectaDB.conectar();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1,id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				produto = new Produto(rs.getInt("id"), rs.getString("descricao"), rs.getDouble("preco"));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return produto;
	}

	@Override
	public List<Produto> consultar() {
		List<Produto> produtos = new ArrayList<Produto>();
		try {
			Connection con = ConectaDB.conectar();
			PreparedStatement stmt = con.prepareStatement("select * from tb_produtos");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Produto p = new Produto(rs.getInt("id"), rs.getString("descricao"), rs.getDouble("preco"));
				produtos.add(p);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return produtos;
	}

}
