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
	private Pedido pedido = new Pedido();
	
	
	public void menuPrincipal() {
		System.out.println("1 - Verificar estoque");
		System.out.println("2 - Realizar pedido");
		System.out.println("3 - Cadastrar produto");
		System.out.println("4 - Cadastrar cliente");
		System.out.println("5 - Sair");
	}

	public void verificaEstoque() throws Exception {
		
		
		System.out.println("---------------------------------------Estoque---------------------------------------");
		lstEstoque.clear();//<--- primeiro limpo a lista, se nao ela vai duplicando
		lstEstoque = estoqueDAO.leituraEstoque();	
		lstEstoque.forEach(e -> System.out.println(e));	
		System.out.println("-------------------------------------------------------------------------------------");

	}

	public void realizaPedido(Scanner sc) {
		
		System.out.println("Digite o nome do cliente cadastrado: ");
		String nomeCliente = sc.nextLine();
		
		System.out.println("Qual item deseja comprar?");
		String descricaoProduto = sc.nextLine();
		
//		System.out.println("Qual a quantidade que deseja comprar?");
//		int quantidadePedido = Integer.parseInt(sc.nextLine());
	
		if (pedido.verificaProduto(descricaoProduto, lstProdutos)) {
			
			System.out.println("Qual a quantidade que deseja comprar?");
			int quantidadePedido = Integer.parseInt(sc.nextLine());
			
		}else {
			System.out.println("O produto '" + descricaoProduto + "' não foi encontrado em nosso Estoque!");
		}
		
	}

	public void cadastraProduto(Scanner sc) {

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
	
	public List<Produto> retornaListaDeProdutos(){
		
		return lstProdutos;
		
	}
	
	public List<Cliente> retornaListaDeClientes(){
		
		return lstClientes;
	}

}
