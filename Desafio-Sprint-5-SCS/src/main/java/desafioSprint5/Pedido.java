package desafioSprint5;

import java.time.LocalDate;
import java.util.List;

public class Pedido {
	
	private String nomeCliente;
	private List<Estoque> lstProdutosPedido;
	private LocalDate localDate;
	
	public Pedido() {
		
	}


	public boolean verificaProduto(String descricaoProduto, List<Produto> lstProdutos) {

		for (Produto produto : lstProdutos) {
			if (produto.getDescricao().equals(descricaoProduto)) {
				return true;
			}
		}
		return false;
	}

	public boolean verificaCliente(String nome, List<Cliente> lstClientes) {

		for (Cliente cliente : lstClientes) {
			if (cliente.getNome().equals(nome)) {
				return true;
			}
		}
		return false;
	}

	public void verificaQuantidade(String descricaoProduto, List<Estoque> lstEstoque, int quantidade) {

		for (Estoque estoque : lstEstoque) {
			
			if (estoque.getProduto().getDescricao().equals(descricaoProduto)) {
				
				if(estoque.getQuantidade() >= quantidade) {
					estoque.setQuantidade(estoque.getQuantidade() - quantidade);
					//return true;
				}else {
					System.out.println("Neste momento o produto " + estoque.getProduto().getDescricao() + " tem apenas " + estoque.getQuantidade() + " unidades no estoque!");
				}
				
			}
			
		}

		
	}

	public void gerarRelatorioDeCompra() {
		
		
		
	}
	
	
}
