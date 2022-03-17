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
		   System.out.println("Link: " + href);
		}
		
	}

}
