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

import desafioSprint5.Estoque;
import desafioSprint5.Produto;

public class EstoqueDAO {

	private List<Estoque> lstEstoque = new ArrayList<Estoque>();

	public List<Estoque> leituraEstoque() throws ParserConfigurationException, SAXException, IOException {
		try {
			DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = fabrica.newDocumentBuilder();
			Document document = builder.parse("Estoque.xml");
			NodeList precosProduto = document.getElementsByTagName("preco");
			NodeList descricoesProduto = document.getElementsByTagName("descricao");
			NodeList quantidadesProduto = document.getElementsByTagName("quantidade");

			for (int i = 0; i < precosProduto.getLength(); i++) {

				Element preco = (Element) precosProduto.item(i);
				double produtoPreco = Double.parseDouble(preco.getTextContent());

				Element descricao = (Element) descricoesProduto.item(i);
				String descricaoProduto = descricao.getTextContent();

				Element quantidade = (Element) quantidadesProduto.item(i);
				int quantidadeProduto = Integer.parseInt(quantidade.getTextContent());

				Estoque estoque = new Estoque(new Produto(descricaoProduto, produtoPreco), quantidadeProduto);
				lstEstoque.add(estoque);
			}
		} catch (FileNotFoundException ex) {
			System.out.println("Arquivo Estoque.xml não foi encontrado! " + ex);
		}

		return lstEstoque;

	}

	public void escritaEstoque(List<Estoque> lstEstoque) {

		try {
		ObjectMapper xmlMapper = new XmlMapper();
		
		xmlMapper.writeValue(new File("Estoque.xml"), lstEstoque);
		}catch(IOException ex) {
			System.out.println("Não foi possivel encontrar o arquivo! " + ex);
		}
		
	}
	
	public void guardaListaEstoque(List<Estoque> lstEstoque) {
		
		escritaEstoque(lstEstoque);
		
	}

}
