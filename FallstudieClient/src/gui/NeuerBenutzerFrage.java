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
public class NeuerBenutzerFrage extends JDialog {

	private String Benutzername;
	private String Passwort;
	private Webservice port;
	private String NeuerBenutzername;
	private String NeuesPasswort;
	private String OrgaEinheit;

	private final JPanel contentPanel = new JPanel();

	public NeuerBenutzerFrage(String Benutzername, String Passwort,
			Webservice port, String NeuerBenutzername, String NeuesPasswort,
			String OrgaEinheit) {
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.port = port;
		this.NeuerBenutzername = NeuerBenutzername;
		this.NeuesPasswort = NeuesPasswort;
		this.OrgaEinheit = OrgaEinheit;
		initialize();
	}

	private void initialize() {
		setTitle("Benutzer - Anlegen");
		setBackground(Color.WHITE);
		setBounds(100, 100, 500, 250);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 250, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("Ja");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if (port.benutzerErstellen(Benutzername, Passwort,
							NeuerBenutzername, NeuesPasswort, OrgaEinheit)) {
						ErfolgEingabe ErfolgEingabe = new ErfolgEingabe();
						ErfolgEingabe.setVisible(true);
						dispose();
					} else {
						Fehlermeldung fehler = new Fehlermeldung(
								"Fehler!",
								"Ein unerwarteter Fehler ist aufgetreten.");
						fehler.setVisible(true);
						dispose();
					}
				}
			});
			okButton.setBounds(100, 150, 100, 30);
			okButton.setBackground(Color.ORANGE);
			contentPanel.add(okButton);
			okButton.setActionCommand("Ja");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Nein");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setBounds(300, 150, 100, 30);
			contentPanel.add(cancelButton);
			cancelButton.setBackground(Color.WHITE);
			cancelButton.setActionCommand("Cancel");
		}
		{
			JTextPane txtBenutzername = new JTextPane();
			txtBenutzername.setText("Benutzername:                  "
					+ NeuerBenutzername);
			txtBenutzername.setEditable(false);
			txtBenutzername.setBackground(new Color(255, 250, 240));
			txtBenutzername.setBounds(30, 20, 400, 30);
			contentPanel.add(txtBenutzername);
		}
		{
			JTextPane txtPasswort = new JTextPane();
			txtPasswort.setText("Organisationseinheit:      " + OrgaEinheit);
			txtPasswort.setEditable(false);
			txtPasswort.setBackground(new Color(255, 250, 240));
			txtPasswort.setBounds(30, 50, 400, 30);
			contentPanel.add(txtPasswort);
		}
		{
			JTextPane txtFrage = new JTextPane();
			txtFrage.setText("Benutzer erstellen?");
			txtFrage.setBackground(new Color(255, 250, 240));
			txtFrage.setEditable(false);
			txtFrage.setBounds(180, 100, 200, 50);
			txtFrage.setFont(new Font("Times New Roman", Font.BOLD, 16));
			contentPanel.add(txtFrage);
		}
	}

}