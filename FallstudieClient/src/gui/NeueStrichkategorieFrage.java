package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;

import Webservice.Webservice;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class NeueStrichkategorieFrage extends JDialog {

	private String Benutzername;
	private String Passwort;
	private Webservice port;
	private String NeueStrichKategorie;
	
	private final JPanel contentPanel = new JPanel();
	// erhalten der Werte von "NeueStrichkategorie"
	public NeueStrichkategorieFrage(String Benutzername, String Passwort, Webservice port, String NeueStrichKategorie) {
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.port = port;
		this.NeueStrichKategorie = NeueStrichKategorie;	
		initialize();
	}

	public void initialize() {
		setTitle("Strichkategorie - Anlegen");
		setResizable(false);
		setBackground(Color.WHITE);
		setBounds(100, 100, 460, 180);
		setModal(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 250, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextPane txtpnWollenSieDie = new JTextPane();
			txtpnWollenSieDie.setBackground(new Color(255,250,240));
			txtpnWollenSieDie.setText("Wollen Sie die Strichkategorie wirklich hinzuf\u00FCgen?");
			txtpnWollenSieDie.setEditable(false);
			txtpnWollenSieDie.setBounds(71, 27, 320, 29);
			contentPanel.add(txtpnWollenSieDie);
		}
		{
			JButton okButton = new JButton("Ja");
			okButton.setBackground(Color.ORANGE);
			okButton.setBounds(88, 81, 100, 30);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Anlegen der neuen Strichart über den Server
					if(port.neueStrichelart(Benutzername, Passwort, NeueStrichKategorie)){
						ErfolgEingabe ErfolgEingabe = new ErfolgEingabe();
						ErfolgEingabe.setVisible(true);
						dispose();
						}
						else{
							Fehlermeldung fehler = new Fehlermeldung(
									"Fehler!",
									"Ein unerwarteter Fehler ist aufgetreten.");
							fehler.setVisible(true);
			    			dispose();
						}
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Nein");
			cancelButton.setBackground(Color.WHITE);
			cancelButton.setBounds(245, 81, 100, 30);
			contentPanel.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
		}
	}
}
