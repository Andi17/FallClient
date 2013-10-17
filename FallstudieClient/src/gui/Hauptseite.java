package gui;

import java.awt.Color;
import java.awt.EventQueue;

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

import Webservice.ComStrichart;
import Webservice.Webservice;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Toolkit;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


//TODO Alle Knoepfe eingebunden? Fehlt etwas? Vier-Augen-Prinzip
public class Hauptseite {
	
	private String Benutzername;
	private String Passwort;
	private Webservice port;

	public JFrame frmElasticoElektronische;
	

	/**
	 * Create the application.
	 */
	public Hauptseite(String Benutzername, String Passwort, Webservice port) {
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.port = port;
		
		initialize();
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
	
	
	List <ComStrichart> MeineListe= null;
	List <ComStrichart> suchListe =  new ArrayList<ComStrichart>();
	private JTextField textField;
	private JButton resetButton;
	private JButton abschickenButton;
	private String[][] rowData;
	private String[][] rowData_1;
	
	JComboBox<String> dropKw;
	
	private int anzahl = 0;
	private String[][]uebergabeArray;
	String[] abschickListe;
	private JTable table;
	private JTable table_1;
	
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmElasticoElektronische = new JFrame();
		frmElasticoElektronische.setLocation(new Point(200, 100));
		frmElasticoElektronische.setResizable(false);
		frmElasticoElektronische.setTitle("Elastico - Elektronische Arbeitsschritt / Information / Control / Observation");
		frmElasticoElektronische.setBackground(new Color (255,250,240));
		frmElasticoElektronische.getContentPane().setBackground(new Color (255,250,240));
		frmElasticoElektronische.setIconImage(Toolkit.getDefaultToolkit().getImage(Hauptseite.class.getResource("/gui/images/LogoFinal.png")));
		frmElasticoElektronische.setBounds(100, 100, 800, 400);
		frmElasticoElektronische.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmElasticoElektronische.getContentPane().setLayout(null);
		
		MeineListe=port.getStrichelArten(Benutzername, Passwort);
		anzahl = MeineListe.size();
		uebergabeArray= new String[anzahl][4];
		abschickListe = new String [anzahl];
 
        // Hier erzeugen wir unsere JPanels
        JPanel panelMenu = new JPanel();
        JPanel panelStricheln = new JPanel();
        JPanel panelStatistik = new JPanel();
        JPanel panelAdministration = new JPanel();
 
        // Hier setzen wir die Hintergrundfarben fŸr die JPanels
        panelMenu.setBackground(new Color (255,250,240));
        panelStricheln.setBackground(new Color (255,250,240));
        panelStatistik.setBackground(new Color (255,250,240));
        panelAdministration.setBackground(new Color (255,250,240));
 
        // Erzeugung eines JTabbedPane-Objektes
        JTabbedPane tabpane = new JTabbedPane(JTabbedPane.TOP);
        tabpane.setForeground(Color.BLACK);
        tabpane.setBackground(new Color (255,250,240));
        tabpane.setBounds(23, 6, 754, 325);
 
        // Hier werden die JPanels als Registerkarten hinzugefŸgt
        tabpane.addTab("MenŸ", panelMenu);
        panelMenu.setLayout(null);
        
        tabpane.addTab("Startseite", panelMenu);
        tabpane.addTab("Stricheln", panelMenu);
        
      //TODO Stricheln Oberflaeche einbinden
        JLabel lblTodo = new JLabel("");
        lblTodo.setBounds(71, 26, 61, 16);
        panelMenu.add(lblTodo);
        //Reset Button ---------------------------------------------------------------------------
        		
        //Abschicken Button
        abschickenButton = new JButton("Abschicken");
        abschickenButton.setBounds(540, 255, 115, 30);
        panelMenu.add(abschickenButton);
        abschickenButton.setBackground(Color.ORANGE);
        
        //Reset Button ---------------------------------------------------------------------------
        resetButton = new JButton("Reset");
        resetButton.setBounds(540, 63, 100, 30);
        panelMenu.add(resetButton);
        resetButton.setBackground(Color.WHITE);
        // HilfeButton -----------------------------------------
        
        // Textfield 
        textField = new JTextField();
        textField.setBounds(10, 14, 434, 26);
        panelMenu.add(textField);
        textField.setColumns(10);
        
		// Suche Button 
		JButton sucheButton = new JButton("Suche");
		sucheButton.setBounds(540, 12, 100, 30);
		panelMenu.add(sucheButton);
		sucheButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sucheInhalt = textField.getText();
				
				suchListe =  new ArrayList<ComStrichart>();
				
				for ( ComStrichart s : MeineListe){
					try{
					if ((s.getStrichBez().contains(sucheInhalt)) || (s.getIdStrichart()==((Integer.parseInt(sucheInhalt)))))
					{
						suchListe.add(s);
					}
					}
					catch (NumberFormatException e){
						
					}
				}
				int suchzaehler = 0;

				for (ComStrichart s : suchListe){
					
					rowData[suchzaehler][0]=""+s.getIdStrichart();
					rowData[suchzaehler][1]=""+s.getStrichBez();
					rowData_1[suchzaehler][0]="";
					rowData_1[suchzaehler][1]="";
					suchzaehler++;
										
				}
				for (int i = suchListe.size(); i < MeineListe.size(); i++){
					rowData[i][0]="";
					rowData[i][1]="";
					rowData_1[i][0]="";
					rowData_1[i][1]="";
					
				}
				
				table.updateUI();
				table.repaint();
				table_1.updateUI();
				table_1.repaint();
									
			}
		});
		sucheButton.setBackground(Color.ORANGE);
		
		// HilfeButton -----------------------------------------
		JButton hilfeButton = new JButton("");
		hilfeButton.setIcon(new ImageIcon(Login.class.getResource("/gui/images/IconFragezeichenTransparentFertig3030.png")));
		hilfeButton.setBorderPainted(false);
		hilfeButton.setBounds(710, 11, 30, 30);
		panelMenu.add(hilfeButton);
		hilfeButton.setBackground(new Color(255, 250, 240));
		
//		table = new JTable();
//		table.setBounds(33, 79, 170, 90);
//		panelMenu.add(table);
//		
//		table_1 = new JTable();
//		table_1.setBounds(213, 79, 170, 90);
//		panelMenu.add(table_1);
		hilfeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				 StrichelnHilfe fensterwechselHilfe = new StrichelnHilfe();
//				  fensterwechselHilfe.frame.setVisible(true);
				  StrichelnHilfe StrichelnHilfe = new StrichelnHilfe();
				  StrichelnHilfe.setVisible(true);
				  //frmElasticoElektronische.setVisible(false);
				
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

        		 for (int i = 0; i < anzahl; i++) {
        			  
        			  
        			  String auslese = table_1.getValueAt(i, 0).toString();
        			  uebergabeArray[i][0]="";
        			  uebergabeArray[i][1]="";
        			  uebergabeArray[i][2]="";
        			  uebergabeArray[i][3]="";
        			  										  
        			  System.out.println(auslese);
//					  //rowData[i][2]=auslese;

        			  try{int a = Integer.parseInt(auslese);
        			  	System.out.println(auslese+"hallo");
        				if (a>0 || false == rowData[i][2].isEmpty() ){
        				uebergabeArray[i][0]=rowData[i][0];
        				uebergabeArray[i][1]=rowData[i][1];
        				uebergabeArray[i][2]=auslese;
        				uebergabeArray[i][3]=rowData_1[i][1];	
        				
        		  }							
        				else{
        				
        			}
        			}
        				
        			catch ( NumberFormatException e ){
        				
        			}
        			  

        		  }
  
        		  KontrolleStricheln fensterwechselKontrolle = new KontrolleStricheln(uebergabeArray, anzahl,Benutzername,Passwort,port);
        		  fensterwechselKontrolle.frame.setVisible(true); 
        		   
        	}
        });
        tabpane.addTab("Statistik", panelStatistik);
        panelStatistik.setLayout(null);
        
      //TODO Statistik Oberflaeche einbinden
        JLabel lblTodo_1 = new JLabel("");
        lblTodo_1.setBounds(64, 70, 61, 16);
        panelStatistik.add(lblTodo_1);
        tabpane.addTab("Administration", panelAdministration);
        panelAdministration.setLayout(null);
        
        JLabel lblBenutzerverwaltung = new JLabel("Benutzerverwaltung:");
        lblBenutzerverwaltung.setBounds(6, 6, 127, 16);
        panelAdministration.add(lblBenutzerverwaltung);
        
        JLabel lblOrganisationseinheitenverwaltung = new JLabel("Organisationseinheitenverwaltung:");
        lblOrganisationseinheitenverwaltung.setBounds(6, 97, 252, 16);
        panelAdministration.add(lblOrganisationseinheitenverwaltung);
        
        JLabel lblSystemverwaltung = new JLabel("Systemverwaltung:");
        lblSystemverwaltung.setBounds(6, 183, 175, 16);
        panelAdministration.add(lblSystemverwaltung);
        
        JButton btnNeuerBenutzer = new JButton("Benutzer anlegen");
        btnNeuerBenutzer.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		NeuerBenutzer NeuerBenutzer = new NeuerBenutzer(Benutzername, Passwort, port);
        		NeuerBenutzer.setVisible(true); 
        	}
        });
        btnNeuerBenutzer.setBounds(6, 34, 137, 40);
        panelAdministration.add(btnNeuerBenutzer);
        
        JButton btnBenutzerBearbeiten = new JButton("Benutzer bearbeiten");
        btnBenutzerBearbeiten.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		BearbeitungBenutzer BearbeitungBenutzer = new BearbeitungBenutzer(Benutzername, Passwort, port);
        		BearbeitungBenutzer.setVisible(true);
        	}
        });
        btnBenutzerBearbeiten.setBounds(155, 34, 144, 40);
        panelAdministration.add(btnBenutzerBearbeiten);
        
        JButton btnBenutzerLschen = new JButton("Benutzer l\u00F6schen");
        btnBenutzerLschen.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		LoescheBenutzer LoescheBenutzer = new LoescheBenutzer(Benutzername, Passwort, port);
        		LoescheBenutzer.setVisible(true);
        	}
        });
        btnBenutzerLschen.setBounds(311, 34, 127, 40);
        panelAdministration.add(btnBenutzerLschen);
        
        JButton btnNeueOrganisationseinheit = new JButton("Organisationseinheit anlegen");
        btnNeueOrganisationseinheit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		NeueOrgaEinheit  NeueOrgaEinheit = new NeueOrgaEinheit(Benutzername, Passwort, port);
        		NeueOrgaEinheit.setVisible(true);
        	}
        });
        btnNeueOrganisationseinheit.setBounds(6, 125, 208, 40);
        panelAdministration.add(btnNeueOrganisationseinheit);
        
        JButton btnOrgaeinheitndern = new JButton("Organisationseinheit \u00E4ndern");
        btnOrgaeinheitndern.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		BearbeitungOrgaEinheit BearbeitungOrgaEinheit = new BearbeitungOrgaEinheit(Benutzername, Passwort, port);
        		BearbeitungOrgaEinheit.setVisible(true);
        		}
        });
        btnOrgaeinheitndern.setBounds(226, 125, 208, 40);
        panelAdministration.add(btnOrgaeinheitndern);
        
        JButton hbutton = new JButton("");
        hbutton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Administrationshilfe Administrationshilfe = new Administrationshilfe();
        		Administrationshilfe.setVisible(true);
        		}
        });
        hbutton.setBounds(710, 11, 30, 30);
		hbutton.setIcon(new ImageIcon(Login.class.getResource("/gui/images/IconFragezeichenTransparentFertig3030.png")));
		hbutton.setBorderPainted(false);
		hbutton.setBackground(new Color (255,250,240));
        panelAdministration.add(hbutton);
        
        JButton btnStrichkategorieAnlegen = new JButton("Strichkategorie anlegen");
        btnStrichkategorieAnlegen.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		NeueStrichkategorie StrichkategorieHinzu = new NeueStrichkategorie(Benutzername, Passwort, port);
        		StrichkategorieHinzu.setVisible(true);
        	}
        });
        btnStrichkategorieAnlegen.setBounds(6, 211, 180, 40);
        panelAdministration.add(btnStrichkategorieAnlegen);
        
        JButton btnStrichkategoriendern = new JButton("Strichkategorie \u00E4ndern");
        btnStrichkategoriendern.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
       // 		BearbeitungStrichkategorie BearbeitungStrichkategorie = new BearbeitungStrichkategorie();
        //		BearbeitungStrichkategorie.setVisible(true);
        	}
        });
        btnStrichkategoriendern.setBounds(198, 211, 180, 40);
        panelAdministration.add(btnStrichkategoriendern);
 
        // JTabbedPane wird unserem Dialog hinzugefŸgt
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
        btnNewButton_1.setBackground( new Color (255,250,240));
		btnNewButton_1.setIcon(new ImageIcon(Login.class.getResource("/gui/images/IconFragezeichenTransparentFertig3030.png")));
		btnNewButton_1.setBorderPainted(false);
        frmElasticoElektronische.getContentPane().add(btnNewButton_1);
        
        JLabel lblEingeloggtAlsJanis = new JLabel("Eingeloggt als: "+Benutzername);
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

		// String für aktuelle KW erstellen
		String[] strKWstatisch = new String[strKWdynamisch.size()];
		for (int i = 1; i < strKWstatisch.length; i++) {
			strKWstatisch[i] = strKWdynamisch.get(i);
		}
		strKWstatisch[0] = "KW";

		// String für 52KW Jahr erstellen
		String[] strKurzesKWJahr = new String[53];
		for (int i = strKurzesKWJahr.length - 1; i > 0; i--) {
			strKurzesKWJahr[i] = "" + i;
		}
		strKurzesKWJahr[0] = "KW";

		// String für 53KW Jahr erstellen
		String[] strLangesKWJahr = new String[54];
		for (int i = strLangesKWJahr.length - 1; i > 0; i--) {
			strLangesKWJahr[i] = "" + i;
		}
		strLangesKWJahr[0] = "KW";

		// Füllwerte für Combobox's deklarieren
		final ComboBoxModel[] comboxKWmodel = new ComboBoxModel[4];
		comboxKWmodel[0] = new DefaultComboBoxModel(strKWstatisch);
		comboxKWmodel[1] = new DefaultComboBoxModel(strKurzesKWJahr);
		comboxKWmodel[2] = new DefaultComboBoxModel(strLangesKWJahr);
		comboxKWmodel[3] = new DefaultComboBoxModel(new String[] { "--" });

		// 1990 - aktuelles Jahr
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

		// Frame visible
		frmElasticoElektronische.setVisible(true);

		// ItemListener in JahresComboBox implementieren
		comboJahr.addItemListener(new ItemListener() {
			String strJahrwahl = "";
			int intJahrwahl = -10;

			
			public void itemStateChanged(ItemEvent e) {

				JComboBox selectedJahr = (JComboBox) e.getSource();

				// aktuell gewähltes Jahr ermitteln
				if (strJahrwahl != (String) selectedJahr.getSelectedItem()) {
					strJahrwahl = (String) selectedJahr.getSelectedItem();

					if (selectedJahr.getSelectedItem() == "Jahr") {
						intJahrwahl = -1;
					}

					else if (selectedJahr.getSelectedItem() != "Jahr") {
						intJahrwahl = Integer.parseInt(strJahrwahl);
					}
					// KW im aktuellen Jahr
					if (jahrKW.get(Calendar.YEAR) == intJahrwahl) {
						comboKW.setModel(comboxKWmodel[0]);
						comboKW.setSelectedItem("KW");
					}

					// KW ohne Belegung, da kein Jahr gewählt
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
		
		// Buttons deklarieren
		JButton btnGesamtstatistik = new JButton("Statistik");
		btnGesamtstatistik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO setGesamtStatistikText(datenZurAusgabe);
				int kw = 0;
				int jahr = 0;
				try {
					Object b = comboJahr.getSelectedItem();
					jahr = Integer.parseInt(b.toString());
					Object a = comboKW.getSelectedItem();
					kw = Integer.parseInt(a.toString());
				} catch (Exception e) {
					// TODO Auto-generated catch block
				}
				if (!(kw == 0 && jahr == 0)) {
					Statistik frmStatistik = new Statistik(frmElasticoElektronische.getX()-50,
							frmElasticoElektronische.getY()-50, "Gesamtstatistik", kw, jahr,Benutzername,Passwort,port);
					frmStatistik.setVisible(true);
					//frmElasticoElektronische.setVisible(false);// NEW
				} else {
					statistikKeineWerte();
				}
				kw = 0;
				jahr = 0;
			}
		});
		btnGesamtstatistik.setBounds(232, 246, 100, 30);
		btnGesamtstatistik.setBackground(Color.white);
		panelStatistik.add(btnGesamtstatistik);
		
		 JButton Hilfebutton = new JButton("");
	        Hilfebutton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		StatistikHilfe StatistikHilfe = new StatistikHilfe();
	        		StatistikHilfe.setVisible(true);
	        		}
	        });
	        Hilfebutton.setBounds(710, 11, 30, 30);
			Hilfebutton.setIcon(new ImageIcon(Login.class.getResource("/gui/images/IconFragezeichenTransparentFertig3030.png")));
			Hilfebutton.setBorderPainted(false);
			Hilfebutton.setBackground(new Color (255,250,240));
	        panelStatistik.add(Hilfebutton);
        
//								Stricheln					//
	        
	        
		rowData = new String[anzahl][2]; 
		rowData_1 = new String[anzahl][2];
		rowmachen();
		
		String[] columnNames = {
		        "Nummer", "Kategorie"
		};
		String[] columnNames_1 = {
				"Anzahl", "Kalenderwoche"
		};
		table = new JTable(rowData, columnNames);
		table.setBackground(new Color(255, 250, 240));
		table.setBorder(new EmptyBorder(1, 2, 1, 1));
		JTableHeader header = table.getTableHeader();
		header.setBounds(10, 65, 245, 24);
		panelMenu.add(header);
		table.setBounds(10, 90, 245, 195);
		panelMenu.add(table);
		table.setEnabled(false);
		
		table_1 = new JTable(rowData_1, columnNames_1);
		table_1.setBackground(new Color(255, 250, 240));
		table_1.setBorder(new EmptyBorder(1, 0, 1, 1));
		JTableHeader header_1 = table_1.getTableHeader();
		header_1.setBounds(256, 65, 245, 24);
		panelMenu.add(header_1);
		table_1.setBounds(256, 90, 245, 195);
		panelMenu.add(table_1);
		
		
		//Combo Box
		TableColumn sportColumn = table_1.getColumnModel().getColumn(1);
		Calendar calendar = new GregorianCalendar();	    
		System.out.println("Kalenderwoche:" + 
						calendar.get(Calendar.WEEK_OF_YEAR));
		int aktuelleKw = calendar.get(Calendar.WEEK_OF_YEAR);
		int vorherigeKw = aktuelleKw-1;
		dropKw = new JComboBox<String>();
		dropKw.addItem("aktuelle");
		dropKw.addItem("vorherige");
		dropKw.addItem("");
		sportColumn.setCellEditor(new DefaultCellEditor(dropKw));
		dropKw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String stringAuswahl= (String) dropKw.getSelectedItem();
				//int auswahl = Integer.parseInt(stringAuswahl);
				//int zeile =dropKw.getSelectedIndex();
			}
		
		});
		

	}
	
	// Dynamische Erstellung von Table
		private void rowmachen(){
			
			int zaehler=0;
			for (ComStrichart s : MeineListe){
				rowData[zaehler][0]=""+s.getIdStrichart();
				rowData[zaehler][1]=""+s.getStrichBez();
				rowData_1[zaehler][0]="";
				rowData_1[zaehler][1]="";
				
				uebergabeArray[zaehler][0]="";
				uebergabeArray[zaehler][1]="";
				uebergabeArray[zaehler][2]="";
				uebergabeArray[zaehler][3]="";
				zaehler++;
			}

		}
	}

