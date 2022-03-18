package br.com.five;

import java.util.ArrayList;
import java.util.List;

public class GeradorDeCsv {
	
	List<String> urlsHttps = new ArrayList<String>();
	List<String> urlsAncora = new ArrayList<String>();
	
	public void listarUrlHttps(String href){		
		urlsHttps.add(href);
	}
	
	public void listarUrlAncora(String ancora){
		urlsAncora.add(ancora);
	}
	
	Thread escritaHttps = new Thread(new ListagemHttps(urlsHttps));
	Thread escritaAconra = new Thread(new ListagemAncora(urlsAncora));
	
}
