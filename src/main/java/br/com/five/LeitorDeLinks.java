package br.com.five;

import java.util.List;

import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class LeitorDeLinks implements Runnable {

	private HtmlPage arquivo;
	
	public LeitorDeLinks(HtmlPage arquivo) {
		this.arquivo = arquivo;
	}

	public void run() {
		
		List<HtmlAnchor> links = arquivo.getAnchors();
		for (HtmlAnchor link : links) {
		   String href = link.getHrefAttribute();
		   
		   if(href.startsWith("https")){
				GeradorDeCsv gesradorDeCsv = new GeradorDeCsv();
				geradorDeCsv.listarUrlHttps(href);
		   }else{
			   //Criar outra Thread de Leitura
		   }
		   
		   //System.out.println("Link: " + href);
		}
		
	}

}
