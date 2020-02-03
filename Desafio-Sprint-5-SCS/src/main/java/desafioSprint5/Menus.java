package desafioSprint5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import DAO.ClienteDAO;
import DAO.EstoqueDAO;
import DAO.ProdutoDAO;

/*
 * preciso mexer nesta classe, esta fazendo muitas coisas
 */

public class Menus {

	private List<Estoque> lstEstoque = new ArrayList<Estoque>();
	private List<Cliente> lstClientes = new ArrayList<Cliente>();
	private List<Produto> lstProdutos = new ArrayList<Produto>();
	private EstoqueDAO estoqueDAO = new EstoqueDAO();
	private ClienteDAO clienteDAO = new ClienteDAO();
	private ProdutoDAO produtoDAO = new ProdutoDAO();
	private Pedido pedido = new Pedido();

	int opcao = 0;

	public void menuPrincipal() {
		System.out.println("1 - Verificar estoque");
		System.out.println("2 - Realizar pedido");
		System.out.println("3 - Cadastrar produto");
		System.out.println("4 - Cadastrar cliente");
		System.out.println("5 - Sair");
	}

	public void verificaEstoque() throws Exception {

		System.out.println("---------------------------------------Estoque---------------------------------------");
		lstEstoque.clear();// <--- primeiro limpo a lista, se nao ela vai duplicando
		lstEstoque = estoqueDAO.leituraEstoque();
		lstEstoque.forEach(e -> System.out.println(e));
		System.out.println("-------------------------------------------------------------------------------------");

	}

	public void realizaPedido(Scanner sc) throws ParserConfigurationException, SAXException, IOException {// <--------rever

		// limpo a lista para nao dar problema de sobrescrita
		lstProdutos.clear();
		lstProdutos = produtoDAO.leituraProduto();
		lstClientes.clear();
		lstClientes = clienteDAO.leituraCLientes();
		lstEstoque.clear();
		lstEstoque = estoqueDAO.leituraEstoque();

		System.out.println("Digite o nome do cliente cadastrado: ");
		String nomeCliente = sc.nextLine();

		if (pedido.verificaCliente(nomeCliente, lstClientes)) {// <-------- se o cliente esta cadastrado

			System.out.println("Qual item deseja comprar?");
			String descricaoProduto = sc.nextLine();

			if (pedido.verificaProduto(descricaoProduto, lstProdutos)) {// lista esta vazia

				System.out.println("Qual a quantidade que deseja comprar?");
				int quantidadePedido = Integer.parseInt(sc.nextLine());

				
				pedido.verificaQuantidade(descricaoProduto, lstEstoque, quantidadePedido);
				
				

			} else {
				System.out.println("O produto '" + descricaoProduto + "' não foi encontrado em nosso Estoque!");
			}
			
		} else {
			System.out.println("O cliente ainda nao esta cadastrado!");
			System.out.println("1 - Cadastrar cliente");
			System.out.println("2 - Voltar ao menu Principal");
			opcao = Integer.parseInt(sc.nextLine());
			if (opcao == 1) {
				cadastraCliente(sc);
			} else {
				System.out.println("Voltando ao menu principal...");
			}

		}

		estoqueDAO.guardaListaEstoque(lstEstoque);


	}

	public void cadastraProduto(Scanner sc) throws ParserConfigurationException, SAXException, IOException {

		lstProdutos.clear();
		lstProdutos = produtoDAO.leituraProduto();

		System.out.println("Digite a descrição do produto:");
		String descricao = sc.nextLine();

		System.out.println("Digite o preço do produto:");
		double preco = Double.parseDouble(sc.nextLine());

		System.out.println("Quantos desse produto entrarão no estoque?");
		int quantidade = Integer.parseInt(sc.nextLine());

		Produto produto = new Produto(descricao, preco);
		lstProdutos.add(produto);

		Estoque estoque = new Estoque(produto, quantidade);
		lstEstoque.add(estoque);// <---------------- Possivel Problema

		System.out.println("Produto cadastrado com sucesso!");

		estoqueDAO.guardaListaEstoque(lstEstoque);
		produtoDAO.guardaListaProdutos(lstProdutos);

	}

	public void cadastraCliente(Scanner sc) throws ParserConfigurationException, SAXException, IOException {

		lstClientes.clear();
		lstClientes = clienteDAO.leituraCLientes();

		System.out.println("Digite o nome do cliente: ");
		String nome = sc.nextLine();

		System.out.println("Digite o cpf do cliente: ");
		String cpf = sc.nextLine();

		Cliente cliente = new Cliente(nome, cpf);

		lstClientes.add(cliente); // <----------------- Possivel Problema

		clienteDAO.escritaClientes(lstClientes);
	}

	public List<Produto> retornaListaDeProdutos() {

		return lstProdutos;

	}

	public List<Cliente> retornaListaDeClientes() {

		return lstClientes;
	}

}
