package br.com.caelum.estoque.ws;

import javax.xml.ws.Endpoint;

public class PublicaEstoqueWS {

	public static void main(String[] args) {
		EstoqueWS implementacaWS = new EstoqueWS();
		String url = "http://localhost:8080/estoquews";
		
		System.out.println("EstoqueWS rodando: " + url);
		
		//associando a url com a implementação
		Endpoint.publish(url, implementacaWS);

	}

}
