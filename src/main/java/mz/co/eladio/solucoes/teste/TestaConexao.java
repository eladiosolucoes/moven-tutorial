package mz.co.eladio.solucoes.teste;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mz.co.eladio.solucoes.dao.ProdutoDao;
import mz.co.eladio.solucoes.model.Produto;
import mz.co.eladio.solucoes.util.Conexao;

public class TestaConexao {

	public static void main(String args[]) {

		buscar();
	}

	public static void testar() {

		try {
			Conexao conexao = new Conexao();

			conexao.getConexao();

			System.out.println("Sucesso");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();

			System.out.println("Erro " + e.getMessage());
		}
	}

	public static void Inserir() {

		try {
			
			Produto p = new Produto();
			
			p.setNome("Milho");
			p.setQuantidade(250);
			p.setPreco(1800);
			p.setDataValidade(new Date());
			p.setDataCadastro(new Date());
		
			ProdutoDao dao = new ProdutoDao();
			
			dao.inserir(p);

			System.out.println("Sucesso");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();

			System.out.println("Erro " + e.getMessage());
		}
	}
	
	
	public static void eliminar(){
		
		ProdutoDao dao = new ProdutoDao();
		
		//dao.excluir(4);
	}
	
	
	public static void buscar(){
		
		List<Produto> produtos = new ArrayList<Produto>();
		
		ProdutoDao dao = new ProdutoDao();
		
		
		//produtos = dao.buscarTodos();
		
		for(int i = 0; i < produtos.size(); i ++){
			
			System.out.println("ID: " +produtos.get(i).getId());
			System.out.println("Nome: " +produtos.get(i).getNome());
			System.out.println("Quantidade: " +produtos.get(i).getQuantidade());
			System.out.println("Preco: " +produtos.get(i).getPreco());
			System.out.println("Data Validade: " +produtos.get(i).getDataValidade());
			
			System.out.println("------------------------------------------");
			
			
		}
		
	}

}
