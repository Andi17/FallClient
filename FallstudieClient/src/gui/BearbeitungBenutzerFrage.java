package gui;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JTextPane;

import Webservice.Webservice;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
@SuppressWarnings("serial")
public class BearbeitungBenutzerFrage extends JDialog {
	private String Benutzername;
	private String Passwort;
	private Webservice port;
	private BearbeitungBenutzer fenster;
	private String aenderungBenutzername;
	private String neuerBenutzername;
	private String neuesPasswort;
	private String neueOrgaEinheitBez;
	private boolean neuerZustand;
	private boolean zustandGeaendert;
	private final JPanel contentPanel = new JPanel();

	public BearbeitungBenutzerFrage(String Benutzername, String Passwort, Webservice port, BearbeitungBenutzer fenster, String aenderungBenutzername, String NeuesPasswort, String neuerBenutzername, String orgaEinheitBez, boolean zustand, boolean zustandGeaendert) {
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.neuesPasswort = NeuesPasswort;
		this.neuerBenutzername = neuerBenutzername;
		this.port = port;
		this.fenster = fenster;
		this.aenderungBenutzername = aenderungBenutzername;
		this.neueOrgaEinheitBez = orgaEinheitBez;
		this.neuerZustand = zustand;
		this.zustandGeaendert = zustandGeaendert;
		initialize();
	}
	private void initialize() {
		setTitle("Benutzer - Bearbeiten");
		setResizable(false);
		setBackground(new Color(255, 250, 240));
		setBounds(100, 100, 500, 280);
		setModal(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 250, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("Ja");
			okButton.setBackground(Color.ORANGE);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					boolean passwortgeaendert = true;
					boolean orgageaendert = true;
					boolean neuername = true;
					if(neuerZustand){
						port.passwortEntsperren(Benutzername, Passwort, aenderungBenutzername);
					}
					else{
						port.passwortSperren(aenderungBenutzername);
					}
					if (!neuesPasswort.equals("")) {
						passwortgeaendert = port.neuesPasswortSetzen(Benutzername, Passwort, aenderungBenutzername,	neuesPasswort);
					}
					if (!neueOrgaEinheitBez.equals("")) {
						orgageaendert = port.benutzerOrgaEinheitAendern(Benutzername, Passwort, aenderungBenutzername, neueOrgaEinheitBez);
					}
					if (!neuerBenutzername.equals("")) {
						neuername = port.benutzernameAendern(Benutzername, Passwort, aenderungBenutzername,	neuerBenutzername);
					}
					if (passwortgeaendert && orgageaendert && neuername) {
						ErfolgEingabe ErfolgEingabe = new ErfolgEingabe();
						ErfolgEingabe.setVisible(true);
						fenster.dispose();
						dispose();
					}
					else{
						Fehlermeldung fehlermeldung = new Fehlermeldung(
								"Fehler!",
								"Ein unerwarteter Fehler ist aufgetreten.");
						fehlermeldung.setVisible(true);
					}
				}
			});
			okButton.setBounds(103, 200, 100, 30);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Nein");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setBounds(303, 200, 100, 30);
			contentPanel.add(cancelButton);
			cancelButton.setActionCommand("Cancel");
			cancelButton.setBackground(Color.WHITE);
		}
		{
			JTextPane txtBenutzername = new JTextPane();
			txtBenutzername.setEditable(false);
			txtBenutzername.setBackground(new Color(255, 250, 240));
			txtBenutzername.setText("Zu \u00E4ndernder Benutzer:      "+ aenderungBenutzername );
			txtBenutzername.setBounds(30, 20, 400, 30);
			contentPanel.add(txtBenutzername);
		}
		int Zeilenzahl = 50;
		if (!neuerBenutzername.equals("")) {
			JTextPane txtBenutzername = new JTextPane();
			txtBenutzername.setEditable(false);
			txtBenutzername.setText("Neuer Benutzername:        " + neuerBenutzername);
			txtBenutzername.setBackground(new Color(255, 250, 240));
			txtBenutzername.setBounds(30, Zeilenzahl, 400, 30);
			Zeilenzahl = Zeilenzahl +30;
			contentPanel.add(txtBenutzername);
		}
		if (!neuesPasswort.equals("")) {
			JTextPane txtPasswort = new JTextPane();
			txtPasswort.setEditable(false);
			txtPasswort.setText("Passwort wird geaendert");
			txtPasswort.setBackground(new Color(255, 250, 240));
			txtPasswort.setBounds(30, Zeilenzahl, 400, 30);
			Zeilenzahl = Zeilenzahl +30;
			contentPanel.add(txtPasswort);
		}
		if (!neueOrgaEinheitBez.equals("")) {
			JTextPane txtPasswort = new JTextPane();
			txtPasswort.setEditable(false);
			txtPasswort.setText("Organisationseinheit:         " + neueOrgaEinheitBez);
			txtPasswort.setBackground(new Color(255, 250, 240));
			txtPasswort.setBounds(30, Zeilenzahl, 400, 30);
			Zeilenzahl = Zeilenzahl +30;
			contentPanel.add(txtPasswort);
		}
		if (zustandGeaendert) {
			String zustandString = "gesperrt";
			if(neuerZustand)zustandString = "aktiv";
			JTextPane txtPasswort = new JTextPane();
			txtPasswort.setEditable(false);
			txtPasswort.setText("Neuer Zustand:         " + zustandString);
			txtPasswort.setBackground(new Color(255, 250, 240));
			txtPasswort.setBounds(30, Zeilenzahl, 400, 30);
			Zeilenzahl = Zeilenzahl +30;
			contentPanel.add(txtPasswort);
		}
		{
			JTextPane txtFrage = new JTextPane();
			txtFrage.setEditable(false);
			txtFrage.setBackground(new Color(255, 250, 240));
			txtFrage.setText("Benutzer \u00E4ndern?");
			txtFrage.setFont(new Font( "Times New Roman", Font.BOLD, 16));
			txtFrage.setBounds(197, 150, 150, 30);
			contentPanel.add(txtFrage);
		}
	}
}