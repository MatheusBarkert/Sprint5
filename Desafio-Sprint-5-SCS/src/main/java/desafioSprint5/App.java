package desafioSprint5;

import java.util.List;
import java.util.Scanner;

import DAO.ClienteDAO;
import DAO.ProdutoDAO;

public class App {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Menus menus = new Menus();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		ClienteDAO clienteDAO = new ClienteDAO();
		//int opcao = 0;
		boolean flag = true;
		
		do{
			
			menus.menuPrincipal();
			int opcao = Integer.parseInt(sc.nextLine());
			
			switch (opcao) {
			case 1:
				//List<Produto> lstProdutos = menus.retornaListaDeProdutos();
				menus.verificaEstoque();
				break;

			case 2:
				menus.realizaPedido(sc);
				break;

			case 3:
				menus.cadastraProduto(sc);
				break;

			case 4:
				menus.cadastraCliente(sc);
				break;
				
			case 5: 
				flag = false;
				break;
			
			default:
				System.out.println("Opção inválida!");
				
			}
			
		}while(flag);

		System.out.println("Programa Encerrado!");
	}

}
