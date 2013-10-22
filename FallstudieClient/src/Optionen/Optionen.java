package Optionen;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class Optionen {
	private Preferences userPrefs = Preferences.userNodeForPackage( Optionen.class );
	private static String Urlanfang ="http://";
	private static String Domain = "localhost";
	private static String Urlende = ":8888/Elastico/";
	
	public String getDomain(){
		
			Domain = userPrefs.get("Domain","Domain");
			
		
		String rueckgabe = Urlanfang+Domain+Urlende;
		return rueckgabe;
	}
	public void setDomain(String Domain){
		userPrefs.put("Domain", Domain);
		try {
			userPrefs.flush();
		} catch (BackingStoreException e) {
			e.printStackTrace();
		}
	}

}
