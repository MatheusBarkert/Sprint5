package desafioSprint5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LeituraDeArquivos {

	/*
	 * Este metodo é usado principalmente para ler arquivos de Estoque e devolver a lista de estoque
	 */
	public List<Object> leituraArquivo(List<Object> obj,String nomeArquivo, String campo1, String campo2, String campo3) throws ParserConfigurationException, SAXException, IOException {

		
		
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = fabrica.newDocumentBuilder();
		Document document = builder.parse(nomeArquivo);
		NodeList primeiroCampo = document.getElementsByTagName(campo1);
		NodeList segundoCampo = document.getElementsByTagName(campo2);
		NodeList terceiroCampo = document.getElementsByTagName(campo3);

		for (int i = 0; i < primeiroCampo.getLength(); i++) {

			Element campoUm = (Element) primeiroCampo.item(i);
			double produtoPreco = Double.parseDouble(campoUm.getTextContent());

			Element campoDois = (Element) segundoCampo.item(i);
			String descricaoProduto = campoDois.getTextContent();

			Element campoTres = (Element) terceiroCampo.item(i);
			int quantidadeProduto = Integer.parseInt(campoTres.getTextContent());

			Estoque estoque = new Estoque(new Produto(descricaoProduto, produtoPreco), quantidadeProduto);
			
		}
		
//	} catch (FileNotFoundException ex){
//		System.out.println("Arquivo Estoque.xml não foi encontrado! " + ex);
//	}

	//return lstEstoque;

	return null;

}}
