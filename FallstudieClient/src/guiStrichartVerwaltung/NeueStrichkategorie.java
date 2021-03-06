package guiStrichartVerwaltung;

import gui.Fehlermeldung;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;

import tools.SonderzeichenTest;
import Webservice.Webservice;

import java.awt.Color;

@SuppressWarnings("serial")
public class NeueStrichkategorie extends JDialog {
	
	private String Benutzername;
	private String Passwort;
	private Webservice port;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtStrichkategorie;

	public NeueStrichkategorie(String Benutzername, String Passwort,
			Webservice port) {
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.port = port;
		initialize();
	}

	public void initialize() {
		setTitle("Strichkategorie - Anlegen");
		setResizable(false);
		setBounds(100, 100, 445, 130);
		setModal(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 250, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("Strichkategorie hinzuf\u00FCgen");
			okButton.setBackground(Color.ORANGE);
			okButton.setBounds(110, 60, 202, 29);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					/*
					 * Plausibilit�tspr�fungen(Sonderzeichen, schon vorhanden)
					 * 
					 */
					String neueStrichkategorie = txtStrichkategorie.getText();
					SonderzeichenTest sonderzeichen = new SonderzeichenTest();
					if (sonderzeichen.test(neueStrichkategorie)==true)
					{
						Fehlermeldung fehler = new Fehlermeldung(
								"Fehler!",
								"Die Strichkategoriebezeichnung darf nur aus Buchstaben und Zahlen bestehen.");
						fehler.setVisible(true);
					}
					else
					{
						try{
							if (port.gibtEsStrichelBezeichnungSchon(Benutzername, Passwort, neueStrichkategorie)){
								Fehlermeldung fehler = new Fehlermeldung("Fehler!", "Strichart schon vorhanden.");
								fehler.setVisible(true);							
							}
							else{				
							NeueStrichkategorieFrage NeueStrichkategorieFrage = new NeueStrichkategorieFrage(Benutzername, Passwort, port, txtStrichkategorie.getText());
							NeueStrichkategorieFrage.setVisible(true);
							dispose();
							}
						}
						catch (NumberFormatException a){
							txtStrichkategorie.setText("");
						}
					}
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Abbrechen");
			cancelButton.setBackground(Color.WHITE);
			cancelButton.setBounds(325, 60, 104, 29);
			contentPanel.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
		}
		{
			JLabel lblNeueStrichkategorie = new JLabel("Neue Strichkategorie:");
			lblNeueStrichkategorie.setBounds(30, 20, 145, 16);
			contentPanel.add(lblNeueStrichkategorie);
		}
		{
			txtStrichkategorie = new JTextField();
			txtStrichkategorie.setBounds(175, 13, 250, 28);
			contentPanel.add(txtStrichkategorie);
			txtStrichkategorie.setColumns(10);
		}
	}	
}
