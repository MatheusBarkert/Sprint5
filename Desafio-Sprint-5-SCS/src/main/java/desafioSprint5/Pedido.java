package desafioSprint5;

import java.util.ArrayList;
import java.util.List;

public class Pedido implements Comparable{

	private Estoque estoque;
	private List<Cliente> lstCliente = new ArrayList<Cliente>();

	public boolean verificaProduto(String descricaoProduto, List<Produto> lstProdutos) {

		for (Produto produto : lstProdutos) {
			if (produto.getDescricao().equals(descricaoProduto) == true) {
				return true;
			}else {
				System.out.println("Passei aqui!");
			}
		}

		return false;

	}

	public Estoque devolveProduto() {

		
		
		return estoque;

	}

	public void realizarPedido() {

	}

	public int compareTo(Produto produto) {
	
		
		return 0;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
