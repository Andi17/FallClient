package gui;

import java.awt.Color;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import Webservice.ComStatistik;
import Webservice.ComStrichart;
import Webservice.Webservice;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
	
	JPanel panelStricheln = new JPanel();
	JPanel panelStatistik = new JPanel();
	JPanel panelAdministration = new JPanel();

	public Hauptseite(String Benutzername, String Passwort, Webservice port) {
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.port = port;

		initialize();
	}

	public void schliessenDialog() {
		int ergebnis = JOptionPane.showConfirmDialog(frmElasticoElektronische,
				"Mˆchten Sie die Anwendung wirklich beenden?",
				"Anwendung beenden", JOptionPane.YES_NO_OPTION);
		if (ergebnis == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public void statistikKeineWerte() {
		JOptionPane.showMessageDialog(frmElasticoElektronische,
				"Bitte w‰hlen Sie Werte zur Anzeige der Statistik aus.");
	}

	List<ComStrichart> MeineListe = null;
	List<ComStrichart> suchListe = new ArrayList<ComStrichart>();
	private JTextField textField;
	private JButton resetButton;
	private JButton abschickenButton;
	private String[][] rowData;
	private String[][] rowData_1;

	JComboBox<String> dropKw;

	private int anzahlStricharten = 0;
	private String[][] uebergabeArray;
	private JTable table;
	private JTable table_1;

	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	private void initialize() {
		frmElasticoElektronische = new JFrame();
		frmElasticoElektronische.setLocation(new Point(200, 100));
		frmElasticoElektronische.setResizable(false);
		frmElasticoElektronische
				.setTitle("Elastico - Elektronische Arbeitsschritt / Information / Control / Observation");
		frmElasticoElektronische.setBackground(new Color(255, 250, 240));
		frmElasticoElektronische.getContentPane().setBackground(
				new Color(255, 250, 240));
		frmElasticoElektronische.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(
						Hauptseite.class
								.getResource("/gui/images/LogoFinal.png")));
		frmElasticoElektronische.setBounds(100, 100, 800, 400);
		frmElasticoElektronische.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmElasticoElektronische.getContentPane().setLayout(null);

		MeineListe = port.getStrichelArten(Benutzername, Passwort, true);
		anzahlStricharten = MeineListe.size();
		uebergabeArray = new String[anzahlStricharten][4];

		// Hier erzeugen wir unsere JPanels
		panelStricheln = new JPanel();
		panelStatistik = new JPanel();
		panelAdministration = new JPanel();

		// Hier setzen wir die Hintergrundfarben für die JPanels
		panelStricheln.setBackground(new Color(255, 250, 240));
		panelStatistik.setBackground(new Color(255, 250, 240));
		panelAdministration.setBackground(new Color(255, 250, 240));

		// Erzeugung eines JTabbedPane-Objektes
		JTabbedPane tabpane = new JTabbedPane(JTabbedPane.TOP);
		tabpane.setForeground(Color.BLACK);
		tabpane.setBackground(new Color(255, 250, 240));
		tabpane.setBounds(23, 6, 754, 325);

		// Hier werden die JPanels als Registerkarten hinzugefügt
		panelStricheln.setLayout(null);
		if (port.anzeige(Benutzername, Passwort).contains(1)) {
			tabpane.addTab("Stricheln", panelStricheln);
		}

		// Abschicken Button
		abschickenButton = new JButton("Abschicken");
		abschickenButton.setBounds(540, 255, 115, 30);
		panelStricheln.add(abschickenButton);
		abschickenButton.setBackground(Color.ORANGE);

		// Reset Button
		resetButton = new JButton("Reset");
		resetButton.setBounds(540, 63, 100, 30);
		panelStricheln.add(resetButton);
		resetButton.setBackground(Color.WHITE);

		// Textfield
		textField = new JTextField();
		textField.setBounds(10, 14, 434, 26);
		panelStricheln.add(textField);
		textField.setColumns(10);

		// Suche Button
		JButton sucheButton = new JButton("Suche");
		sucheButton.setBounds(540, 12, 100, 30);
		panelStricheln.add(sucheButton);
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
					int suchID = 0;
					try {
						suchID = Integer.parseInt(sucheInhalt);
					} catch (NumberFormatException e) {
					}

					for (ComStrichart s : MeineListe) {
							if ((s.getStrichBez().contains(sucheInhalt))) {
								suchListe.add(s);
							}
							else{
								nichtGesuchtListe.add(s);
							}
					}
					int suchzaehler = 0;
					
					for (ComStrichart s : suchListe) {

						rowData[suchzaehler][0] = "" + s.getIdStrichart();
						rowData[suchzaehler][1] = "" + s.getStrichBez();
						rowData_1[suchzaehler][0] = "";
						rowData_1[suchzaehler][1] = "aktuelle";
						suchzaehler++;

					}
					for (int i=0; i<nichtGesuchtListe.size(); i++) {
						rowData[suchzaehler][0] = "" + nichtGesuchtListe.get(i).getIdStrichart();
						rowData[suchzaehler][1] = "" + nichtGesuchtListe.get(i).getStrichBez();
						rowData_1[suchzaehler][0] = "";
						rowData_1[suchzaehler][1] = "aktuelle";
						suchzaehler++;
					}

					table.updateUI();
					table.repaint();
					table_1.updateUI();
					table_1.repaint();
				}

				

			}
		});
		sucheButton.setBackground(Color.ORANGE);

		// HilfeButton
		JButton hilfeButton = new JButton("");
		hilfeButton
				.setIcon(new ImageIcon(
						Login.class
								.getResource("/gui/images/IconFragezeichenTransparentFertig3030.png")));
		hilfeButton.setBorderPainted(false);
		hilfeButton.setBounds(710, 11, 30, 30);
		panelStricheln.add(hilfeButton);
		hilfeButton.setBackground(new Color(255, 250, 240));
		hilfeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StrichelnHilfe StrichelnHilfe = new StrichelnHilfe();
				StrichelnHilfe.setVisible(true);
			}
		});
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(null);
				rowmachen();
				table.updateUI();
				table.repaint();
				table_1.updateUI();
				table_1.repaint();
			}
		});
		abschickenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<String[]> gefuellteZeilen = new ArrayList<String[]>();
				boolean abschickenErlaubt = true;
				for (int i = 0; i < anzahlStricharten; i++) {
					try {
						int ueberpruefen = 0;
						if(rowData_1[i][0]!="")ueberpruefen = Integer.parseInt(rowData_1[i][0]);
						if (!rowData_1[i][0].isEmpty() && ueberpruefen != 0) {
							String[] werteGefuellteZeilen = new String[4];
							werteGefuellteZeilen[0] = rowData[i][0];
							werteGefuellteZeilen[1] = rowData[i][1];
							werteGefuellteZeilen[2] = rowData_1[i][0];
							werteGefuellteZeilen[3] = rowData_1[i][1];
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
					uebergabeArray = new String[menge][4];
					for (int o = 0; o < menge; o++) {
						uebergabeArray[o][0] = gefuellteZeilen.get(o)[0];
						uebergabeArray[o][1] = gefuellteZeilen.get(o)[1];
						uebergabeArray[o][2] = gefuellteZeilen.get(o)[2];
						uebergabeArray[o][3] = gefuellteZeilen.get(o)[3];
					}
					KontrolleStricheln fensterwechselKontrolle = new KontrolleStricheln(
							uebergabeArray, menge, Benutzername, Passwort, port);
					fensterwechselKontrolle.setVisible(true);
				}
				
			}
		});
		if (port.anzeige(Benutzername, Passwort).contains(2)) {
			tabpane.addTab("Statistik", panelStatistik);
		}
		panelStatistik.setLayout(null);

		if (port.anzeige(Benutzername, Passwort).contains(3)) {
			tabpane.addTab("Administration", panelAdministration);
		}
		panelAdministration.setLayout(null);

		JLabel lblBenutzerverwaltung = new JLabel("Benutzerverwaltung:");
		lblBenutzerverwaltung.setBounds(6, 6, 127, 16);
		panelAdministration.add(lblBenutzerverwaltung);

		JLabel lblOrganisationseinheitenverwaltung = new JLabel(
				"Organisationseinheitenverwaltung:");
		lblOrganisationseinheitenverwaltung.setBounds(6, 97, 252, 16);
		panelAdministration.add(lblOrganisationseinheitenverwaltung);

		JLabel lblSystemverwaltung = new JLabel("Systemverwaltung:");
		lblSystemverwaltung.setBounds(6, 183, 175, 16);
		panelAdministration.add(lblSystemverwaltung);

		JButton btnNeuerBenutzer = new JButton("Benutzer anlegen");

		btnNeuerBenutzer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NeuerBenutzer NeuerBenutzer = new NeuerBenutzer(Benutzername,
						Passwort, port);
				NeuerBenutzer.setVisible(true);
			}
		});
		btnNeuerBenutzer.setBounds(6, 34, 150, 30);
		btnNeuerBenutzer.setBackground(Color.WHITE);
		panelAdministration.add(btnNeuerBenutzer);

		JButton btnBenutzerBearbeiten = new JButton("Benutzer bearbeiten");
		btnBenutzerBearbeiten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BearbeitungBenutzer BearbeitungBenutzer = new BearbeitungBenutzer(
						Benutzername, Passwort, port);
				BearbeitungBenutzer.setVisible(true);
			}
		});
		btnBenutzerBearbeiten.setBounds(166, 34, 150, 30);
		btnBenutzerBearbeiten.setBackground(Color.white);
		panelAdministration.add(btnBenutzerBearbeiten);

		JButton btnBenutzerLschen = new JButton("Benutzer l\u00F6schen");
		btnBenutzerLschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoescheBenutzer LoescheBenutzer = new LoescheBenutzer(
						Benutzername, Passwort, port);
				LoescheBenutzer.setVisible(true);
			}
		});
		btnBenutzerLschen.setBounds(328, 34, 150, 30);
		btnBenutzerLschen.setBackground(Color.white);
		panelAdministration.add(btnBenutzerLschen);

		JButton btnNeueOrganisationseinheit = new JButton(
				"Organisationseinheit anlegen");
		btnNeueOrganisationseinheit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NeueOrgaEinheit NeueOrgaEinheit = new NeueOrgaEinheit(
						Benutzername, Passwort, port);
				NeueOrgaEinheit.setVisible(true);
			}
		});
		btnNeueOrganisationseinheit.setBounds(5, 125, 200, 30);
		btnNeueOrganisationseinheit.setBackground(Color.white);
		panelAdministration.add(btnNeueOrganisationseinheit);

		JButton btnOrgaeinheitndern = new JButton(
				"Organisationseinheit \u00E4ndern");
		btnOrgaeinheitndern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BearbeitungOrgaEinheit BearbeitungOrgaEinheit = new BearbeitungOrgaEinheit(
						Benutzername, Passwort, port);
				BearbeitungOrgaEinheit.setVisible(true);
			}
		});
		btnOrgaeinheitndern.setBounds(215, 125, 200, 30);
		btnOrgaeinheitndern.setBackground(Color.white);
		panelAdministration.add(btnOrgaeinheitndern);

		JButton hbutton = new JButton("");
		hbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Administrationshilfe Administrationshilfe = new Administrationshilfe();
				Administrationshilfe.setVisible(true);
			}
		});
		hbutton.setBounds(710, 11, 30, 30);
		hbutton.setIcon(new ImageIcon(
				Login.class
						.getResource("/gui/images/IconFragezeichenTransparentFertig3030.png")));
		hbutton.setBorderPainted(false);
		hbutton.setBackground(new Color(255, 250, 240));
		panelAdministration.add(hbutton);

		JButton btnStrichkategorieAnlegen = new JButton(
				"Strichkategorie anlegen");
		btnStrichkategorieAnlegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NeueStrichkategorie StrichkategorieHinzu = new NeueStrichkategorie(
						Benutzername, Passwort, port);
				StrichkategorieHinzu.setVisible(true);
			}
		});
		btnStrichkategorieAnlegen.setBounds(6, 211, 200, 30);
		btnStrichkategorieAnlegen.setBackground(Color.white);
		panelAdministration.add(btnStrichkategorieAnlegen);

		JButton btnStrichkategoriendern = new JButton(
				"Strichkategorie \u00E4ndern");
		btnStrichkategoriendern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnStrichkategoriendern.setBounds(215, 211, 200, 30);
		btnStrichkategoriendern.setBackground(Color.white);
		panelAdministration.add(btnStrichkategoriendern);

		// JTabbedPane wird unserem Dialog hinzugefügt
		frmElasticoElektronische.getContentPane().add(tabpane);

		JButton btnNewButton_2 = new JButton("Beenden");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnwendungAbbruch frmAnwendungAbbruch = new AnwendungAbbruch();
				frmAnwendungAbbruch.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(662, 337, 115, 30);
		btnNewButton_2.setBackground(Color.WHITE);
		frmElasticoElektronische.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HauptseiteHilfe frmHauptmenueHilfe = new HauptseiteHilfe();
				frmHauptmenueHilfe.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(23, 337, 30, 30);
		btnNewButton_1.setBackground(new Color(255, 250, 240));
		btnNewButton_1
				.setIcon(new ImageIcon(
						Login.class
								.getResource("/gui/images/IconFragezeichenTransparentFertig3030.png")));
		btnNewButton_1.setBorderPainted(false);
		frmElasticoElektronische.getContentPane().add(btnNewButton_1);

		JLabel lblEingeloggtAlsJanis = new JLabel("Eingeloggt als: "
				+ Benutzername);
		lblEingeloggtAlsJanis.setBounds(74, 342, 180, 16);
		frmElasticoElektronische.getContentPane().add(lblEingeloggtAlsJanis);

		/********** Statistik **********/
		// Erstellung Statistikseite
		// Label
		JLabel lblZeitraum = new JLabel("Statistik zu:");
		lblZeitraum.setBounds(40, 43, 85, 16);
		panelStatistik.add(lblZeitraum);
		// ComboBox
		// aktuelles Datum und KW ermitteln
		final Calendar jahrKW = new GregorianCalendar();
		Date date = new Date();
		jahrKW.setTime(date);
		ArrayList<String> strKWdynamisch = new ArrayList<String>();
		int kwjahr = jahrKW.get(Calendar.WEEK_OF_YEAR);
		for (int i = 0; i <= kwjahr; i++) {
			strKWdynamisch.add("" + i);
		}
		// String fuer aktuelle KW erstellen
		String[] strKWstatisch = new String[strKWdynamisch.size()];
		for (int i = 1; i < strKWstatisch.length; i++) {
			strKWstatisch[i] = strKWdynamisch.get(i);
		}
		strKWstatisch[0] = "KW";
		// String fuer 52KW Jahr erstellen
		String[] strKurzesKWJahr = new String[53];
		for (int i = strKurzesKWJahr.length - 1; i > 0; i--) {
			strKurzesKWJahr[i] = "" + i;
		}
		strKurzesKWJahr[0] = "KW";
		// String fuer 53KW Jahr erstellen
		String[] strLangesKWJahr = new String[54];
		for (int i = strLangesKWJahr.length - 1; i > 0; i--) {
			strLangesKWJahr[i] = "" + i;
		}
		strLangesKWJahr[0] = "KW";
		// Fallwerte fuer ComboBox's deklarieren
		final ComboBoxModel[] comboxKWmodel = new ComboBoxModel[4];
		comboxKWmodel[0] = new DefaultComboBoxModel(strKWstatisch);
		comboxKWmodel[1] = new DefaultComboBoxModel(strKurzesKWJahr);
		comboxKWmodel[2] = new DefaultComboBoxModel(strLangesKWJahr);
		comboxKWmodel[3] = new DefaultComboBoxModel(new String[] { "--" });
		// 1990 - aktuelles Jahr -> Bei Einfuehrung am 01.01.2014 Aederungen auf
		// 2014
		int intStartjahr = 1990;
		Calendar nowjahr = Calendar.getInstance();
		int intjahraktuell = nowjahr.get(Calendar.YEAR);
		ArrayList<String> strjahr = new ArrayList<String>();
		for (int i = intjahraktuell; i >= intStartjahr; i--) {
			strjahr.add("" + i);
		}
		// Combo Jahr erstellen
		final JComboBox comboJahr = new JComboBox();
		comboJahr.setBounds(164, 37, 85, 28);
		comboJahr.setEditable(false);
		comboJahr.setMaximumRowCount(8);
		comboJahr.addItem("Jahr");
		for (String s : strjahr)
			comboJahr.addItem(s);
		comboJahr.setSelectedItem("Jahr");
		panelStatistik.add(comboJahr);
		// Combo KW erstellen
		final JComboBox comboKW = new JComboBox();
		comboKW.setBounds(282, 37, 73, 28);
		comboKW.setEditable(false);
		comboKW.setMaximumRowCount(8);
		comboKW.setModel(comboxKWmodel[3]);
		panelStatistik.add(comboKW);

		// TODO Combo AnzeigeFilter erstellen

		final JComboBox comboAnzeigeFilter = new JComboBox();
		comboAnzeigeFilter.setBounds(388, 37, 200, 28);
		comboAnzeigeFilter.setEditable(false);
		comboAnzeigeFilter.setMaximumRowCount(8);
		// Aufruf statistikUebergabe um die ComboBox zu befuellen (als Datum
		// wird die aktuelle KW im aktuellen Jahr mitgegeben)
		List<ComStatistik> statistikComboBox = port.getStrichartStatistik(
				Benutzername, Passwort, kwjahr, intjahraktuell);
		// Befüllung Array fuer ComboBox
		List<String> orgaEinlesen = new ArrayList<String>();
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

		// Befüllung ComboBox
		comboAnzeigeFilter.addItem("Gesamtstatistik");
		for (int i = 0; i < orgaAusgabe.length; i++) {
			if (!(orgaAusgabe[i] == "" || orgaAusgabe[i] == null))
				comboAnzeigeFilter.addItem(orgaAusgabe[i]);
		}

		comboAnzeigeFilter.setSelectedItem("Gesamtstatistik");
		panelStatistik.add(comboAnzeigeFilter);

		// TODO Codesegment Ende

		// Frame visible
		frmElasticoElektronische.setVisible(true);
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
						comboKW.setSelectedItem("KW");
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
							comboKW.setSelectedItem("KW");
						} else if (wahlJahreslaenge == 53) { // 53KW
							comboKW.setModel(comboxKWmodel[2]);
							comboKW.setSelectedItem("KW");
						} else { // error
							System.err.println("ERROR: Wrong KW-Count: "
									+ wahlJahreslaenge + "!");
						}
					}
				}
			}
		});

		// //TODO Buttons deklarieren

		JButton btnStatistik = new JButton("Statistik");
		btnStatistik.addActionListener(new ActionListener() {
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
					// Auto-generated catch block
				}

				// Ausgabe, wenn KW und Jahr gewaehlt
				if (kw != 0 && jahr != 0) {
					// TODO
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
					// TODO
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
		btnStatistik.setBounds(132, 246, 200, 30);
		btnStatistik.setBackground(Color.white);
		panelStatistik.add(btnStatistik);
		
		JButton btnBalkenDiagramm = new JButton("Balkendiagramm");
		btnBalkenDiagramm.setBounds(342, 246, 200, 30);
		btnBalkenDiagramm.setBackground(Color.white);
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
					// Auto-generated catch block
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
				} else {
					statistikKeineWerte();
				}
				kw = 0;
				jahr = 0;
			}
		});
		panelStatistik.add(btnBalkenDiagramm);

		JButton Hilfebutton = new JButton("");
		Hilfebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StatistikHilfe StatistikHilfe = new StatistikHilfe();
				StatistikHilfe.setVisible(true);
			}
		});
		Hilfebutton.setBounds(710, 11, 30, 30);
		Hilfebutton
				.setIcon(new ImageIcon(
						Login.class
								.getResource("/gui/images/IconFragezeichenTransparentFertig3030.png")));
		Hilfebutton.setBorderPainted(false);
		Hilfebutton.setBackground(new Color(255, 250, 240));
		panelStatistik.add(Hilfebutton);

		// Stricheln //

		rowData = new String[anzahlStricharten][2];
		rowData_1 = new String[anzahlStricharten][2];
		rowmachen();

		String[] columnNames = { "Nummer", "Kategorie" };
		String[] columnNames_1 = { "Anzahl", "Kalenderwoche" };
		table = new JTable(rowData, columnNames);
		table.setBackground(new Color(255, 250, 240));
		table.setBorder(new EmptyBorder(1, 2, 1, 1));
		JTableHeader header = table.getTableHeader();
		header.setBounds(10, 65, 245, 24);
		panelStricheln.add(header);
		table.setBounds(10, 90, 245, 195);
		panelStricheln.add(table);
		table.setEnabled(false);

		table_1 = new JTable(rowData_1, columnNames_1);
		table_1.setBackground(new Color(255, 250, 240));
		table_1.setBorder(new EmptyBorder(1, 0, 1, 1));
		JTableHeader header_1 = table_1.getTableHeader();
		header_1.setBounds(256, 65, 245, 24);
		panelStricheln.add(header_1);
		table_1.setBounds(256, 90, 245, 195);
		panelStricheln.add(table_1);

		// Combo Box
		TableColumn sportColumn = table_1.getColumnModel().getColumn(1);
		dropKw = new JComboBox<String>();
		dropKw.addItem("aktuelle");
		dropKw.addItem("vorherige");
		sportColumn.setCellEditor(new DefaultCellEditor(dropKw));
		dropKw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dropKw.getSelectedItem();
			}
		});
	}

	// Dynamische Erstellung von Table
	private void rowmachen() {
		int zaehler = 0;
		if(uebergabeArray==null)uebergabeArray = new String[MeineListe.size()][4];
		for (ComStrichart s : MeineListe) {
			rowData[zaehler][0] = "" + s.getIdStrichart();
			rowData[zaehler][1] = "" + s.getStrichBez();
			rowData_1[zaehler][0] = "";
			rowData_1[zaehler][1] = "aktuelle";

			uebergabeArray[zaehler][0] = "";
			uebergabeArray[zaehler][1] = "";
			uebergabeArray[zaehler][2] = "";
			uebergabeArray[zaehler][3] = "";
			zaehler++;
		}
	}
}