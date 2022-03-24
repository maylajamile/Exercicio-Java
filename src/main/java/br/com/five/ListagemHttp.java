package br.com.five;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * Esta classe escreve os links listados no arquivo csv escolhido
 * 
 * @param {List<String>} urlsHttp receberá links http que seguirão para o arquivo .csv
 * e os escreverá utilizando ";" como separador
 * 
 */

public class ListagemHttp implements Runnable {

	List<String> urlsHttp = new ArrayList<String>(); 
	
	public ListagemHttp(List<String> urlsHttp) {
		this.urlsHttp = urlsHttp;
	}
	
	
	public void run() {
		
		//Cria o biffered writer que escreverá as strings (links) no 
		// arquivo csv separando-os por ";" e quebra uma linha
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter("linkSeguro.csv"));
			
			for (String url : urlsHttp) {
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
