package br.com.five;

import java.util.ArrayList;
import java.util.List;

import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class LeitorDeLinks implements Runnable {

	private HtmlPage arquivo;
	private List<String> urlsHttps = new ArrayList<String>();
	private List<String> urlsAncora = new ArrayList<String>();
	
	
	public LeitorDeLinks(HtmlPage arquivo) {
		this.arquivo = arquivo;
	}
	
	@Override
	public void run() {
		
		List<HtmlAnchor> links = arquivo.getAnchors();
		for (HtmlAnchor link : links) {
			String href = link.getHrefAttribute();
			
			if(href.startsWith("https")){
				urlsHttps.add(href);
			}else{
				urlsAncora.add(href);
			}
		}

		ListagemAncora listagemAncora = new ListagemAncora(urlsAncora);
		Thread listagemDeLinksAncora = new Thread(listagemAncora);
		listagemDeLinksAncora.start();
		
		ListagemHttps listagemHttps = new ListagemHttps(urlsHttps);
		Thread listagemDeLinksHttps = new Thread(listagemHttps);
		listagemDeLinksHttps.start();
	}
}
