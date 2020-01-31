package DAO;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import desafioSprint5.Produto;

public class ProdutoDAO {

	public void escritaProduto(List<Produto> lstProdutos) {

		try {
			ObjectMapper xmlMapper = new XmlMapper();

			xmlMapper.writeValue(new File("Produto.xml"), lstProdutos);
			
		} catch (IOException e) {
			System.out.println("Nao foi possivel escrever no arquivo! " + e);
		}
	}

	public void guardaListaProdutos(List<Produto> lstProduto) {

		escritaProduto(lstProduto);

	}

}
