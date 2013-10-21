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
public class BearbeitungOrgaEinheit extends JDialog {
	private String Benutzername;
	private String Passwort;
	private Webservice port;
	private final JPanel contentPanel = new JPanel();
	private JComboBox<String> comboBoxLeiter;
	private JComboBox<String> comboBoxBezeichnung;
	private JTextField txtneueBezeichnung;
	private JComboBox<String> comboBoxUeberOrgaEinheit;
	private JComboBox<String> comboBoxZustand;
	private JButton okButton;
	private boolean wurdeAusgewaehlt = false;
	private boolean leiterGeaendert = false;
	private boolean ueberOrgaEinheitGeaendert = false;
	private boolean zustandGeaendert = false;

	/**
	 * Create the dialog.
	 */
	public BearbeitungOrgaEinheit(String Benutzername, String Passwort,
			Webservice port) {
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.port = port;

		initialize();
	}

	private void initialize() {
		setTitle("Organisationseinheit - Bearbeiten");
		setBackground(new Color(255, 250, 240));
		setResizable(false);
		setBounds(100, 100, 470, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 250, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblBenutzername = new JLabel("Bezeichnung:");
			lblBenutzername.setBounds(30, 20, 150, 30);
			contentPanel.add(lblBenutzername);
		}
		{
			JLabel lblBenutzername = new JLabel("Neue Bezeichnung:");
			lblBenutzername.setBounds(30, 50, 150, 30);
			contentPanel.add(lblBenutzername);
		}
		{
			JLabel lblNeuesPasswort = new JLabel("Neuer Leiter:");
			lblNeuesPasswort.setBounds(30, 80, 150, 30);
			contentPanel.add(lblNeuesPasswort);
		}
		{
			JLabel lblNeuesPasswort = new JLabel("Übergeordnete Einheit:");
			lblNeuesPasswort.setBounds(30, 110, 175, 30);
			contentPanel.add(lblNeuesPasswort);
		}
		{
			JLabel lblNeuesPasswort = new JLabel("Neuer Zustand:");
			lblNeuesPasswort.setBounds(30, 140, 175, 30);
			contentPanel.add(lblNeuesPasswort);
		}
		{
			comboBoxBezeichnung = new JComboBox<String>();
			comboBoxBezeichnung.setBounds(200, 20, 250, 26);
			contentPanel.add(comboBoxBezeichnung);
			List<ComOrgaEinheit> OrgaEinheitListe = port.getOrgaEinheiten(
					Benutzername, Passwort, false);
			List<String> OrgaEinheitListeString = new ArrayList<String>();
			for (ComOrgaEinheit Orga : OrgaEinheitListe) {
				OrgaEinheitListeString.add(Orga.getOrgaEinheitBez());
			}

			comboBoxBezeichnung.setModel(new ListComboBoxModel<String>(
					OrgaEinheitListeString));
			AutoCompleteDecorator.decorate(comboBoxBezeichnung);
			
			comboBoxBezeichnung.addActionListener(new ActionListener (){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					String orgaEinheit = (String) comboBoxBezeichnung
							.getSelectedItem();
					ComOrgaEinheit zuBearbeitendeOrgaEinheit = port
							.getOrgaEinheitZuName(Benutzername, Passwort,
									orgaEinheit);

					if (wurdeAusgewaehlt)
						contentPanel.remove(comboBoxUeberOrgaEinheit);
					String ueberOrgaEinheitTyp;
					if (zuBearbeitendeOrgaEinheit.getOrgaEinheitTyp().equals(
							"Gruppe"))
						ueberOrgaEinheitTyp = "Abteilung";
					else if (zuBearbeitendeOrgaEinheit.getOrgaEinheitTyp()
							.equals("Abteilung"))
						ueberOrgaEinheitTyp = "Zentralbereich";
					else
						ueberOrgaEinheitTyp = "";
					List<String> OrgaUeberEinheiten = port
							.getAlleOrgaEinheitenBezeichnungenVomTyp(
									Benutzername, Passwort, ueberOrgaEinheitTyp);
					comboBoxUeberOrgaEinheit = new JComboBox<String>();
					comboBoxUeberOrgaEinheit.setBounds(200, 110, 250, 26);
					comboBoxUeberOrgaEinheit
							.setModel(new ListComboBoxModel<String>(
									OrgaUeberEinheiten));
					AutoCompleteDecorator.decorate(comboBoxUeberOrgaEinheit);
					comboBoxUeberOrgaEinheit
							.setSelectedItem(zuBearbeitendeOrgaEinheit
									.getUeberOrgaEinheit());
					comboBoxUeberOrgaEinheit.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e) {
							ueberOrgaEinheitGeaendert = true;
						}
					});
					contentPanel.add(comboBoxUeberOrgaEinheit);

					txtneueBezeichnung.setEditable(true);
					comboBoxLeiter.setSelectedItem(zuBearbeitendeOrgaEinheit
							.getLeitername());
					comboBoxLeiter.setEditable(true);
					if (zuBearbeitendeOrgaEinheit.isZustand())
						comboBoxZustand.setSelectedItem("aktiv");
					else
						comboBoxZustand.setSelectedItem("inaktiv");
					wurdeAusgewaehlt = true;
					leiterGeaendert = false;
					ueberOrgaEinheitGeaendert = false;
					zustandGeaendert = false;
					contentPanel.updateUI();
					getRootPane().setDefaultButton(okButton);
				}
				
			});
		}
		{
			txtneueBezeichnung = new JTextField();
			txtneueBezeichnung.setBounds(200, 50, 250, 26);
			contentPanel.add(txtneueBezeichnung);
			txtneueBezeichnung.setColumns(10);
			txtneueBezeichnung.setEditable(false);
		}
		{
			List<String> alleBenutzerNamen = new ArrayList<String>();
			List<ComBenutzer> alleBenutzer = port.getBenutzer(Benutzername,
					Passwort);
			for (ComBenutzer benutzer : alleBenutzer) {
				alleBenutzerNamen.add(benutzer.getBenutzername());
			}
			comboBoxLeiter = new JComboBox<String>();
			comboBoxLeiter.setBounds(200, 80, 250, 26);
			contentPanel.add(comboBoxLeiter);
			comboBoxLeiter.setEditable(false);
			comboBoxLeiter.setModel(new ListComboBoxModel<String>(
					alleBenutzerNamen));
			AutoCompleteDecorator.decorate(comboBoxLeiter);
			comboBoxLeiter.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					leiterGeaendert = true;
				}
			});
		}
		{
			okButton = new JButton("\u00C4ndern");
			okButton.setBounds(235, 180, 100, 30);
			okButton.setBackground(Color.ORANGE);
			contentPanel.add(okButton);
			final BearbeitungOrgaEinheit fenster = this;
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String zuBerarbeitendeOrgaEinheit = (String) comboBoxBezeichnung
							 .getSelectedItem();
					String neueBezeichnung = txtneueBezeichnung.getText();
					if(!ueberOrgaEinheitGeaendert && !zustandGeaendert && !leiterGeaendert && neueBezeichnung.equals("")){
						Fehlermeldung fehler = new Fehlermeldung("Fehler!", "Sie haben keine Änderungen vorgenommen.");
						fehler.setVisible(true);
					}
					else if(port.gibtEsOrgaEinheitSchon(Benutzername, Passwort, neueBezeichnung)){
						Fehlermeldung fehler = new Fehlermeldung("Fehler!", "Die Bezeichnung für die Organisationseinheit ist schon vergeben.");
						fehler.setVisible(true);
					}
					else if(leiterGeaendert && port.istBenutzerSchonLeiter(Benutzername, Passwort, (String) comboBoxLeiter.getSelectedItem())){
						Fehlermeldung fehler = new Fehlermeldung("Fehler!", "Der gewünschte Leiter ist schon Leiter einer anderen Einheit.");
						fehler.setVisible(true);
					}
					else {
						String bezeichnungneu = null;
						String leiterneu = null;
						String ueberOrganeu = null;
						String zustand = (String) comboBoxZustand.getSelectedItem();
						boolean zustandneu = false;
						if(zustand.equals("aktiv"))zustandneu=true;
						if(!neueBezeichnung.equals("")){
							bezeichnungneu = neueBezeichnung;
						}
						if(leiterGeaendert){
							leiterneu = (String) comboBoxLeiter.getSelectedItem();
						}
						if(ueberOrgaEinheitGeaendert){
							ueberOrganeu = (String) comboBoxUeberOrgaEinheit.getSelectedItem();
						}
						BearbeitungOrgaEinheitFrage frage = new BearbeitungOrgaEinheitFrage(Benutzername, Passwort, port, fenster, zuBerarbeitendeOrgaEinheit, bezeichnungneu, leiterneu, ueberOrganeu, zustandneu, zustandGeaendert);
						frage.setVisible(true);
					}
					
				}
			});
			okButton.setActionCommand("OK");
		}
		{
			JButton cancelButton = new JButton("Abbrechen");
			cancelButton.setBackground(new Color(255, 255, 255));
			cancelButton.setBounds(350, 180, 100, 30);
			contentPanel.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
		}


		String[] zustand = { "aktiv", "inaktiv" };
		comboBoxZustand = new JComboBox<String>(zustand);
		comboBoxZustand.setBounds(200, 140, 250, 26);
		comboBoxZustand.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				zustandGeaendert = true;
			}
		});
		contentPanel.add(comboBoxZustand);
	}
}