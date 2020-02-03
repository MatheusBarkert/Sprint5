package DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import desafioSprint5.Produto;

public class ProdutoDAO {
	
	private List<Produto> lstProduto = new ArrayList<Produto>();
	
	public List<Produto> leituraProduto() throws ParserConfigurationException, SAXException, IOException{
		
		
		
		try {
			DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = fabrica.newDocumentBuilder();
			Document document = builder.parse("Produto.xml");
			NodeList descricaoProduto = document.getElementsByTagName("descricao");
			NodeList precoProduto = document.getElementsByTagName("preco");
			
			for (int i = 0; i < descricaoProduto.getLength(); i++) {
				Element descricao = (Element) descricaoProduto.item(i);
				String produtoDescricao = descricao.getTextContent();
				
				Element preco = (Element) precoProduto.item(i);
				double produtoPreco = Double.parseDouble(preco.getTextContent());
				
				Produto produto = new Produto(produtoDescricao, produtoPreco);
				lstProduto.add(produto);
				
			}
		}catch(FileNotFoundException ex) {
			System.out.println("O arquivo Produto.xml nao foi encontrado! " +ex);
		}
		
		
		return lstProduto;
	}

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
