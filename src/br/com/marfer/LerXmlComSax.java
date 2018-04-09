package br.com.marfer;

import java.io.FileInputStream;
import java.io.InputStream;

import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import br.com.marfer.ProdutosHandlers.ProdutosHandler;

public class LerXmlComSax extends DefaultHandler{

	public static void main(String[] args) throws Exception {
		XMLReader leitor = XMLReaderFactory.createXMLReader(); 
		ProdutosHandler logica = new ProdutosHandler();
		leitor.setContentHandler(logica);
		
		InputStream ips = new FileInputStream("src/xml/vendas.xml");
		InputSource is = new InputSource(ips);

		leitor.parse(is);

		System.out.println(logica.getProdutos());

	}


}
