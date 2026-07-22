package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import interfaces.ICRUD;
import modelos.Cliente;
import utils.ConectaDB;

public class ClienteDao implements ICRUD<Cliente,Integer> {

	@Override
	public Cliente inserir(Cliente cli) {
		String sql = "insert into tb_clientes(cpf, nome, email, rua, numero, bairro, cep, cidade, estado) values (?,?,?,?,?,?,?,?,?)";
		try {
			Connection con = ConectaDB.conectar();
			PreparedStatement stm = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			stm.setString(1, cli.getCpf());
			stm.setString(2, cli.getNome());
			stm.setString(3, cli.getEmail());
			stm.setString(4, cli.getRua());
			stm.setInt(5, cli.getNumero());
			stm.setString(6, cli.getBairro());
			stm.setString(7, cli.getCep());
			stm.setString(8, cli.getCidade());
			stm.setString(9, cli.getEstado());
			stm.execute();
			ResultSet rs = stm.getGeneratedKeys();
			if(rs.next()) {
				cli.setId(rs.getInt(1));
			}
			rs.close();
			stm.close();
			con.close();
			return cli;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void deletar(Integer id) {
		String sql = "delete from tb_clientes where id=?";
		try {
			Connection con = ConectaDB.conectar();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1,id);
			stm.execute();
			stm.close();
			con.close();
			System.out.println("deletando cliente: " + id);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void alterar(Cliente cli) {
		String sql = "update tb_clientes set cpf=?, nome=?, email=?, rua=?, numero=?, bairro=?, cep=?, cidade=?, estado=? where id=?";
		try {
			Connection con = ConectaDB.conectar();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, cli.getCpf());
			stm.setString(2, cli.getNome());
			stm.setString(3, cli.getEmail());
			stm.setString(4, cli.getRua());
			stm.setInt(5, cli.getNumero());
			stm.setString(6, cli.getBairro());
			stm.setString(7, cli.getCep());
			stm.setString(8, cli.getCidade());
			stm.setString(9, cli.getEstado());
			stm.setInt(10, cli.getId());
			stm.execute();
			stm.close();
			con.close();
			System.out.println("alterando cliente: " + cli.getId());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public Cliente consultar(Integer id) {
		Cliente cliente = null;
		String sql = "select * from tb_clientes where id=?";
		try {
			Connection con = ConectaDB.conectar();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1,id);
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				cliente = new Cliente(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome"), rs.getString("email"), rs.getString("rua"), rs.getInt("numero"), rs.getString("bairro"), rs.getString("cep"), rs.getString("cidade"), rs.getString("estado"));
			}
			rs.close();
			stm.close();
			con.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return cliente;
	}

	@Override
	public List<Cliente> consultar() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			Connection con = ConectaDB.conectar();
			PreparedStatement stm = con.prepareStatement("select * from tb_clientes");
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				Cliente cli = new Cliente(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome"), rs.getString("email"), rs.getString("rua"), rs.getInt("numero"), rs.getString("bairro"), rs.getString("cep"), rs.getString("cidade"), rs.getString("estado"));
				clientes.add(cli);
			}
			rs.close();
			stm.close();
			con.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return clientes;
	}

}
