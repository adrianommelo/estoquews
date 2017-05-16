package br.com.caelum.estoque.modelo.adpter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAdapter {

	private String pattern = "dd/MM/yyyy";
	
	//converte um String para um Date
	public Date unmarshal(String dateString) throws Exception {
		return new SimpleDateFormat(pattern).parse(dateString);
	}
	
	/**
	 * converte String para Date
	 * para uso do JAX-B
	 * 
	 * marshal =  formato dd/MM/yyyy
	 */
	public String marshal(Date date) throws Exception {
		return new SimpleDateFormat(pattern).format(date);
	}
}
