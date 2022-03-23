package br.com.five;

import java.util.ArrayList;
import java.util.List;

import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * Separa os anchor tags em duas listas, sendo uma de links Http
 * e outra de links âncora. Tabém inicia as threads de escrita nos
 * respectivos arquivos
 *
 * @param {HtmlPage} receberá o link a ser processado
 * @param {List<String>} urlsHttps receberá os links que iniciam com Http
 * @param {List<String>} urlsAncora receberá os links âncoras  
 * 
 */

public class LeitorDeLinks implements Runnable {

	private HtmlPage arquivo;
	private List<String> urlsHttp = new ArrayList<String>();
	private List<String> urlsAncora = new ArrayList<String>();
	
	
	public LeitorDeLinks(HtmlPage arquivo) {
		this.arquivo = arquivo;
	}
	
	@Override
	public void run() {
		
		//Separa link por link e o adiciona na sua respectiva lista
		List<HtmlAnchor> links = arquivo.getAnchors();
		for (HtmlAnchor link : links) {
			String href = link.getHrefAttribute();
			
			if(href.startsWith("http")){
				urlsHttp.add(href);
			}else{
				urlsAncora.add(href);
			}
		}
		
		//Inicia a thread de escrita para links Ancora
		ListagemAncora listagemAncora = new ListagemAncora(urlsAncora);
		Thread listagemDeLinksAncora = new Thread(listagemAncora);
		listagemDeLinksAncora.start();
		
		//Inicia a thread de escrita para links Https
		ListagemHttp listagemHttp = new ListagemHttp(urlsHttp);
		Thread listagemDeLinksHttp = new Thread(listagemHttp);
		listagemDeLinksHttp.start();
	}
}
