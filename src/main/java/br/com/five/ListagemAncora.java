package br.com.five;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

public class ListagemAncora implements Runnable {

	List<String> urlsAncora = new ArrayList<String>(); 
	
	public ListagemAncora(List<String> urlsAncora) {
		this.urlsAncora = urlsAncora;
	}

	public void run() {
		Writer writer;

		try {
			writer = Files.newBufferedWriter(Paths.get("linkNaoSeguro.csv"));
			CSVWriter csvWriter = new CSVWriter(writer);
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

}
