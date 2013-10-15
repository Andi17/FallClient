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
	
	public NeueStrichkategorieFrage(String Benutzername, String Passwort, Webservice port, String NeueStrichKategorie) {
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.port = port;
		this.NeueStrichKategorie = NeueStrichKategorie;	
		initialize();
	}
	/**
	 * Create the dialog.
	 */
	public void initialize() {
		setTitle("Strichkategorie - Anlegen");
		setResizable(false);
		setBackground(Color.WHITE);
		setBounds(100, 100, 460, 180);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextPane txtpnWollenSieDie = new JTextPane();
			txtpnWollenSieDie.setBackground(Color.WHITE);
			txtpnWollenSieDie.setText("Wollen Sie die Strichkategorie wirklich hinzuf\u00FCgen?");
			txtpnWollenSieDie.setBounds(72, 64, 320, 29);
			contentPanel.add(txtpnWollenSieDie);
		}
		{
			JButton okButton = new JButton("Ja");
			okButton.setBounds(292, 127, 75, 29);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//TODO Aktion			
					//TODO Exception Abfrage durch RŸckgabewert der DB
					// Methodenname - †bergabewerte - RŸckgabewerte
					// neueStrichelart - String benutzer, String passwort, String strichbezeichnung - boolean
					if(port.neueStrichelart(Benutzername, Passwort, NeueStrichKategorie)){
						ErfolgEingabe ErfolgEingabe = new ErfolgEingabe();
						ErfolgEingabe.setVisible(true);
						dispose();
						}
						else{
			        		AnwendungAbbruch frmAnwendungAbbruch = new AnwendungAbbruch();
			    			frmAnwendungAbbruch.setVisible(true); 
			    			dispose();
						}
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Nein");
			cancelButton.setBounds(379, 127, 75, 29);
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
