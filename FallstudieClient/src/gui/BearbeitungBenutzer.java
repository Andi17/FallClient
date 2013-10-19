package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.combobox.ListComboBoxModel;

import Webservice.ComBenutzer;
import Webservice.ComOrgaEinheit;
import Webservice.Webservice;

@SuppressWarnings("serial")
public class BearbeitungBenutzer extends JDialog {
	private String Benutzername;
	private String Passwort;
	private Webservice port;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtPasswort;
	private JComboBox<String> txtBenutzername;
	private JTextField txtneuerBenutzername;
	private JComboBox<String> comboBoxOrgaEinheit;
	private String[] Combobezeichnung;
	private JComboBox<String> comboBoxZustand;
	private List<String> CoboBezeichnungOrgaEinheit;
	private List<String> OrgaEinheitListeString;
	private JButton okButton;

	/**
	 * Create the dialog.
	 */
	public BearbeitungBenutzer(String Benutzername, String Passwort,
			Webservice port) {
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.port = port;
		List<ComOrgaEinheit> OrgaEinheitListe = port.getOrgaEinheiten(Benutzername, Passwort,
				true);
		this.OrgaEinheitListeString = new ArrayList<String>();
		CoboBezeichnungOrgaEinheit = new ArrayList<String>();
		for (ComOrgaEinheit Orga : OrgaEinheitListe) {
			OrgaEinheitListeString.add(Orga.getOrgaEinheitBez());
			CoboBezeichnungOrgaEinheit.add(Orga.getOrgaEinheitBez());
		}
		initialize();
	}

	private void initialize() {
		setTitle("Benutzer - Bearbeiten");
		setBackground(new Color(255, 250, 240));
		setResizable(false);
		setBounds(100, 100, 520, 240);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 250, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblBenutzername = new JLabel("Benutzername:");
			lblBenutzername.setBounds(30, 20, 150, 30);
			contentPanel.add(lblBenutzername);
		}
		{
			JLabel lblBenutzername = new JLabel("Neuer Benutzername:");
			lblBenutzername.setBounds(30, 50, 150, 30);
			contentPanel.add(lblBenutzername);
		}
		{
			JLabel lblNeuesPasswort = new JLabel("Neues Passwort:");
			lblNeuesPasswort.setBounds(30, 80, 150, 30);
			contentPanel.add(lblNeuesPasswort);
		}
		{
			JLabel lblNeuesPasswort = new JLabel("Neue Organisationseinheit:");
			lblNeuesPasswort.setBounds(30, 110, 175, 30);
			contentPanel.add(lblNeuesPasswort);
		}
		{
			txtBenutzername = new JComboBox<String>();
			txtBenutzername.setBounds(200, 20, 142, 26);
			contentPanel.add(txtBenutzername);
			// txtBenutzername.setColumns(1);
			List<String> alleBenutzerNamen = new ArrayList<String>();
			List<ComBenutzer> alleBenutzer = port.getBenutzer(Benutzername,
					Passwort);
			for (ComBenutzer benutzer : alleBenutzer) {
				alleBenutzerNamen.add(benutzer.getBenutzername());
			}
			txtBenutzername.setModel(new ListComboBoxModel<String>(
					alleBenutzerNamen));
			AutoCompleteDecorator.decorate(txtBenutzername);
		}
		{
			txtneuerBenutzername = new JTextField();
			txtneuerBenutzername.setBounds(200, 50, 142, 26);
			contentPanel.add(txtneuerBenutzername);
			txtneuerBenutzername.setColumns(10);
			txtneuerBenutzername.setEditable(false);
		}
		{
			txtPasswort = new JTextField();
			txtPasswort.setBounds(200, 80, 142, 26);
			contentPanel.add(txtPasswort);
			txtPasswort.setColumns(10);
			txtPasswort.setEditable(false);
		}
		{
			comboBoxOrgaEinheit = new JComboBox<String>();
			comboBoxOrgaEinheit.setBounds(200, 110, 142, 26);
			contentPanel.add(comboBoxOrgaEinheit);
			comboBoxOrgaEinheit.setModel(new ListComboBoxModel<String>(
					CoboBezeichnungOrgaEinheit));
			AutoCompleteDecorator.decorate(comboBoxOrgaEinheit);
			comboBoxOrgaEinheit.setEditable(false);
		}
		{
			okButton = new JButton("\u00C4ndern");
			okButton.setBounds(280, 162, 100, 30);
			okButton.setBackground(Color.ORANGE);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String benutzername = (String) txtBenutzername
							.getSelectedItem();
					String passwort = txtPasswort.getText();
					String neuerBenutzername = txtneuerBenutzername.getText();
					String orgaEinheitBez = (String) comboBoxOrgaEinheit
							.getSelectedItem();
					boolean zustand = true;
					if(comboBoxZustand.getSelectedItem().equals("gesperrt"))zustand=false;

					if (port.gibtesBenutzerschon(Benutzername, Passwort,
							neuerBenutzername)) {
						Fehlermeldung fehlermeldung = new Fehlermeldung(
								"Fehler!",
								"Der gewünschte Benutzername ist schon vergeben.");
						fehlermeldung.setVisible(true);
					} else {
						if ((neuerBenutzername.equals(""))
								&& (passwort.equals(""))
								&& (orgaEinheitBez.equals(""))) {
						} else {
							BearbeitungBenutzerFrage BearbeitungBenutzerFrage = new BearbeitungBenutzerFrage(
									Benutzername, Passwort, port, benutzername,
									passwort, neuerBenutzername, orgaEinheitBez, zustand);
							BearbeitungBenutzerFrage.setVisible(true);
							dispose();
						}
					}
				}
			});
			okButton.setActionCommand("OK");
		}
		{
			JButton cancelButton = new JButton("Abbrechen");
			cancelButton.setBackground(new Color(255, 255, 255));
			cancelButton.setBounds(394, 162, 100, 30);
			contentPanel.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
		}
		{
			JButton confirmButton = new JButton("Bearbeiten");
			confirmButton.setBackground(Color.ORANGE);
			confirmButton.setBounds(350, 20, 142, 26);
			contentPanel.add(confirmButton);
			confirmButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String benutzer = (String) txtBenutzername
							.getSelectedItem();
					ComBenutzer zuBearbeitenderBenutzer = port
							.getEinzelnenBenutzer(Benutzername, Passwort,
									benutzer);
					comboBoxOrgaEinheit.setSelectedItem(zuBearbeitenderBenutzer
							.getOrgaEinheitBez());
					comboBoxOrgaEinheit.setEditable(true);
					txtneuerBenutzername.setEditable(true);
					txtPasswort.setEditable(true);
					if(zuBearbeitenderBenutzer.isGesperrt())comboBoxZustand.setSelectedItem("gesperrt");
					else comboBoxZustand.setSelectedItem("aktiv");
					getRootPane().setDefaultButton(okButton);

				}
			});
			confirmButton.setActionCommand("Bearbeiten");
			getRootPane().setDefaultButton(confirmButton);
		}
		List<ComBenutzer> BenutzerListe = port.getBenutzer(Benutzername,
				Passwort);
		Combobezeichnung = new String[BenutzerListe.size()];
		int zaehler = 0;
		for (ComBenutzer Ben : BenutzerListe) {
			Combobezeichnung[zaehler] = Ben.getBenutzername();
			zaehler++;
		}

		String[] zustand = {"aktiv", "gesperrt"};
		comboBoxZustand = new JComboBox<String>(zustand);
		comboBoxZustand.setBounds(350, 110, 142, 26);
		contentPanel.add(comboBoxZustand);
	}
}