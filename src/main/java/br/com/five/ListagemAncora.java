package br.com.five;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * Esta classe escreve os links listados no arquivo csv escolhido
 * 
 * @param {List<String>} urlsHttp receberá links âncora que seguirão para o arquivo .csv
 * e os escreverá utilizando ";" como separador
 * 
 */

public class ListagemAncora implements Runnable {

	List<String> urlsAncora = new ArrayList<String>();

	public ListagemAncora(List<String> urlsAncora) {
		this.urlsAncora = urlsAncora;
	}

	
	public void run() {
        
		
		//Cria o biffered writer que escreverá as strings (links) no 
		// arquivo csv separando-os por ";" e quebra uma linha
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter("linkAncora.csv"));
			
			for (String url : urlsAncora) {
				bw.write(url);
				bw.append(';');
				bw.newLine();
				bw.flush();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}