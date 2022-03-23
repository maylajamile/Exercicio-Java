package br.com.five;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListagemHttps implements Runnable {

	List<String> urlsHttps = new ArrayList<String>(); 
	
	public ListagemHttps(List<String> urlsHttps) {
		this.urlsHttps = urlsHttps;
	}
	
	@Override
	public void run() {
		
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter("linkSeguro.csv"));
			
			for (String url : urlsHttps) {
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
