package desafioSprint5;

public class Produto {
	
	private double preco;
	private String descricao;
	
	
	public Produto(String descricao, double preco) {
		this.descricao = descricao;
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getPreco() {
		return preco;
	}
		
	@Override
	public String toString() {
		return "Descrição: " + this.descricao + " Preço: R$ " + this.preco;
	}

}
