package mz.co.eladio.solucoes.bean;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import mz.co.eladio.solucoes.dao.ProdutoDao;
import mz.co.eladio.solucoes.model.Produto;

@ManagedBean
@ViewScoped
public class CadastroProdutoBean {
	
	
	private Produto produto = new Produto();
	
	private ProdutoDao produtoDao = new ProdutoDao();
	
	
	
	public void salvar(){
		
		try {
			produto.setDataCadastro(new Date());
			
			this.produtoDao.inserir(produto);
			
			Messages.addGlobalInfo("Produto salvo com sucesso!");
			
			this.limpar();
			
		
		} catch (Exception e) {
			
			Messages.addGlobalError("Impossivel cadastrar o produto " + e.getMessage());
			e.printStackTrace();
			this.limpar();
		}
	}
	
	
	public Produto getProduto() {
		
		if(this.produto == null){
			this.produto = new Produto();
		}
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	private void limpar(){
		
		this.produto = new Produto();
	}
}
