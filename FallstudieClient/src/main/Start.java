package main;

import java.net.MalformedURLException;
import java.net.URL;

import gui.Domaineingabe;

import javax.xml.ws.WebServiceException;

import Optionen.Optionen;
import Webservice.Webservice;
import Webservice.WebserviceService;

public class Start {

	/**
	 * Elastico - Elektronische Arbeitsstatistik / Information / Control /
	 * Observation
	 * @return 
	 */
	
	public static boolean starten(){

		WebserviceService service;
		Webservice port;
		boolean ok = false;

			try {
				service = new WebserviceService(new URL(new Optionen().getDomain()+"simple?wsdl"));
				port = service.getWebservicePort();
				gui.Login Loginfenster = new gui.Login(port);
				Loginfenster.setVisible(true);
				ok = true;

			} catch (WebServiceException e) {
			
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ok;
		


	}
	public static void main(String[] args) {
		if(starten()== false){
			Domaineingabe fenster = new Domaineingabe();
			fenster.setVisible(true);
		}
		
	}

}
