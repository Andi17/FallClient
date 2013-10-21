package gui;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.Border;
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
	private JPanel aktuelleDaten = new JPanel();
	private JTextField txtPasswort;
	private JComboBox<String> comboBoxBenutzername;
	private JTextField txtneuerBenutzername;
	private JComboBox<String> comboBoxOrgaEinheit;
	private String[] Combobezeichnung;
	private JComboBox<String> comboBoxZustand;
	private List<String> CoboBezeichnungOrgaEinheit;
	private List<String> OrgaEinheitListeString;
	private JButton okButton;
	private boolean wurdeAusgewaehlt = false;
	private boolean gruppeGeaendert = false;
	private boolean zustandGeaendert = false;
	

	/**
	 * Create the dialog.
	 */
	public BearbeitungBenutzer(String Benutzername, String Passwort,
			Webservice port) {
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.port = port;
		List<ComOrgaEinheit> OrgaEinheitListe = port.getOrgaEinheiten(
				Benutzername, Passwort, true);
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
		setBounds(100, 100, 470, 400);
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
			JLabel lblZustand = new JLabel("Neuer Zustand:");
			lblZustand.setBounds(30, 140, 150, 30);
			contentPanel.add(lblZustand);
		}
		{
			comboBoxBenutzername = new JComboBox<String>();
			comboBoxBenutzername.setBounds(200, 20, 250, 26);
			contentPanel.add(comboBoxBenutzername);
			// txtBenutzername.setColumns(1);
			List<String> alleBenutzerNamen = new ArrayList<String>();
			List<ComBenutzer> alleBenutzer = port.getBenutzer(Benutzername,
					Passwort);
			alleBenutzerNamen.add("Bitte auswählen");
			for (ComBenutzer benutzer : alleBenutzer) {
				alleBenutzerNamen.add(benutzer.getBenutzername());
			}
			comboBoxBenutzername.setModel(new ListComboBoxModel<String>(
					alleBenutzerNamen));
			AutoCompleteDecorator.decorate(comboBoxBenutzername);
			comboBoxBenutzername.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					String benutzer = (String) comboBoxBenutzername
							.getSelectedItem();
					if (!benutzer.equals("Bitte auswählen")) {
						ComBenutzer zuBearbeitenderBenutzer = port
								.getEinzelnenBenutzer(Benutzername, Passwort,
										benutzer);
						comboBoxOrgaEinheit
								.setSelectedItem(zuBearbeitenderBenutzer
										.getOrgaEinheitBez());
						comboBoxOrgaEinheit.setEditable(true);
						txtneuerBenutzername.setEditable(true);
						txtPasswort.setEditable(true);
						String zustandString;
						if (zuBearbeitenderBenutzer.isGesperrt())
							zustandString = "gesperrt";
						else
							zustandString = "aktiv";
						comboBoxZustand.setSelectedItem(zustandString);
						zustandGeaendert = false;
						gruppeGeaendert = false;
						getRootPane().setDefaultButton(okButton);
						
						//Erzeugt das Panel mit den aktuellen Daten.
						if(wurdeAusgewaehlt) contentPanel.remove(aktuelleDaten);
						aktuelleDaten = new JPanel();
						aktuelleDaten.setLayout(null);
						aktuelleDaten.setBounds(30, 180, 420, 90);
						aktuelleDaten.setBorder(BorderFactory.createLineBorder(Color.BLACK));
						aktuelleDaten.setBackground(new Color(255, 250, 240));
						JLabel label = new JLabel("Aktuelle Einheit:");
						label.setBounds(5, 5, 175, 15);
						aktuelleDaten.add(label);
						
						label = new JLabel(zuBearbeitenderBenutzer.getOrgaEinheitBez());
						label.setBounds(175, 5, 175, 15);
						aktuelleDaten.add(label);
						
						String isLeiter;
						if(port.istBenutzerSchonLeiter(Benutzername, Passwort, benutzer))isLeiter = "JA";
						else isLeiter = "NEIN";
						label = new JLabel("Leiter der Einheit:");
						label.setBounds(5, 25, 175, 15);
						aktuelleDaten.add(label);
						
						label = new JLabel(isLeiter);
						label.setBounds(175, 25, 175, 15);
						aktuelleDaten.add(label);
						
						label = new JLabel("Typ der Einheit:");
						label.setBounds(5, 45, 175, 15);
						aktuelleDaten.add(label);
						
						label = new JLabel(port.getOrgaEinheitZuName(Benutzername, Passwort, zuBearbeitenderBenutzer.getOrgaEinheitBez()).getOrgaEinheitTyp());
						label.setBounds(175, 45, 175, 15);
						aktuelleDaten.add(label);
						
						label = new JLabel("Aktueller Zustand:");
						label.setBounds(5, 65, 175, 15);
						aktuelleDaten.add(label);
						
						label = new JLabel(zustandString);
						label.setBounds(175, 65, 175, 15);
						aktuelleDaten.add(label);
						
						contentPanel.add(aktuelleDaten);
						contentPanel.updateUI();
						wurdeAusgewaehlt = true;
					}
				}
			});
		}
		{
			txtneuerBenutzername = new JTextField();
			txtneuerBenutzername.setBounds(200, 50, 250, 26);
			contentPanel.add(txtneuerBenutzername);
			txtneuerBenutzername.setColumns(10);
			txtneuerBenutzername.setEditable(false);
		}
		{
			txtPasswort = new JTextField();
			txtPasswort.setBounds(200, 80, 250, 26);
			contentPanel.add(txtPasswort);
			txtPasswort.setColumns(10);
			txtPasswort.setEditable(false);
		}
		{
			comboBoxOrgaEinheit = new JComboBox<String>();
			comboBoxOrgaEinheit.setBounds(200, 110, 250, 26);
			contentPanel.add(comboBoxOrgaEinheit);
			comboBoxOrgaEinheit.setModel(new ListComboBoxModel<String>(
					CoboBezeichnungOrgaEinheit));
			AutoCompleteDecorator.decorate(comboBoxOrgaEinheit);
			comboBoxOrgaEinheit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					gruppeGeaendert = true;
				}

			});
			comboBoxOrgaEinheit.setEditable(false);
		}
		{
			okButton = new JButton("\u00C4ndern");
			okButton.setBounds(235, 280, 100, 30);
			okButton.setBackground(Color.ORANGE);
			contentPanel.add(okButton);
			final BearbeitungBenutzer fenster = this;
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String benutzername = (String) comboBoxBenutzername
							.getSelectedItem();
					if (benutzername.equals("Bitte auswählen")) {
						Fehlermeldung fehler = new Fehlermeldung("Fehler!",
								"Wählen Sie einen Benutzer zum Ändern aus.");
						fehler.setVisible(true);
					} else {
						String passwort = txtPasswort.getText();
						String neuerBenutzername = txtneuerBenutzername
								.getText();
						if (!zustandGeaendert && !gruppeGeaendert
								&& passwort.equals("")
								&& neuerBenutzername.equals("")) {
							Fehlermeldung fehler = new Fehlermeldung(
									"Fehler!",
									"Der Benutzer ist Leiter einer Einheit. Bevor er die Einheit wechseln kann muss ein neuer Leiter benannt werden.");
							fehler.setVisible(true);
						} else if (gruppeGeaendert
								&& port.istBenutzerSchonLeiter(Benutzername,
										Passwort, benutzername)) {
							Fehlermeldung fehler = new Fehlermeldung("Fehler!",
									"Sie haben keine Werte eingegeben.");
							fehler.setVisible(true);
						} else if (port.gibtesBenutzerschon(Benutzername,
								Passwort, neuerBenutzername)) {
							Fehlermeldung fehlermeldung = new Fehlermeldung(
									"Fehler!",
									"Der gewünschte Benutzername ist schon vergeben.");
							fehlermeldung.setVisible(true);
						} else {
							String orgaEinheitBez = (String) comboBoxOrgaEinheit
									.getSelectedItem();
							boolean zustand = true;
							if (comboBoxZustand.getSelectedItem().equals(
									"gesperrt")) {
								zustand = false;
							}
							BearbeitungBenutzerFrage BearbeitungBenutzerFrage = new BearbeitungBenutzerFrage(
									Benutzername, Passwort, port, fenster,
									benutzername, passwort, neuerBenutzername,
									orgaEinheitBez, zustand, zustandGeaendert);
							BearbeitungBenutzerFrage.setVisible(true);
						}

					}
				}
			});
			okButton.setActionCommand("OK");
		}
		{
			JButton cancelButton = new JButton("Abbrechen");
			cancelButton.setBackground(new Color(255, 255, 255));
			cancelButton.setBounds(350, 280, 100, 30);
			contentPanel.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
		}
		List<ComBenutzer> BenutzerListe = port.getBenutzer(Benutzername,
				Passwort);
		Combobezeichnung = new String[BenutzerListe.size()];
		int zaehler = 0;
		for (ComBenutzer Ben : BenutzerListe) {
			Combobezeichnung[zaehler] = Ben.getBenutzername();
			zaehler++;
		}

		String[] zustand = { "aktiv", "gesperrt" };
		comboBoxZustand = new JComboBox<String>(zustand);
		comboBoxZustand.setBounds(200, 140, 250, 26);
		comboBoxZustand.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				zustandGeaendert = true;
			}
		});
		contentPanel.add(comboBoxZustand);
	}
}