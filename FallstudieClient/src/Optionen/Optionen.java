package Optionen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Optionen {
	private static String Urlanfang ="http://";
	private static String Domain = "localhost";
	private static String Urlende = ":8888/Elastico/";
	
	public String getDomain(){
		FileReader writer;
		try {
			writer = new FileReader("C:/Users/juli/Domain.txt");
			BufferedReader reader = new BufferedReader(writer);
			Domain = reader.readLine();
			reader.close();
			writer.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		String rueckgabe = Urlanfang+Domain+Urlende;
		return rueckgabe;
	}

}
