package mz.co.eladio.solucoes.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mz.co.eladio.solucoes.model.Produto;
import mz.co.eladio.solucoes.util.Conexao;

public class ProdutoDao {

	public void inserir(Produto p) throws Exception {

			Conexao conexao = new Conexao();

			String sql = "INSERT INTO produto (nome, quantidade, preco, dataValidade, dataCadastro) value (?,?,?,?,?) ";

			PreparedStatement ps = conexao.getConexao().prepareStatement(sql);

			ps.setString(1, p.getNome());
			ps.setInt(2, p.getQuantidade());
			ps.setDouble(3, p.getPreco());
			ps.setDate(4, new Date(p.getDataValidade().getTime()));
			ps.setDate(5, new Date(p.getDataCadastro().getTime()));

			ps.execute();

		

	}
	
	
	public void editar (Produto p, int id) throws Exception{
		
	
			Conexao conexao = new Conexao();
			
			String sql = "UPDATE produto set nome=?, quantidade=?, preco=? , dataValidade=? where id =?";
			
			PreparedStatement ps = conexao.getConexao().prepareStatement(sql);
			
			ps.setString(1, p.getNome());
			ps.setInt(2, p.getQuantidade());
			ps.setDouble(3, p.getPreco());
			ps.setDate(4, new Date(p.getDataValidade().getTime()));
			ps.setInt(5, id);
			
			ps.execute();
			
		
	}
	
	

	public void excluir(int id) throws Exception{
		
		
			Conexao conexao = new Conexao();
			
			String sql = "DELETE from produto where id=?";
			PreparedStatement ps = conexao.getConexao().prepareStatement(sql);
			ps.setInt(1, id);
		
			ps.execute();
			
		
	}
	
	public List<Produto> buscarTodos() throws Exception {
		
		List<Produto> produtos = new ArrayList<>();
		

			Conexao conexao = new Conexao();
			String sql = "SELECT * from produto";
			
			PreparedStatement ps = conexao.getConexao().prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()){
				
				Produto p = new Produto();
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setQuantidade(rs.getInt("quantidade"));
				p.setPreco(rs.getDouble("preco"));
				p.setDataValidade(rs.getDate("dataValidade"));
				p.setDataCadastro(rs.getDate("dataCadastro"));
				
				produtos.add(p);
				
			}
			
		
		return produtos;
	}
	


}
