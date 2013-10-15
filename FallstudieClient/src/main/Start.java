package main;

import Webservice.Webservice;
import Webservice.WebserviceService;

public class Start {

	/**
	 * Elastico - Elektronische Arbeitsschritt / Information / Control / Observation
	 */
	
	public static void main(String[] args) {
		WebserviceService service = new WebserviceService();
      	Webservice port = service.getWebservicePort();
		gui.Login Loginfenster = new gui.Login(port);
		Loginfenster.setVisible(true);
	}
}
