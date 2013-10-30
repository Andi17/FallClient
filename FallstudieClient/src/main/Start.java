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
	 * 
	 * @return
	 * 
	 * Falls es möglich ist eine Proxy-Referenz aufzubauen wird die Loginmaske(Login) erzeugt
	 * Wenn nicht wird die Domain(Domaineingabe) erfragt.
	 * 
	 * 
	 * Zu Webservice-pakcage
	 *         wsimport Aufruf (Hinweis: erst alle Klassen mit
	 *         wsimport in srcgen erzeugen lassen , dann in eclipse in
	 *         src/FallstudieClient/Webservice importieren)
	 *         c:*Speicherort des Projektes*> wsimport -s srcgen -d
	 *         bin http://*ServerURL*:8888/Elastico/simple?wsdl
	 * 
	 *         Der einfache Web_Services Client benutzt die von wsimport
	 *         generierten Java-Klassen um die WebService-Methoden zu benutzen.
	 *         Die Klasse SimpleWSService liefert mit get...Port() eine
	 *         Proxy-Referenz, die dann benutzt wird um die remote-Methoden
	 *         aufzurufen.
	 *         Diese Referenz wird überall als Objekt des typs Webservice weitergegeben.
	 */

	public static boolean starten() {

		WebserviceService service;
		Webservice port;
		boolean ok = false;

		try {
			service = new WebserviceService(new URL(new Optionen().getDomain()
					+ "simple?wsdl"));
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
		if (starten() == false) {
			Domaineingabe fenster = new Domaineingabe();
			fenster.setVisible(true);
		}

	}

}
