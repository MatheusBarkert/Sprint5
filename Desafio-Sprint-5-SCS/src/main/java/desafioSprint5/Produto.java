package desafioSprint5;

import java.util.List;

public class Produto {

	private double preco;
	private String descricao;

	public Produto() {// <-------- ainda preciso analisar pra ver se posso tirar esse contrutor
	}

	public Produto(String descricao, double preco) {
		this.descricao = descricao;
		this.preco = preco;
	}

	// -----------------------------------------------------------------
	public String getDescricao() {
		return descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	// -----------------------------------------------------------------
	@Override
	public String toString() {
		return "Descrição: " + this.descricao + " Preço: R$ " + this.preco;
	}

	// analisar melhor para ver se nao pode ser posto em outro lugar
	public boolean verificaProdutoExistente(String descricaoProduto, List<Produto> lstProdutos) {

		for (Produto produto : lstProdutos) {
			if (produto.getDescricao().equals(descricaoProduto)) {
				return true;
			}
		}

		return false;
	}
	
	public void alteraAtributosProduto(String descricao, List<Produto> lstProdutos, double preco) {
		
		for (Produto produto : lstProdutos) {
			if (produto.getDescricao().equals(descricao)) {
				produto.setPreco(preco);
			}
		}
		
		
		
	}
	
	public Produto retornaProduto(Produto produto) {
		
		return produto;	
		
	}

}
