package br.com.caelum.estoque.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.dao.ItemDao;
import br.com.caelum.estoque.modelo.item.validator.ItemValidador;
import br.com.caelum.estoque.modelo.usuario.TokenDao;
import br.com.caelum.estoque.modelo.usuario.TokenUsuario;
import br.com.caelum.estoque.ws.fault.AutorizacaoException;

@WebService
public class EstoqueWS {

	ItemDao dao = new ItemDao();

	@WebMethod(operationName="todosOsItens")
	@ResponseWrapper(localName="itens")
	@WebResult(name="item")
	@RequestWrapper(localName="listaItens")
	public List<Item> getItens() {
		System.out.println("Chamando getItens()");
	    return dao.todosItens();
	}
	
	@WebMethod(operationName="CadastrarItem")
	@WebResult(name="item")
	public Item cadastrarItem(
			@WebParam(name="tokenUsuario", header=true) TokenUsuario tokenUsuario,  
			@WebParam(name="item") Item item) throws AutorizacaoException {
		if(!new TokenDao().ehValido(tokenUsuario)){
			throw new AutorizacaoException("Autorizacao falhou.");
		}
		
		
		/**
		 * a chamada desta validação lança uma ItemValidadorException, caso o item seja inválido.
		 * Essa exceção é unchecked, ou seja, não faz parte do WSDL.
		 */
		new ItemValidador(item).validate();
		
		System.out.println("Cadastrando " + item + " token: " +tokenUsuario);
		this.dao.cadastrar(item);
		return item;
	}

}
