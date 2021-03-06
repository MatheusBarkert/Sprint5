package desafioSprint5;

import java.util.Comparator;
import java.util.List;

public class Estoque implements Comparator<Produto> {

	private Produto produto;
	private int quantidade;
	
	public Estoque() {
		//preciso rever isso depois, ver se consigo fazer o programa sem o contrutor vazio
	}

	public Estoque(Produto produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}
	// -----------------------------------------------------------------
	public Produto getProduto() {
		return produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	// -----------------------------------------------------------------

	@Override
	public String toString() {

		return "Produto [ " + this.produto + " ] Quantidade: " + this.quantidade;
	}

	public void ajusteQuantidade(Produto produto, int quantidade) {

		if (this.produto.getDescricao().equals(produto.getDescricao())) {
			this.quantidade -= quantidade;
		}

	}

	public void adicionarQuantidadeAoProduto(Produto produto, int quantidade) {

		if (this.produto.getDescricao().equals(produto.getDescricao())) {
			this.quantidade += quantidade;
		}

	}

	@Override // <------------------------PRECISO VER MELHOR ESTE METODO
	public int compare(Produto produto1, Produto produto2) {

		if (produto1.getDescricao().equals(produto2.getDescricao())) {
			return 1;
		}

		return 0;
	}
	
	public void alteraAtributosEstoque(String descricao, List<Produto> lstProduto, int quantidade) {
		
		for (Produto produto : lstProduto) {
			if(produto.getDescricao().equals(this.produto.getDescricao())) {
				this.produto.setDescricao(produto.getDescricao());
				this.produto.setPreco(produto.getPreco());
				this.quantidade += quantidade;
			}
		}
		
	}

}
