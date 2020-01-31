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

import desafioSprint5.Cliente;

public class ClienteDAO {

	private List<Cliente> lstClientes = new ArrayList<Cliente>();

	public List<Cliente> leituraCLientes() throws ParserConfigurationException, SAXException, IOException { //<--------- metodo DOM para a leitura do XML, ainda quero mexer pois é muito << ctrl C | ctrl V >>

		try {
			DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = fabrica.newDocumentBuilder();
			Document document = builder.parse("Cliente.xml");

			NodeList nomesCliente = document.getElementsByTagName("nome");
			NodeList cpfsCliente = document.getElementsByTagName("cpf");

			for (int i = 0; i < nomesCliente.getLength(); i++) {

				Element nome = (Element) nomesCliente.item(i);
				String clienteNome = nome.getTextContent();

				Element cpf = (Element) cpfsCliente.item(i);
				String clienteCPF = cpf.getTextContent();

				Cliente cliente = new Cliente(clienteNome, clienteCPF);

				lstClientes.add(cliente);

			}

		} catch (FileNotFoundException ex) {
			System.out.println("Arquivo Cliente.xml não foi encontrado! " + ex);
		}
		return lstClientes;

	}
	
	public void escritaClientes(List<Cliente> lstClientes) {
		try {
			ObjectMapper xmlMapper = new XmlMapper();
			
			xmlMapper.writeValue(new File("Cliente.xml"), lstClientes);
			}catch(IOException ex) {
				System.out.println("Não foi possivel encontrar o arquivo! " + ex);
			}
	}
	
	public void guardaClientes(List<Cliente> lstClientes) {
		escritaClientes(lstClientes);
	}

}
