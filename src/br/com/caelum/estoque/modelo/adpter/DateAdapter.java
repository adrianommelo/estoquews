package br.com.caelum.estoque.modelo.adpter;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date> {

	private String pattern = "dd/MM/yyyy";

	// converte um String para um Date
	@Override
	public Date unmarshal(String dateString) throws Exception {
		System.out.println(dateString + " unmarshal");
		return new SimpleDateFormat(pattern).parse(dateString);
	}

	/**
	 * converte String para Date para uso do JAX-B
	 * 
	 * marshal = formato dd/MM/yyyy
	 */
	@Override
	public String marshal(Date date) throws Exception {
		System.out.println(date + " marshal");
		return new SimpleDateFormat(pattern).format(date);
	}

}
