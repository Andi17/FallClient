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
	private String aenderungBenutzername;
	private String NeuerBenutzername;
	private String NeuesPasswort;
	private int idOrgaEinheit;
	private final JPanel contentPanel = new JPanel();

	public BearbeitungBenutzerFrage(String Benutzername, String Passwort, Webservice port, String aenderungBenutzername, String NeuesPasswort, String neuerBenutzername, int idOrgaEinheit) {
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.port = port;
		this.aenderungBenutzername = aenderungBenutzername;
		if (NeuesPasswort.equals("")) {
			this.NeuesPasswort = null;
		} else {
			this.NeuesPasswort = NeuesPasswort;
		}
		if (neuerBenutzername.equals("")) {
			this.NeuerBenutzername = null;
		} else {
			this.NeuerBenutzername = neuerBenutzername;
		}
		this.idOrgaEinheit = idOrgaEinheit;
		initialize();
	}
	private void initialize() {
		setTitle("Benutzer - Bearbeiten");
		setResizable(false);
		setBackground(new Color(255, 250, 240));
		setBounds(100, 100, 500, 280);
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
					if (NeuesPasswort != null) {
						passwortgeaendert = port.neuesPasswortSetzen(Benutzername, Passwort, aenderungBenutzername,	NeuesPasswort);
					}
					if (idOrgaEinheit != 0) {
						orgageaendert = port.benutzerOrgaEinheitAendern(Benutzername, Passwort, aenderungBenutzername, idOrgaEinheit);
					}
					if (NeuerBenutzername != null) {
						neuername = port.benutzernameAendern(Benutzername, Passwort, aenderungBenutzername,	NeuerBenutzername);
					}
					if (passwortgeaendert && orgageaendert && neuername) {
						ErfolgEingabe ErfolgEingabe = new ErfolgEingabe();
						ErfolgEingabe.setVisible(true);
						dispose();
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
		if (NeuerBenutzername != null) {
			JTextPane txtBenutzername = new JTextPane();
			txtBenutzername.setEditable(false);
			txtBenutzername.setText("Neuer Benutzername:        " + NeuerBenutzername);
			txtBenutzername.setBackground(new Color(255, 250, 240));
			txtBenutzername.setBounds(30, Zeilenzahl, 400, 30);
			Zeilenzahl = Zeilenzahl +30;
			contentPanel.add(txtBenutzername);
		}
		if (NeuesPasswort != null) {
			JTextPane txtPasswort = new JTextPane();
			txtPasswort.setEditable(false);
			txtPasswort.setText("Passwort wird geaendert");
			txtPasswort.setBackground(new Color(255, 250, 240));
			txtPasswort.setBounds(30, Zeilenzahl, 400, 30);
			Zeilenzahl = Zeilenzahl +30;
			contentPanel.add(txtPasswort);
		}
		if (idOrgaEinheit != 0) {
			JTextPane txtPasswort = new JTextPane();
			txtPasswort.setEditable(false);
			txtPasswort.setText("Organisationseinheit:         " + idOrgaEinheit);
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