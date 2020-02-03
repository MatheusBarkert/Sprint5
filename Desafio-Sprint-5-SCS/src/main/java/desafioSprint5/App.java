package desafioSprint5;

import java.util.Scanner;

public class App {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Menus menus = new Menus();
		int opcao = 0;
		boolean flag = true;

		do {

			menus.menuPrincipal();
			try {
				opcao = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException ex) {
				System.out.println("Este campo não pode ser vázio ou conter letras! " + ex);
			}

			switch (opcao) {
			case 1:
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

		} while (flag);

		System.out.println("Programa Encerrado!");
	}

}
