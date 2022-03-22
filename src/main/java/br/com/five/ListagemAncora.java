package br.com.five;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListagemAncora implements Runnable {

	List<String> urlsAncora = new ArrayList<String>();

	public ListagemAncora(List<String> urlsAncora) {
		this.urlsAncora = urlsAncora;
	}

	@Override
	public void run() {
        
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter("linkAncora.csv"));
			
			for (String url : urlsAncora) {
				bw.write(url);
				bw.append(';');
				bw.newLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}