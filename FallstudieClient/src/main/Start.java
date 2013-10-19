package main;

import javax.xml.ws.WebServiceException;

import Webservice.Webservice;
import Webservice.WebserviceService;

public class Start {

	/**
	 * Elastico - Elektronische Arbeitsschritt / Information / Control / Observation
	 */
	
	public static void main(String[] args) {
		try{
			WebserviceService service = new WebserviceService();
	      	Webservice port = service.getWebservicePort();
			gui.Login Loginfenster = new gui.Login(port);
			Loginfenster.setVisible(true);
		}
		catch (WebServiceException e){
			System.out.println("Keine Verbindung möglich!");
		}
		
	}
}
