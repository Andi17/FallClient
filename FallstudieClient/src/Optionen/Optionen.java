package Optionen;

import gui.Login;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class Optionen {
	private Preferences userPrefs = Preferences.userNodeForPackage( Optionen.class );
	private static String Urlanfang ="http://";
	private static String Domain = "localhost";
	private static String Urlende = ":8888/Elastico/";
	
	public String getDomain(){
		
			Domain = userPrefs.get("Domain","Domain");
			System.out.println(Domain);
		
		String rueckgabe = Urlanfang+Domain+Urlende;
		return rueckgabe;
	}
	public void setDomain(String Domain){
		userPrefs.put("Domain", Domain);
		try {
			userPrefs.flush();
		} catch (BackingStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
