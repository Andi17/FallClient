package gui;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLabel;

import Webservice.Webservice;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Point;


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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmElasticoElektronische = new JFrame();
		frmElasticoElektronische.setLocation(new Point(200, 100));
		frmElasticoElektronische.setResizable(false);
		frmElasticoElektronische.setTitle("Elastico - Elektronische Arbeitsschritt / Information / Control / Observation");
		frmElasticoElektronische.setBackground(Color.WHITE);
		frmElasticoElektronische.getContentPane().setBackground(Color.WHITE);
		frmElasticoElektronische.setIconImage(Toolkit.getDefaultToolkit().getImage(Hauptseite.class.getResource("/gui/images/LogoFinal.png")));
		frmElasticoElektronische.setBounds(100, 100, 801, 400);
		frmElasticoElektronische.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmElasticoElektronische.getContentPane().setLayout(null);
 
        // Hier erzeugen wir unsere JPanels
        JPanel panelMenu = new JPanel();
        JPanel panelStricheln = new JPanel();
        JPanel panelStatistik = new JPanel();
        JPanel panelAdministration = new JPanel();
 
        // Hier setzen wir die Hintergrundfarben für die JPanels
        panelMenu.setBackground(Color.WHITE);
        panelStricheln.setBackground(Color.WHITE);
        panelStatistik.setBackground(Color.WHITE);
        panelAdministration.setBackground(Color.WHITE);
 
        // Erzeugung eines JTabbedPane-Objektes
        JTabbedPane tabpane = new JTabbedPane(JTabbedPane.TOP);
        tabpane.setForeground(Color.BLACK);
        tabpane.setBackground(Color.WHITE);
        tabpane.setBounds(23, 6, 754, 325);
 
        // Hier werden die JPanels als Registerkarten hinzugefügt
        tabpane.addTab("Menü", panelMenu);
        panelMenu.setLayout(null);
        
        tabpane.addTab("Startseite", panelMenu);
        tabpane.addTab("Stricheln", panelMenu);
        
      //TODO Stricheln Oberflaeche einbinden
        JLabel lblTodo = new JLabel("TODO");
        lblTodo.setBounds(71, 26, 61, 16);
        panelMenu.add(lblTodo);
        tabpane.addTab("Statistik", panelStatistik);
        panelStatistik.setLayout(null);
        
      //TODO Statistik Oberflaeche einbinden
        JLabel lblTodo_1 = new JLabel("TODO");
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
        
        JButton button = new JButton("?");
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Administrationshilfe Administrationshilfe = new Administrationshilfe();
        		Administrationshilfe.setVisible(true);
        		}
        });
        button.setBounds(698, 244, 29, 29);
        panelAdministration.add(button);
        
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
 
        // JTabbedPane wird unserem Dialog hinzugefügt
        frmElasticoElektronische.getContentPane().add(tabpane);
        
        JButton btnNewButton_2 = new JButton("Beenden");
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {     		
        		AnwendungAbbruch frmAnwendungAbbruch = new AnwendungAbbruch();
    			frmAnwendungAbbruch.setVisible(true);    		        		
        	}
        });
        btnNewButton_2.setBounds(660, 332, 117, 29);
        frmElasticoElektronische.getContentPane().add(btnNewButton_2);
        
        JButton btnNewButton_1 = new JButton("?");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		HauptseiteHilfe frmHauptmenueHilfe = new HauptseiteHilfe();
        		frmHauptmenueHilfe.setVisible(true);  		
        	}
        });
        btnNewButton_1.setBounds(33, 332, 29, 29);
        frmElasticoElektronische.getContentPane().add(btnNewButton_1);
        
        JLabel lblEingeloggtAlsJanis = new JLabel("Eingeloggt als: "+Benutzername);
        lblEingeloggtAlsJanis.setBounds(74, 337, 180, 16);
        frmElasticoElektronische.getContentPane().add(lblEingeloggtAlsJanis);
        
        
	}
}
