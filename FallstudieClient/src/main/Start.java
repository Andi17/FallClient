package main;

import gui.Domaineingabe;

import javax.xml.ws.WebServiceException;

import Webservice.Webservice;
import Webservice.WebserviceService;

public class Start {

	/**
	 * Elastico - Elektronische Arbeitsschritt / Information / Control /
	 * Observation
	 * @return 
	 */
	
	public static void starten(){

		WebserviceService service;
		Webservice port;


			try {
				service = new WebserviceService();
				port = service.getWebservicePort();
				gui.Login Loginfenster = new gui.Login(port);
				Loginfenster.setVisible(true);

			} catch (WebServiceException e) {
				Domaineingabe fenster = new Domaineingabe();
				fenster.setVisible(true);
	
			}
		


	}
	public static void main(String[] args) {
		starten();
	}

}
