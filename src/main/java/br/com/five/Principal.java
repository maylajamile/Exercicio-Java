package br.com.five;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Principal {
	
	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		
		//Remove mensagens de erro relacionadas a css e javascript do htmlunit
		java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
	    java.util.logging.Logger.getLogger("org.apache.http").setLevel(java.util.logging.Level.OFF);
		
	    //Simula um browser
		WebClient webClient = new WebClient(BrowserVersion.CHROME);
		
		//Recebe a página e fecha o browser
		HtmlPage arquivo = webClient.getPage("https://pt.wikipedia.org/wiki/Java_(linguagem_de_programa%C3%A7%C3%A3o)");
		webClient.close();
		
		//Inicia a thread que lê os links
		LeitorDeLinks leitorDeLinks = new LeitorDeLinks(arquivo);
		Thread leituraDeLinks = new Thread(leitorDeLinks);
		leituraDeLinks.start();
		
	}
	
}
