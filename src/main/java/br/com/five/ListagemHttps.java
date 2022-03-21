package br.com.five;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

public class ListagemHttps implements Runnable {

	List<String> urlsHttps = new ArrayList<String>(); 
	
	public ListagemHttps(List<String> urlsHttps) {
		this.urlsHttps = urlsHttps;
	}

	public void run() {
		Writer writer;

		try {
			writer = Files.newBufferedWriter(Paths.get("linkSeguro.csv"));

			CSVWriter csvWriter = new CSVWriter(writer, ';', 
					CSVWriter.NO_QUOTE_CHARACTER,
					CSVWriter.DEFAULT_ESCAPE_CHARACTER, 
					CSVWriter.DEFAULT_LINE_END);
			
			for(String str: urlsHttps) {
				writer.write(str);
			}
			
			csvWriter.flush();
			csvWriter.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

}
