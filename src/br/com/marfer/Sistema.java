package br.com.marfer;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import br.com.marfer.Modelo.Produto;

public class Sistema {
	
	public static String nome;
	public static String preco;
	
	public static void main(String[] args) throws Exception {
		
		
		String tipo_Moeda[] = {"R$", "D$"};
		
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/xml/vendas.xml");
		
		factory.setValidating(true);
		factory.setNamespaceAware(true);
		factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
		
		
		Element tp_moeda = document.getDocumentElement();
		String moeda = tp_moeda.getAttribute("moeda");
		int id_m = Integer.parseInt(tp_moeda.getAttribute("id"));
		
		System.out.println("Tipo da Moeda: " + moeda);
		
		
		NodeList produtos = document.getElementsByTagName("produto");

		for(int i =0; i < produtos.getLength(); i++) {
		    Element produto = (Element) produtos.item(i);
		    String nome = produto.getElementsByTagName("nome").item(0).getTextContent();
		    String preco = produto.getElementsByTagName("preco").item(0).getTextContent();

		    System.out.println("-----------");
		    System.out.println("Nome do produto: "+ nome);
		    System.out.println("Preco do produto: "+ tipo_Moeda[id_m] + " " + preco);
		    System.out.println("-----------");
		}
	}
}
