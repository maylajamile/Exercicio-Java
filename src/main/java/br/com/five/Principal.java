package br.com.five;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Principal {
	
	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		
		WebClient webClient = new WebClient(BrowserVersion.CHROME);
		HtmlPage arquivo = webClient.getPage("https://pt.wikipedia.org/wiki/Java_(linguagem_de_programa%C3%A7%C3%A3o)");
		webClient.close();
		
		LeitorDeLinks leitorDeLinks = new LeitorDeLinks(arquivo);
		Thread leituraDeLinks = new Thread(leitorDeLinks);
		leituraDeLinks.start();
		
	}
	
}
