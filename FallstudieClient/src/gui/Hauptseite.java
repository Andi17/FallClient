package gui;

import java.awt.Color;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Webservice.ComStatistik;
import Webservice.ComStrichart;
import Webservice.Webservice;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Hauptseite {

	private String Benutzername;
	private String Passwort;
	private Webservice port;
	public JFrame frmElasticoElektronische;
		
	public Hauptseite(String Benutzername, String Passwort, Webservice port) {
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.port = port;

		initialize();
	}

	private JPanel panelStricheln;
	List<ComStrichart> MeineListe;
	private JTextField textField;
	private JButton strichelnResetButton;
	private JButton strichelnAbschickenButton;
	private JPanel panelTable;
	private JScrollPane scrollTable;
	private List<JLabel> listeStricharten;
	private List<JTextField> listeStrichanzahl;
	private List<JComboBox<String>> listeWoche;

	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	private void initialize() {
		
		/*************************************************************************
										Allgemeines
		 *************************************************************************/
		
		// Erzeugen des Fensters
		frmElasticoElektronische = new JFrame();
		frmElasticoElektronische.setLocation(new Point(200, 100));
		frmElasticoElektronische.setResizable(false);
		frmElasticoElektronische.setTitle("Elastico");
		frmElasticoElektronische.setBackground(new Color(255, 250, 240));
		frmElasticoElektronische.getContentPane().setBackground(new Color(255, 250, 240));
		frmElasticoElektronische.setIconImage(Toolkit.getDefaultToolkit().getImage(Hauptseite.class.getResource("/gui/images/LogoFinal.png")));
		frmElasticoElektronische.setBounds(100, 100, 800, 400);
		frmElasticoElektronische.getContentPane().setLayout(null);
		
		// Erzeugen der Elemente
		JTabbedPane tabpane = new JTabbedPane(JTabbedPane.TOP);
		panelStricheln = new JPanel();
		JPanel panelStatistik = new JPanel();
		JPanel panelAdministration = new JPanel();
		JButton beendenButton = new JButton("Beenden");
		JButton hilfeButton = new JButton("");
		JLabel lblEingeloggtAls = new JLabel("Eingeloggt als: "+ Benutzername);
		
		// Farben fŸr die Elemente
		tabpane.setForeground(Color.BLACK);
		tabpane.setBackground(new Color(255, 250, 240));
		panelStricheln.setBackground(new Color(255, 250, 240));
		panelStatistik.setBackground(new Color(255, 250, 240));
		panelAdministration.setBackground(new Color(255, 250, 240));
		beendenButton.setBackground(Color.WHITE);
		hilfeButton.setBackground(new Color(255, 250, 240));

		// Grš§e und Breite der Elemente
		tabpane.setBounds(23, 6, 754, 325);	
		beendenButton.setBounds(662, 337, 115, 30);
		hilfeButton.setBounds(23, 337, 30, 30);
		lblEingeloggtAls.setBounds(74, 342, 300, 16);

		/*
		Anzeigen der Tabs Stricheln, Statistik und Administration in AbhŠngigkeit
		der Rechte
		*/
		List<Integer> rechte = port.anzeige(Benutzername, Passwort);
		if (rechte.contains(1)) {
			tabpane.addTab("Stricheln", panelStricheln);
		}
		if (rechte.contains(2)) {
			tabpane.addTab("Statistik", panelStatistik);
		}
		
		if (rechte.contains(3)) {
			tabpane.addTab("Administration", panelAdministration);
		}
		
		//Gibt eine Meldung falls der Benutzer keine Rechte hat.
		if(rechte.size()==0){
			Fehlermeldung fehler = new Fehlermeldung("Info", "Sie sind keiner Gruppe zugeordnet und haben deswegen auch keine Rechte.");
			fehler.setVisible(true);
		}
	
		
		// Einbetten Bilder in Elemente
		hilfeButton.setIcon(new ImageIcon(Login.class.getResource("/gui/images/IconFragezeichenTransparentFertig3030.png")));
		
		// Sonstige Einstellungen
		panelStricheln.setLayout(null);
		panelStatistik.setLayout(null);
		panelAdministration.setLayout(null);
		frmElasticoElektronische.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		// Elemente transparent setzen
		hilfeButton.setBorderPainted(false);
		
		// Initiierung der Elemente 
		frmElasticoElektronische.getContentPane().add(tabpane);
		frmElasticoElektronische.getContentPane().add(beendenButton);
		frmElasticoElektronische.getContentPane().add(hilfeButton);
		frmElasticoElektronische.getContentPane().add(lblEingeloggtAls);		
		
		// Implementierung der Logik
		MeineListe = port.getStrichelArten(Benutzername, Passwort, true);
			
		// Beenden - Button
		beendenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnwendungAbbruch frmAnwendungAbbruch = new AnwendungAbbruch();
				frmAnwendungAbbruch.setVisible(true);
			}
		});
			
		// Hilfe - Button
		hilfeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HauptseiteHilfe frmHauptmenueHilfe = new HauptseiteHilfe();
				frmHauptmenueHilfe.setVisible(true);				
			}
		});
		
		// Schlie§en - Button
		frmElasticoElektronische.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frmElasticoElektronische = (JFrame) e.getSource();
				AnwendungAbbruch frmAnwendungAbbruch = new AnwendungAbbruch();
				frmAnwendungAbbruch.setVisible(true);
			}
		});
					
		/*************************************************************************
		 							Stricheln
		*************************************************************************/
		
		// Erzeugen der Elemente
		strichelnAbschickenButton = new JButton("Abschicken");
		strichelnResetButton = new JButton("Reset");
		textField = new JTextField();
		JLabel tabulatorBeschreibung = new JLabel("<html>Tipp:<br>Mit der Tabulator-Taste kommen Sie jeweils ein Feld weiter.</html>");
		JButton sucheButton = new JButton("Suche");
		JButton strichelnHilfeButton = new JButton("");
		
		// Position, Grš§e und Breite der Elemente
		strichelnAbschickenButton.setBounds(540, 255, 115, 30);
		strichelnResetButton.setBounds(540, 63, 100, 30);
		textField.setBounds(10, 14, 434, 26);
		tabulatorBeschreibung.setBounds(540, 110, 150, 80);
		sucheButton.setBounds(540, 12, 100, 30);
		strichelnHilfeButton.setBounds(710, 11, 30, 30);
		
		// Farben der Elemente
		strichelnAbschickenButton.setBackground(Color.ORANGE);
		strichelnResetButton.setBackground(Color.WHITE);
		sucheButton.setBackground(Color.ORANGE);
		strichelnHilfeButton.setBackground(new Color(255, 250, 240));
		
		// Einbetten von Bildern in Elemente
		strichelnHilfeButton.setIcon(new ImageIcon(Login.class.getResource("/gui/images/IconFragezeichenTransparentFertig3030.png")));
		
		// Sonstige Einstellungen
		textField.setColumns(10);
		strichelnHilfeButton.setBorderPainted(false);
		
		// Initialisierung der Elemente
		panelStricheln.add(strichelnAbschickenButton);
		panelStricheln.add(strichelnResetButton);
		panelStricheln.add(textField);
		panelStricheln.add(tabulatorBeschreibung);
		panelStricheln.add(sucheButton);
		panelStricheln.add(strichelnHilfeButton);
		
		// Implementierung der Logik hinter den Elementen
		
		rowmachen();
		
		// Suche-Button
		sucheButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sucheInhalt = textField.getText();
				
				if(sucheInhalt.equals("")){
					Fehlermeldung fehler = new Fehlermeldung("Fehler!", "Geben Sie einen Suchbegriff in die Suchzeile ein.");
					fehler.setVisible(true);
				}
				else {
					List<ComStrichart> suchListe = new ArrayList<ComStrichart>();
					List<ComStrichart> nichtGesuchtListe = new ArrayList<ComStrichart>();

					for (ComStrichart s : MeineListe) {
							String vergleichsString = s.getStrichBez().toUpperCase();
							if (vergleichsString.contains(sucheInhalt.toUpperCase())) {
								suchListe.add(s);
							}
							else{
								nichtGesuchtListe.add(s);
							}
					}
					
					if(suchListe.size()==0){
						Fehlermeldung fehler = new Fehlermeldung("Fehler!", "Es gibt keine Strichart, die Ihren Suchbegriff enthält.");
						fehler.setVisible(true);
					}
					
					
					MeineListe = new ArrayList<ComStrichart>();
					MeineListe.addAll(suchListe);
					MeineListe.addAll(nichtGesuchtListe);
					panelStricheln.remove(scrollTable);
					scrollTable.remove(panelTable);
					rowmachen();
				}
			}
		});
			
		// Hilfe-Button	
		strichelnHilfeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StrichelnHilfe StrichelnHilfe = new StrichelnHilfe();
				StrichelnHilfe.setVisible(true);
			}
		});
		
		// Reset-Button
		strichelnResetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(null);
				MeineListe = port.getStrichelArten(Benutzername, Passwort, true);
				panelStricheln.remove(scrollTable);
				scrollTable.remove(panelTable);
				rowmachen();
			}
		});
		
		// Abschicken-Button
		strichelnAbschickenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<String[]> gefuellteZeilen = new ArrayList<String[]>();
				boolean abschickenErlaubt = true;
				for (int i = 0; i < MeineListe.size(); i++) {
					JTextField aktuellesTextFieldAnzahl = listeStrichanzahl.get(i);
					try {
						int ueberpruefen = 0;
						if(!aktuellesTextFieldAnzahl.getText().equals(""))
							ueberpruefen = Integer.parseInt(aktuellesTextFieldAnzahl.getText());
						if (ueberpruefen != 0) {
							String[] werteGefuellteZeilen = new String[3];
							werteGefuellteZeilen[0] = listeStricharten.get(i).getText();
							werteGefuellteZeilen[1] = aktuellesTextFieldAnzahl.getText();
							werteGefuellteZeilen[2] = (String) listeWoche.get(i).getSelectedItem();
							gefuellteZeilen.add(werteGefuellteZeilen);
						}
					} catch (NumberFormatException nfe) {
						if(abschickenErlaubt){
							Fehlermeldung fehlermeldung = new Fehlermeldung(
									"Fehler!", "Sie dürfen nur Zahlen eingeben.");
							fehlermeldung.setVisible(true);
						}
						abschickenErlaubt = false;
					}
				}
				int menge = gefuellteZeilen.size();
				if (menge == 0 && abschickenErlaubt) {
					Fehlermeldung fehlermeldung = new Fehlermeldung(
							"Fehler!", "Sie haben keine Werte eingegeben.");
					fehlermeldung.setVisible(true);
					abschickenErlaubt = false;
				}
				if(abschickenErlaubt){
					String[][] uebergabeArray = new String[menge][3];
					for (int o = 0; o < menge; o++) {
						uebergabeArray[o][0] = gefuellteZeilen.get(o)[0];
						uebergabeArray[o][1] = gefuellteZeilen.get(o)[1];
						uebergabeArray[o][2] = gefuellteZeilen.get(o)[2];
					}
					KontrolleStricheln fensterwechselKontrolle = new KontrolleStricheln(
							uebergabeArray, menge, Benutzername, Passwort, port);
					fensterwechselKontrolle.setVisible(true);
				}
				
			}
		});
		
		/*************************************************************************
									Administration
		 *************************************************************************/	
		
		// Erzeugen der Elemente
		JLabel lblBenutzerverwaltung = new JLabel("Benutzerverwaltung:");
		JLabel lblOrganisationseinheitenverwaltung = new JLabel("Organisationseinheitenverwaltung:");
		JLabel lblSystemverwaltung = new JLabel("Systemverwaltung:");
		JButton neuerBenutzerButton = new JButton("Benutzer anlegen");
		JButton bearbeitenBenutzerButton = new JButton("Benutzer bearbeiten");
		JButton loeschenBenutzerButton = new JButton("Benutzer l\u00F6schen");
		JButton neueOrganisationseinheitButton = new JButton("Organisationseinheit anlegen");
		JButton bearbeitenOrganisationseinheitButton = new JButton("Organisationseinheit bearbeiten");
		JButton administrationHilfeButton = new JButton("");
		JButton neueStrichkategorieButton = new JButton("Strichkategorie anlegen");
		JButton bearbeitenStrichkategorieButton = new JButton("Strichkategorie bearbeiten");
		
		// Position, Grš§e und Breite der Elemente	
		lblBenutzerverwaltung.setBounds(6, 6, 127, 16);		
		lblOrganisationseinheitenverwaltung.setBounds(6, 97, 252, 16);
		lblSystemverwaltung.setBounds(6, 183, 175, 16);
		neuerBenutzerButton.setBounds(6, 34, 150, 30);
		bearbeitenBenutzerButton.setBounds(166, 34, 150, 30);
		loeschenBenutzerButton.setBounds(328, 34, 150, 30);
		neueOrganisationseinheitButton.setBounds(5, 125, 250, 30);
		bearbeitenOrganisationseinheitButton.setBounds(265, 125, 250, 30);
		administrationHilfeButton.setBounds(710, 11, 30, 30);
		neueStrichkategorieButton.setBounds(6, 211, 200, 30);
		bearbeitenStrichkategorieButton.setBounds(215, 211, 200, 30);
		
		// Farbe der Elemente
		neuerBenutzerButton.setBackground(Color.WHITE);
		bearbeitenBenutzerButton.setBackground(Color.WHITE);
		loeschenBenutzerButton.setBackground(Color.WHITE);
		neueOrganisationseinheitButton.setBackground(Color.WHITE);
		bearbeitenOrganisationseinheitButton.setBackground(Color.WHITE);
		administrationHilfeButton.setBackground(new Color(255, 250, 240));
		neueStrichkategorieButton.setBackground(Color.WHITE);
		bearbeitenStrichkategorieButton.setBackground(Color.WHITE);
		
		// Einbetten von Bildern in Elemente
		administrationHilfeButton.setIcon(new ImageIcon(Login.class.getResource("/gui/images/IconFragezeichenTransparentFertig3030.png")));
		
		// Sonstige Einstellungen
		administrationHilfeButton.setBorderPainted(false);
		
		// Initiierung der Elemente
		panelAdministration.add(lblBenutzerverwaltung);		
		panelAdministration.add(lblOrganisationseinheitenverwaltung);		
		panelAdministration.add(lblSystemverwaltung);
		panelAdministration.add(neuerBenutzerButton);
		panelAdministration.add(bearbeitenBenutzerButton);	
		panelAdministration.add(loeschenBenutzerButton);	
		panelAdministration.add(neueOrganisationseinheitButton);
		panelAdministration.add(bearbeitenOrganisationseinheitButton);
		panelAdministration.add(administrationHilfeButton);	
		panelAdministration.add(neueStrichkategorieButton);
		panelAdministration.add(bearbeitenStrichkategorieButton);
		
		// Implementierung der Logik
		
		// Benutzer anlegen - Button
		neuerBenutzerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NeuerBenutzer NeuerBenutzer = new NeuerBenutzer(Benutzername,
						Passwort, port);
				NeuerBenutzer.setVisible(true);
			}
		});
		
		// Benutzer bearbeiten - Button
		bearbeitenBenutzerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BearbeitungBenutzer BearbeitungBenutzer = new BearbeitungBenutzer(
						Benutzername, Passwort, port);
				BearbeitungBenutzer.setVisible(true);
			}
		});
		
		// Benutzer lšschen - Button
		loeschenBenutzerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoescheBenutzer LoescheBenutzer = new LoescheBenutzer(
						Benutzername, Passwort, port);
				LoescheBenutzer.setVisible(true);
			}
		});
		
		// Organisationseinheit anlegen - Button
		neueOrganisationseinheitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NeueOrgaEinheit NeueOrgaEinheit = new NeueOrgaEinheit(
						Benutzername, Passwort, port);
				NeueOrgaEinheit.setVisible(true);
			}
		});
		
		// Organisationseinheit bearbeiten - Button
		bearbeitenOrganisationseinheitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BearbeitungOrgaEinheit BearbeitungOrgaEinheit = new BearbeitungOrgaEinheit(
						Benutzername, Passwort, port);
				BearbeitungOrgaEinheit.setVisible(true);
			}
		});
		
		// Strichkategorie anlegen - Button
		neueStrichkategorieButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NeueStrichkategorie StrichkategorieHinzu = new NeueStrichkategorie(
						Benutzername, Passwort, port);
				StrichkategorieHinzu.setVisible(true);
			}
		});
		
		// Strichkategorie bearbeiten - Button
		bearbeitenStrichkategorieButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BearbeitungStrichart BearbeitungStrichart = new BearbeitungStrichart(
						Benutzername, Passwort, port);
				BearbeitungStrichart.setVisible(true);
			}
		});
		
		// Administrationshilfe - Button
		administrationHilfeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Administrationshilfe Administrationshilfe = new Administrationshilfe();
				Administrationshilfe.setVisible(true);				
			}
		});
		
		
			/*************************************************************************
										Statistik
			 *************************************************************************/
		
		// Erstellen der Elemente
		JLabel lblZeitraum = new JLabel("Statistik zu:");
		final Calendar jahrKW = new GregorianCalendar();
		Date date = new Date();
		final JComboBox comboJahr = new JComboBox();
		ArrayList<String> strKWdynamisch = new ArrayList<String>();
		String[] strKurzesKWJahr = new String[53];
		String[] strLangesKWJahr = new String[54];
		ArrayList<String> strjahr = new ArrayList<String>();
		final ComboBoxModel[] comboxKWmodel = new ComboBoxModel[4];
		final JComboBox comboKW = new JComboBox();		
		final JComboBox comboAnzeigeFilter = new JComboBox();
		List<String> orgaEinlesen = new ArrayList<String>();
		JButton btnStatistik = new JButton("Statistik");
		JButton btnBalkenDiagramm = new JButton("Balkendiagramm");
		JButton statistikHilfeButton = new JButton("");
		
		//Labels erstellen
		JLabel jahrAuswaehlen = new JLabel("Jahr:");
		JLabel kalendarwocheAuswaehlen = new JLabel("Kalenderwoche:");
		JLabel gruppenAuswahlen = new JLabel("Organisationseinheit:");
		
		// Position, Grš§e und Breite
		lblZeitraum.setBounds(40, 43, 85, 16);
		comboJahr.setBounds(164, 37, 85, 28);
		jahrAuswaehlen.setBounds(164, 7, 85, 28);
		comboKW.setBounds(282, 37, 100, 28);
		kalendarwocheAuswaehlen.setBounds(282, 7, 100, 28);
		comboAnzeigeFilter.setBounds(415, 37, 200, 28);
		gruppenAuswahlen.setBounds(415, 7, 200, 28);
		btnStatistik.setBounds(132, 246, 200, 30);
		btnBalkenDiagramm.setBounds(342, 246, 200, 30);
		statistikHilfeButton.setBounds(710, 11, 30, 30);		
		
		// Farbe der Elemente
		btnStatistik.setBackground(Color.white);								
		btnBalkenDiagramm.setBackground(Color.white);
		statistikHilfeButton.setBackground(new Color(255, 250, 240));
		
		// Einbetten von Bildern in Elemente
		statistikHilfeButton.setIcon(new ImageIcon(Login.class.getResource("/gui/images/IconFragezeichenTransparentFertig3030.png")));
		
		// Transparent setzen von Elementen
		statistikHilfeButton.setBorderPainted(false);
				
		// Sonstige Einstellungen
		comboJahr.setEditable(false);
		comboJahr.setMaximumRowCount(8);
		comboKW.setEditable(false);
		comboKW.setMaximumRowCount(8);
		comboAnzeigeFilter.setSelectedItem("Gesamtstatistik");		
		comboAnzeigeFilter.setEditable(false);
		comboAnzeigeFilter.setMaximumRowCount(8);
						
		// Initiierung der Elemente
		panelStatistik.add(jahrAuswaehlen);
		panelStatistik.add(kalendarwocheAuswaehlen);
		panelStatistik.add(gruppenAuswahlen);
		panelStatistik.add(lblZeitraum);
		comboJahr.addItem("Jahr");
		panelStatistik.add(comboKW);
		comboAnzeigeFilter.addItem("Gesamtstatistik");
		panelStatistik.add(comboAnzeigeFilter);
		panelStatistik.add(btnStatistik);
		panelStatistik.add(btnBalkenDiagramm);
		panelStatistik.add(statistikHilfeButton);
			
		// Implementierung der Logik		
		
		// ComboBox
		// aktuelles Datum und KW ermitteln
		jahrKW.setTime(date);
		int kwjahr = jahrKW.get(Calendar.WEEK_OF_YEAR);
		for (int i = kwjahr; i >= 0; i--) {
			strKWdynamisch.add("" + i);
		}
		// String fuer aktuelle KW erstellen
		String[] strKWstatisch = new String[strKWdynamisch.size()];
		for (int i = 0; i < strKWstatisch.length-1; i++) {
			strKWstatisch[i+1] = strKWdynamisch.get(i);
		}
		strKWstatisch[0] = "Alle";
		// String fuer 52KW Jahr erstellen
		int kalendarwoche = 1;
		for (int i = strKurzesKWJahr.length - 1; i > 0; i--) {
			strKurzesKWJahr[i] = "" + kalendarwoche;
			kalendarwoche++;
		}
		strKurzesKWJahr[0] = "Alle";
		// String fuer 53KW Jahr erstellen	
		kalendarwoche = 1;
		for (int i = strLangesKWJahr.length - 1; i > 0; i--) {
			strLangesKWJahr[i] = "" + kalendarwoche;
			kalendarwoche++;
		}
		strLangesKWJahr[0] = "Alle";
		// Fallwerte fuer ComboBox's deklarieren
		comboxKWmodel[0] = new DefaultComboBoxModel(strKWstatisch);
		comboxKWmodel[1] = new DefaultComboBoxModel(strKurzesKWJahr);
		comboxKWmodel[2] = new DefaultComboBoxModel(strLangesKWJahr);
		comboxKWmodel[3] = new DefaultComboBoxModel(new String[] { "--" });
		comboKW.setModel(comboxKWmodel[3]);
		// 1990 - aktuelles Jahr -> Bei Einfuehrung am 01.01.2014 Aederungen auf 2014
		int intStartjahr = 1990;
		Calendar nowjahr = Calendar.getInstance();
		int intjahraktuell = nowjahr.get(Calendar.YEAR);
		for (int i = intjahraktuell; i >= intStartjahr; i--) {
			strjahr.add("" + i);
		}
		// Combo Jahr erstellen
		for (String s : strjahr)
			comboJahr.addItem(s);
		comboJahr.setSelectedItem("Jahr");
		panelStatistik.add(comboJahr);

		// Aufruf statistikUebergabe um die ComboBox zu befuellen (als Datum
		// wird die aktuelle KW im aktuellen Jahr mitgegeben)
		List<ComStatistik> statistikComboBox = port.getStrichartStatistik(
				Benutzername, Passwort, kwjahr, intjahraktuell);
		// Befüllung Array fuer ComboBox
		
		for (ComStatistik s : statistikComboBox)
			orgaEinlesen.add(s.getOrgaEinheitBez());

		// Übergabe in Array zur alphabetischen Sortierung
		String[] orgaVerarbeiten = new String[orgaEinlesen.size()];
		for (int i = 0; i < orgaEinlesen.size(); i++) {
			orgaVerarbeiten[i] = orgaEinlesen.get(i);
		}
		Arrays.sort(orgaVerarbeiten);

		// Abfrage auf Duplikate, Ergebnisuebergabe an AusgabeArray

		String[] orgaAusgabe = new String[orgaVerarbeiten.length];
		boolean ersteRunde = true;

		for (int i = 1; i < orgaVerarbeiten.length; i++) {

			if (!(orgaVerarbeiten[i].equals(orgaVerarbeiten[i - 1]))
					|| ersteRunde == true) {
				orgaAusgabe[i] = orgaVerarbeiten[i];
				ersteRunde = false;
			}
		}

		// BefŸllung ComboBox
		for (int i = 0; i < orgaAusgabe.length; i++) {
			if (!(orgaAusgabe[i] == "" || orgaAusgabe[i] == null))
				comboAnzeigeFilter.addItem(orgaAusgabe[i]);
		}
	
		// ItemListener in JahresComboBox implementieren
		comboJahr.addItemListener(new ItemListener() {
			String strJahrwahl = "";
			int intJahrwahl = -10;

			public void itemStateChanged(ItemEvent e) {
				JComboBox selectedJahr = (JComboBox) e.getSource();
				// aktuell gewaehltes Jahr ermitteln
				if (strJahrwahl != (String) selectedJahr.getSelectedItem()) {
					strJahrwahl = (String) selectedJahr.getSelectedItem();
					if (selectedJahr.getSelectedItem() == "Jahr") {
						intJahrwahl = -1;
					} else if (selectedJahr.getSelectedItem() != "Jahr") {
						intJahrwahl = Integer.parseInt(strJahrwahl);
					}
					// KW im aktuellen Jahr
					if (jahrKW.get(Calendar.YEAR) == intJahrwahl) {
						comboKW.setModel(comboxKWmodel[0]);
						comboKW.setSelectedItem("Alle");
					}
					// KW ohne Belegung, da kein Jahr gewaehlt
					if (intJahrwahl == -1) {
						comboKW.setModel(comboxKWmodel[3]);
						comboKW.setSelectedItem("--");
					}
					// KW bis aktuelles Jahr
					if (0 <= intJahrwahl
							&& intJahrwahl < jahrKW.get(Calendar.YEAR)) {
						Calendar pruefJahr = new GregorianCalendar(intJahrwahl,
								Calendar.DECEMBER, 31);
						switch (pruefJahr.get(Calendar.DAY_OF_WEEK)) {
						case Calendar.MONDAY:
						case Calendar.TUESDAY:
						case Calendar.WEDNESDAY:
							pruefJahr.add(Calendar.WEEK_OF_YEAR, -1);
							break;
						}
						int wahlJahreslaenge = pruefJahr
								.get((Calendar.WEEK_OF_YEAR));
						if (wahlJahreslaenge == 52) { // 52KW
							comboKW.setModel(comboxKWmodel[1]);
							comboKW.setSelectedItem("Alle");
						} else if (wahlJahreslaenge == 53) { // 53KW
							comboKW.setModel(comboxKWmodel[2]);
							comboKW.setSelectedItem("Alle");
						} else { // error
							System.err.println("ERROR: Wrong KW-Count: "
									+ wahlJahreslaenge + "!");
						}
					}
				}
			}
		});

		
		btnStatistik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int kw = 0;
				int jahr = 0;
				String orgaEinheit = "";
				try {
					Object c = comboAnzeigeFilter.getSelectedItem();
					orgaEinheit = comboAnzeigeFilter.getSelectedItem()
							.toString();
					Object b = comboJahr.getSelectedItem();
					jahr = Integer.parseInt(b.toString());
					Object a = comboKW.getSelectedItem();
					kw = Integer.parseInt(a.toString());

				} catch (Exception e) {
				}

				// Ausgabe, wenn KW und Jahr gewaehlt
				if (kw != 0 && jahr != 0) {
					List<ComStatistik> statistikPufferKategorie = port
							.getStrichartStatistik(Benutzername, Passwort, kw,
									jahr);
					List<ComStatistik> statistikUebergabeKategorie =  new ArrayList<ComStatistik>();
					List<ComStatistik> statistikPufferBereich = port
							.getBereichsStatistik(Benutzername, Passwort, kw,
									jahr);
					List<ComStatistik> statistikUebergabeBereich = new ArrayList<ComStatistik>();


					boolean gesamtstatistik = false;
					// Befüllung der Statistikübergabe
					if (!(orgaEinheit == "Gesamtstatistik")) {
						// Befuellung Kategorieuebergabe
						for (ComStatistik s : statistikPufferKategorie) {
							if (orgaEinheit.equals(s.getOrgaEinheitBez())) {
								statistikUebergabeKategorie.add(s);
								gesamtstatistik = false;
							}
						}
						// Befuellung Bereichuebergabe
						for (ComStatistik s : statistikPufferBereich) {
							if (orgaEinheit.equals(s.getOrgaEinheitBez())) {
								statistikUebergabeBereich.add(s);
							}
						}

					} else {
						statistikUebergabeKategorie = statistikPufferKategorie;
						statistikUebergabeBereich = statistikPufferBereich;
						gesamtstatistik = true;
					}

					Statistik frmStatistik = new Statistik(
							frmElasticoElektronische.getX() - 50,
							frmElasticoElektronische.getY() - 50,
							"Gesamtstatistik", statistikUebergabeKategorie,
							statistikUebergabeBereich, gesamtstatistik,
							Benutzername, Passwort, port);

					frmStatistik.setVisible(true);
					// frmElasticoElektronische.setVisible(false);// NEW
				}

				else if (kw == 0 && jahr != 0) {
					List<ComStatistik> statistikPufferKategorie = port
							.getStrichartStatistikJahr(Benutzername, Passwort,
									jahr);
					List<ComStatistik> statistikUebergabeKategorie = new ArrayList<ComStatistik>();
					List<ComStatistik> statistikPufferBereich = port
							.getBereichsStatistikJahr(Benutzername, Passwort,
									jahr);
					List<ComStatistik> statistikUebergabeBereich = new ArrayList<ComStatistik>();

					boolean gesamtstatistik = false;
					// Befüllung der Statistikübergabe
					if (!(orgaEinheit == "Gesamtstatistik")) {
						// Befuellung Kategorieuebergabe
						for (ComStatistik s : statistikPufferKategorie) {
							if (orgaEinheit.equals(s.getOrgaEinheitBez())) {
								statistikUebergabeKategorie.add(s);
								gesamtstatistik = false;
							}
						}
						// Befuellung Bereichuebergabe
						for (ComStatistik s : statistikPufferBereich) {
							if (orgaEinheit.equals(s.getOrgaEinheitBez())) {
								statistikUebergabeBereich.add(s);
							}
						}

					} else {
						statistikUebergabeKategorie = statistikPufferKategorie;
						statistikUebergabeBereich = statistikPufferBereich;
						gesamtstatistik = true;
					}

					Statistik frmStatistik = new Statistik(
							frmElasticoElektronische.getX() - 50,
							frmElasticoElektronische.getY() - 50,
							"Gesamtstatistik", statistikUebergabeKategorie,
							statistikUebergabeBereich, gesamtstatistik,
							Benutzername, Passwort, port);

					frmStatistik.setVisible(true);
				} else {
					statistikKeineWerte();
				}
				kw = 0;
				jahr = 0;
			}
		});
		
		btnBalkenDiagramm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// setGesamtStatistikText(datenZurAusgabe);
				int kw = 0;
				int jahr = 0;
				String orgaEinheit = "";
				try {
					Object c = comboAnzeigeFilter.getSelectedItem();
					orgaEinheit = comboAnzeigeFilter.getSelectedItem()
							.toString();
					Object b = comboJahr.getSelectedItem();
					jahr = Integer.parseInt(b.toString());
					Object a = comboKW.getSelectedItem();
					kw = Integer.parseInt(a.toString());

				} catch (Exception e) {
				}
				// Ausgabe, wenn KW und Jahr gewaehlt
				if (kw != 0 && jahr != 0) {
					List<ComStatistik> statistikPufferBereich = port
							.getBereichsStatistik(Benutzername, Passwort, kw,
									jahr);
					List<ComStatistik> statistikUebergabeBereich = new ArrayList<ComStatistik>();

					boolean gesamtstatistik = false;
					// Befüllung der Statistikübergabe
					if (!(orgaEinheit == "Gesamtstatistik")) {
						// Befuellung Bereichuebergabe
						for (ComStatistik s : statistikPufferBereich) {
							if (orgaEinheit.equals(s.getOrgaEinheitBez())) {
								statistikUebergabeBereich.add(s);
							}
						}

					} else {
						statistikUebergabeBereich = statistikPufferBereich;
						gesamtstatistik = true;
					}

					new Balkendiagramm(statistikUebergabeBereich);
				}

				else if (kw == 0 && jahr != 0) {
					List<ComStatistik> statistikPufferBereich = port
							.getBereichsStatistikJahr(Benutzername, Passwort,
									jahr);
					List<ComStatistik> statistikUebergabeBereich = new ArrayList<ComStatistik>();

					boolean gesamtstatistik = false;
					// BefŸllung der Statistikübergabe
					if (!(orgaEinheit == "Gesamtstatistik")) {
						// BefŸllung BereichŸbergabe
						for (ComStatistik s : statistikPufferBereich) {
							if (orgaEinheit.equals(s.getOrgaEinheitBez())) {
								statistikUebergabeBereich.add(s);
							}
						}

					} else {
						statistikUebergabeBereich = statistikPufferBereich;
						gesamtstatistik = true;
					}

					new Balkendiagramm(statistikUebergabeBereich);
				} else {
					statistikKeineWerte();
				}
				kw = 0;
				jahr = 0;
			}
		});
		
		// Statistik Hilfe - Button
		statistikHilfeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StatistikHilfe StatistikHilfe = new StatistikHilfe();
				StatistikHilfe.setVisible(true);
			}
		});
	}

	// Dynamische Erstellung von Table fŸr Stricheln
	private void rowmachen() {
		
		panelTable = new JPanel();
		panelTable.setLayout(null);
		panelTable.setPreferredSize(new Dimension(460,50+MeineListe.size()*25));
		scrollTable = new JScrollPane(panelTable);

		scrollTable.setBounds(10, 65, 490, 219);
		panelStricheln.add(scrollTable);
		
		
		int zaehler = 0;
		listeStrichanzahl = new ArrayList<JTextField>();
		listeStricharten = new ArrayList<JLabel>();
		listeWoche = new ArrayList<JComboBox<String>>();
		
		JLabel header = new JLabel("Strichart:");
		header.setBounds(10, 10, 100, 20);
		panelTable.add(header);
		
		header = new JLabel("Anzahl neuer Striche:");
		header.setBounds(140, 10, 200, 20);
		panelTable.add(header);
		
		header = new JLabel("Kalenderwoche:");
		header.setBounds(300, 10, 100, 20);
		panelTable.add(header);
		
		for (ComStrichart s : MeineListe) {
			
			JLabel label = new JLabel(s.getStrichBez());
			label.setBounds(10, 50+25*zaehler, 100, 20);
			listeStricharten.add(label);
			panelTable.add(label);
			
			JTextField eingabe = new JTextField();
			eingabe.setBounds(150, 50+25*zaehler, 100, 20);
			listeStrichanzahl.add(eingabe);
			panelTable.add(eingabe);
			
			String[] wocheAuswahl = {"aktuelle", "vorherige"};
			JComboBox<String> woche = new JComboBox<String>(wocheAuswahl);
			woche.setBounds(300, 50+25*zaehler, 100, 20);
			listeWoche.add(woche);
			panelTable.add(woche);
			
			zaehler++;
			
			panelTable.updateUI();
		}
	}
	public void schliessenDialog() {
		int ergebnis = JOptionPane.showConfirmDialog(frmElasticoElektronische,
				"Möchten Sie die Anwendung wirklich beenden?",
				"Anwendung beenden", JOptionPane.YES_NO_OPTION);
		if (ergebnis == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public void statistikKeineWerte() {
		JOptionPane.showMessageDialog(frmElasticoElektronische,
				"Bitte wählen Sie Werte zur Anzeige der Statistik aus.");
	}
}