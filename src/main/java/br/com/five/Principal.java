package br.com.five;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Principal {

	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException {

		System.out.println("Insira o site a ser processado:");

		try {
			// Recebe o site a partir do console
			Scanner scanner = new Scanner(System.in);
			String siteUsuario = scanner.nextLine();
			scanner.close();

			System.out.println("O site está sendo processado...");

			// Remove mensagens de erro relacionadas a css e javascript do htmlunit
			java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
			java.util.logging.Logger.getLogger("org.apache.http").setLevel(java.util.logging.Level.OFF);

			// Simula um browser
			WebClient webClient = new WebClient(BrowserVersion.CHROME);

			// Ignora erros causados por sintaxes incompletas do JavaScript
			webClient.getOptions().setThrowExceptionOnScriptError(false);

			// Recebe a página e fecha o browser
			HtmlPage arquivo = webClient.getPage(siteUsuario);

			webClient.close();

			// Inicia a thread que lê os links
			LeitorDeLinks leitorDeLinks = new LeitorDeLinks(arquivo);
			Thread leituraDeLinks = new Thread(leitorDeLinks);
			leituraDeLinks.start();

			System.out.println("Seu site foi processado, cheque os documentos.");

		} catch (MalformedURLException e) {
			throw new RuntimeErrorException(null, "Site inválido");
		}
	}
}
