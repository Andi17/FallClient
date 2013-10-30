package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.combobox.ListComboBoxModel;

import tools.SonderzeichenTest;
import Webservice.ComBenutzer;
import Webservice.Webservice;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class NeueOrgaEinheit extends JDialog {

	private String Benutzername;
	private String Passwort;
	private Webservice port;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNeueOrgaEinheit;
	private JComboBox<String> comboBoxLeiter;
	private JComboBox<String> comboBoxOrgaEinheitTyp;
	private JComboBox<String> comboBoxuebergeordEinheit;
	private boolean typAusgewaehlt = false;

	public NeueOrgaEinheit(String Benutzername, String Passwort, Webservice port) {
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.port = port;
		initialize();
	}

	@SuppressWarnings("unchecked")
	public void initialize() {
		setTitle("Organisationseinheit - Anlegen");
		setResizable(false);
		setBackground(Color.WHITE);
		setBounds(100, 100, 520, 210);
		setModal(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 250, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNeueOrganisationseinheit = new JLabel(
					"Neue Organisationseinheit:");
			lblNeueOrganisationseinheit.setBounds(10, 15, 182, 16);
			contentPanel.add(lblNeueOrganisationseinheit);
		}
		{
			txtNeueOrgaEinheit = new JTextField();
			txtNeueOrgaEinheit.setBounds(250, 8, 250, 28);
			contentPanel.add(txtNeueOrgaEinheit);
			txtNeueOrgaEinheit.setColumns(10);
		}
		{
			JButton okButton = new JButton("Best\u00E4tigen");
			okButton.setBackground(Color.ORANGE);
			okButton.setBounds(285, 140, 100, 30);
			contentPanel.add(okButton);
			final NeueOrgaEinheit fensterZumUebergeben = this;
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					/*
					 * Plausibilitätsprüfungen(Sonderzeichen, OrgaEinheit schon vorhanden, Ist Benutzer schon Leiter)
					 */
					SonderzeichenTest sonderzeichen = new SonderzeichenTest();
					String orgaEinheitName = txtNeueOrgaEinheit.getText();
					String typ = (String) comboBoxOrgaEinheitTyp
							.getSelectedItem();
					String leiter = (String) comboBoxLeiter
							.getSelectedItem();
					if (typ.equals("Noch nicht ausgewählt")) {
						Fehlermeldung fehlermeldung = new Fehlermeldung(
								"Fehler!", "Sie müssen einen Typ auswählen.");
						fehlermeldung.setVisible(true);
					} else if (orgaEinheitName.equals("")) {
						Fehlermeldung fehlermeldung = new Fehlermeldung(
								"Fehler!", "Sie müssen einen Namen eingeben.");
						fehlermeldung.setVisible(true);
					} else if (port.gibtEsOrgaEinheitSchon(Benutzername,
							Passwort, orgaEinheitName)) {
						Fehlermeldung fehlermeldung = new Fehlermeldung(
								"Fehler!",
								"Es gibt bereits eine Organisationseinheit mit dem Namen.");
						fehlermeldung.setVisible(true);
					}
					else if(!port.istBenutzerSchonLeiter(Benutzername, Passwort, leiter).equals("Nein")){
						Fehlermeldung fehlermeldung = new Fehlermeldung(
								"Fehler!",
								"Der gewünschte Leiter ist schon Leiter von " + port.istBenutzerSchonLeiter(Benutzername, Passwort, leiter) + ".");
						fehlermeldung.setVisible(true);
					}
					else if (sonderzeichen.test(orgaEinheitName)==true)
					{
						Fehlermeldung fehlermeldung = new Fehlermeldung(
								"Fehler!",
								"Die Organisationseinheit darf nur aus Buchstaben und Zahlen bestehen.");
						fehlermeldung.setVisible(true);
					}
					else {
						String ueberOrgaEinheit = "";
						int idUeberOrgaEinheit = 0;
						if (typ.equals("Bereich") || typ.equals("Gruppe") || typ.equals("Stabstelle")) {
							ueberOrgaEinheit = (String) comboBoxuebergeordEinheit
									.getSelectedItem();
							idUeberOrgaEinheit = port.getOrgaEinheitZuName(
									Benutzername, Passwort, ueberOrgaEinheit)
									.getIdOrgaEinheit();
						}
						if(leiter.equals("Kein Leiter"))leiter = null;
						//Erstellung des Fragefensters vor dem Erstellen.
						NeueOrgaEinheitFrage frage = new NeueOrgaEinheitFrage(
								Benutzername, Passwort, port, fensterZumUebergeben, orgaEinheitName,
								leiter, idUeberOrgaEinheit, typ);
						frage.setVisible(true);
					}
				}

			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Abbrechen");
			cancelButton.setBackground(Color.WHITE);
			cancelButton.setBounds(405, 140, 100, 30);
			contentPanel.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
		}
		{
			JLabel lblOrganisationseinheitsleiter = new JLabel(
					"Organisationseinheitsleiter:");
			lblOrganisationseinheitsleiter.setBounds(10, 45, 182, 16);
			contentPanel.add(lblOrganisationseinheitsleiter);
		}
		{
			JLabel lblTyp = new JLabel("Typ:");
			lblTyp.setBounds(10, 75, 128, 16);
			contentPanel.add(lblTyp);
		}
		{
			JLabel lblberEinheit = new JLabel(
					"\u00DCbergeordnete Einheit:\r\n");
			lblberEinheit.setBounds(10, 105, 153, 16);
			contentPanel.add(lblberEinheit);
		}
		
		//ComboBox zum aussuchen des Leiters
		comboBoxLeiter = new JComboBox<String>();
		List<String> alleBenutzerNamen = new ArrayList<String>();
		alleBenutzerNamen.add("Kein Leiter");
		List<ComBenutzer> alleBenutzer = port.getBenutzer(Benutzername,
				Passwort);
		for (ComBenutzer benutzer : alleBenutzer) {
			alleBenutzerNamen.add(benutzer.getBenutzername());
		}
		comboBoxLeiter
				.setModel(new ListComboBoxModel<String>(alleBenutzerNamen));
		AutoCompleteDecorator.decorate(comboBoxLeiter);
		comboBoxLeiter.setBounds(250, 38, 250, 26);
		contentPanel.add(comboBoxLeiter);
		
		//ComboBox zum aususchen der Organisationseinheiten
		List<String> OrgaEinheitTypListe = new ArrayList<String>();
		OrgaEinheitTypListe.add("Noch nicht ausgewählt");
		OrgaEinheitTypListe.addAll(port.getAlleMoeglichenOrgaEinheitTypen(
				Benutzername, Passwort));
		comboBoxOrgaEinheitTyp = new JComboBox<String>();
		comboBoxOrgaEinheitTyp.setModel(new ListComboBoxModel<String>(
				OrgaEinheitTypListe));
		AutoCompleteDecorator.decorate(comboBoxOrgaEinheitTyp);
		comboBoxOrgaEinheitTyp.setBounds(250, 68, 250, 26);
		contentPanel.add(comboBoxOrgaEinheitTyp);
		comboBoxOrgaEinheitTyp.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent c) {
				if (typAusgewaehlt)
					contentPanel.remove(comboBoxuebergeordEinheit);
				String gruppenTyp = (String) comboBoxOrgaEinheitTyp
						.getSelectedItem();
				String gruppenTypUeberEinheit = "";
				if (gruppenTyp.equals("Gruppe"))
					gruppenTypUeberEinheit = "Bereich";
				else if (gruppenTyp.equals("Bereich"))
					gruppenTypUeberEinheit = "Zentralbereich";
				else if (gruppenTyp.equals("Stabstelle"))
					gruppenTypUeberEinheit = "Zentralbereich";
				List<String> alleOrgaEinheitenVomTyp = port
						.getAlleOrgaEinheitenBezeichnungenVomTyp(Benutzername,
								Passwort, gruppenTypUeberEinheit);
				if(alleOrgaEinheitenVomTyp.size()==0)alleOrgaEinheitenVomTyp.add("Keine übergeordnete Einheit");

				comboBoxuebergeordEinheit = new JComboBox<String>();
				comboBoxuebergeordEinheit
						.setModel(new ListComboBoxModel<String>(
								alleOrgaEinheitenVomTyp));
				AutoCompleteDecorator.decorate(comboBoxuebergeordEinheit);
				comboBoxuebergeordEinheit.setBounds(250, 98, 250, 26);
				typAusgewaehlt = true;
				contentPanel.add(comboBoxuebergeordEinheit);
				contentPanel.updateUI();
			}
		});
	}

}
