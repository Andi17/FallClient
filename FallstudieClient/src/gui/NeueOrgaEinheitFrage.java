package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextPane;

import Webservice.Webservice;

@SuppressWarnings("serial")
public class NeueOrgaEinheitFrage extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Webservice port;
	private String Benutzername;
	private String Passwort;
	private String NeueOrgaEinheitName;
	private int UeberOrgaNr;
	private String NeueOrgaEinheitLeiter;
	private String OrgaEinheitTyp;
	private NeueOrgaEinheit fenster;

	public NeueOrgaEinheitFrage(String Benutzername, String Passwort,
			Webservice port, NeueOrgaEinheit fenster, String NeueOrgaEinheitName, String leiter,
			int UeberOrgaNr, String OrgaEinheitTyp) {
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.port = port;
		this.NeueOrgaEinheitName = NeueOrgaEinheitName;
		this.NeueOrgaEinheitLeiter = leiter;
		this.UeberOrgaNr = UeberOrgaNr;
		this.OrgaEinheitTyp = OrgaEinheitTyp;
		this.fenster = fenster;
		initialize();

	}

	public void initialize() {
		setTitle("Organisationseinheit - Anlegen");
		setBackground(Color.WHITE);
		setBounds(100, 100, 480, 180);
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
			okButton.setBounds(110, 73, 100, 30);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Erstellen der OrgaEinheit über den Server
					if (port.orgaEinheitErstellen(Benutzername, Passwort,
							NeueOrgaEinheitName, NeueOrgaEinheitLeiter,
							OrgaEinheitTyp, UeberOrgaNr)) {
						ErfolgEingabe ErfolgEingabe = new ErfolgEingabe();
						ErfolgEingabe.setVisible(true);
						fenster.dispose();
						dispose();
					} else {
						// Fehlermeldung, falls Erstellung fehlgeschlagen hat.
						Fehlermeldung fehler = new Fehlermeldung("Fehler!",
								"Ein unerwarteter Fehler ist aufgetreten!");
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
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setBounds(260, 73, 100, 30);
			contentPanel.add(cancelButton);
			cancelButton.setActionCommand("Cancel");
		}
		{
			JTextPane txtpnMchtenSieWirklich = new JTextPane();
			txtpnMchtenSieWirklich
					.setText("M\u00F6chten Sie wirklich die Organisationseinheit '"+ NeueOrgaEinheitName + "' anlegen?");
			txtpnMchtenSieWirklich.setBackground(new Color(255, 250, 240));
			txtpnMchtenSieWirklich.setBounds(61, 22, 317, 60);
			txtpnMchtenSieWirklich.setEditable(false);
			contentPanel.add(txtpnMchtenSieWirklich);
		}
	}

}
