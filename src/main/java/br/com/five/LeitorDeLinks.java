package br.com.five;

import java.util.ArrayList;
import java.util.List;

import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class LeitorDeLinks implements Runnable {

	private HtmlPage arquivo;
	
	List<String> urlsHttps = new ArrayList<String>();
	List<String> urlsAncora = new ArrayList<String>();
	
	public LeitorDeLinks(HtmlPage arquivo) {
		this.arquivo = arquivo;
	}
	
	public List<String> listarUrlsHttps(){
		return urlsHttps;
	}
	
	public List<String> listarUrlsAncora(){
		return urlsAncora;
	}

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
		
	}

}
