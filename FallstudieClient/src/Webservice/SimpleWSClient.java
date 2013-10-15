package Webservice;

import java.util.ArrayList;
import java.util.List;



/**
 * 
 * Hinweis: Erstellen und Aufruf des WebService-Servers siehe Projekt WebServiceDemo
 * 
 * wsimport Aufruf 
 * (Hinweis: erst *alle Klassen ausser dieser* mit wsimport in srcgen erzeugen lassen ,
 *  dann in eclipse in src/de/integrata importieren)
 *  c:\eclipseWorkspace\WebServiceClientDemo>
 *  wsimport -s srcgen -d bin http://localhost:8888/WSExample/simple?wsdl
 * 
 * Der einfache Web_Services Client benutzt die von wsimport
 * generierten Java-Klassen um die WebService-Methoden zu
 * benutzen.
 * Die Klasse SimpleWSService liefert mit get...Port() eine
 * Proxy-Referenz, die dann benutzt wird um die remote-Methoden
 * aufzurufen.  
 */
public class SimpleWSClient {  
	public static void main(String[] args) {  

	WebserviceService service = new WebserviceService();
  	System.out.println("service=" + service);
  	Webservice port = service.getWebservicePort();

    List<Integer> a = port.anzeige("Manfred", "du");
    if (a == null || a.isEmpty()){
    	System.out.println("fail"); 
    }
    else{
    	for (int i : a){
    		System.out.println("Zahl :"+i);
    	}
    }
  } 
}