package desafioSprint5;

import java.util.Comparator;

public class Estoque implements Comparator<Produto>{
	
	private Produto produto;
	private int quantidade;	
	
	public Estoque(Produto produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}
	
	public Produto getProduto() {
		return produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	
	@Override
	public String toString() {
		
		return "Produto [ " + this.produto + " ] Quantidade: " + this.quantidade;
	}
	
	public void ajusteQuantidade(Produto produto, int quantidade) {
		
		if(this.produto.getDescricao().equals(produto.getDescricao())) {
			this.quantidade -= quantidade;
		}
		
	}

	@Override//<------------------------PRECISO VER MELHOR ESTE METODO
	public int compare(Produto produto1, Produto produto2) {
		if(produto1.getDescricao().equals(produto2.getDescricao())){
			return 1;
		}
		
		return 0;
	}
	
	

}
