package guiBenutzerVerwaltung;

import gui.Fehlermeldung;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import Webservice.ComOrgaEinheit;
import Webservice.Webservice;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.combobox.ListComboBoxModel;

import tools.SonderzeichenTest;

@SuppressWarnings("serial")
public class NeuerBenutzer extends JDialog {
	
	private String Benutzername;
	private String Passwort;
	private Webservice port;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtBenutzername;
	private JPasswordField txtPasswort;
	private JPasswordField txtPasswort1;
	private JComboBox<String> comboBoxOrgaEinheit;
	private List<ComOrgaEinheit> OrgaEinheitListe;
	private List<String> OrgaEinheitListeString;

	public NeuerBenutzer(String Benutzername, String Passwort, Webservice port) {
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.port = port;
		this.OrgaEinheitListe = port.getOrgaEinheiten(Benutzername, Passwort, true);
		OrgaEinheitListeString = new ArrayList<String>();
		OrgaEinheitListeString.add("Keine Einheit");
		for (ComOrgaEinheit Orga : OrgaEinheitListe){
			//Alle Einheiten hinzufügen außer Zentralbereiche.
			if(Orga.getOrgaEinheitTyp().equals("Zentralbereich")){
			}
			else{
				OrgaEinheitListeString.add(Orga.getOrgaEinheitBez());
			}
		}
		initialize();
	}
	@SuppressWarnings("unchecked")
	private void initialize(){
		setTitle("Benutzer - Anlegen");
		setResizable(false);
		setBackground(Color.WHITE);
		setBounds(100, 100, 450, 230);
		setModal(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color (255, 250, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblBenutzername = new JLabel("Benutzername:");
			lblBenutzername.setBounds(30, 20, 150, 30);
			contentPanel.add(lblBenutzername);
		}
		{
			JLabel lblPasswort = new JLabel("Passwort:");
			lblPasswort.setBounds(30, 50, 150, 30);
			contentPanel.add(lblPasswort);
		}
		{
			JLabel lblPasswort = new JLabel("Passwort wiederholen:");
			lblPasswort.setBounds(30, 80, 150, 30);
			contentPanel.add(lblPasswort);
		}
		{
			JLabel lblOrgaEinheit = new JLabel("Organisationseinheit:");
			lblOrgaEinheit.setBounds(30, 110, 150, 30);
			contentPanel.add(lblOrgaEinheit);
		}
		{
			txtBenutzername = new JTextField();
			txtBenutzername.setBounds(175, 20, 250, 26);
			contentPanel.add(txtBenutzername);
			txtBenutzername.setColumns(10);
		}
		{
			txtPasswort = new JPasswordField();
			txtPasswort.setBounds(175, 50, 250, 26);
			contentPanel.add(txtPasswort);
			txtPasswort.setColumns(10);
		}
		{
			txtPasswort1 = new JPasswordField();
			txtPasswort1.setBounds(175, 80, 250, 26);
			contentPanel.add(txtPasswort1);
			txtPasswort1.setColumns(10);
		}
		{
			JButton okButton = new JButton("Best\u00E4tigen");
			okButton.setBounds(225, 160, 100, 30);
			okButton.setBackground(Color.ORANGE);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) {
					/*
					 * Plausibilitätsprüfungen (Sind Felder leer, gibt es Benutzer schon, Sonderzeichenprüfung)
					 */

					String neuerbenutzername = txtBenutzername.getText();
					String neuespasswort = txtPasswort.getText();
					String neuespasswort1 = txtPasswort1.getText();
					String orgaEinheit = "";
						orgaEinheit = (String) comboBoxOrgaEinheit.getSelectedItem();
					SonderzeichenTest sonderzeichen = new SonderzeichenTest();
						if (neuerbenutzername.equals("")){
							Fehlermeldung fehlermeldung = new Fehlermeldung(
									"Fehler!", "Sie müssen einen Benutzernamen eingeben.");
							fehlermeldung.setVisible(true);
						}
						else if (neuespasswort.equals("")){
							Fehlermeldung fehlermeldung = new Fehlermeldung(
									"Fehler!", "Sie müssen ein Passwort eingeben.");
							fehlermeldung.setVisible(true);
						}
						else if (neuespasswort1.equals("")){
							Fehlermeldung fehlermeldung = new Fehlermeldung(
									"Fehler!", "Sie müssen ein Passwort eingeben.");
							fehlermeldung.setVisible(true);
						}
						else if (false == neuespasswort.equals(neuespasswort1)){
							Fehlermeldung fehlermeldung = new Fehlermeldung(
									"Fehler!", "Die beiden Passwörter stimmen nicht überein.");
							fehlermeldung.setVisible(true);
						}
						else if (port.gibtesBenutzerschon(Benutzername, Passwort, neuerbenutzername)){
							txtBenutzername.setText("");
							txtPasswort.setText("");
							Fehlermeldung fehlermeldung = new Fehlermeldung(
									"Fehler!", "Der gewünschte Benutzername ist schon vergeben.");
							fehlermeldung.setVisible(true);
						}
						else if (sonderzeichen.test(neuerbenutzername)==true) {
							txtBenutzername.setText("");
							txtPasswort.setText("");
							Fehlermeldung fehlermeldung = new Fehlermeldung(
									"Fehler!",
									"Der Benutzername darf nur aus Buchstaben und Zahlen bestehen.");
							fehlermeldung.setVisible(true);
						} 
						else{
						// NeuerBenutzerFrage wird erstellt (Abfragefenster vor dem Anlegen)
						NeuerBenutzerFrage NeuerBenutzerFrage = new NeuerBenutzerFrage(Benutzername, Passwort, port, neuerbenutzername, neuespasswort, orgaEinheit);
						NeuerBenutzerFrage.setVisible(true);
						dispose();
						}
					
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Abbrechen");
			cancelButton.setBounds(330, 160, 100, 30);
			cancelButton.setBackground(Color.WHITE);
			contentPanel.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
		}
		
		
		comboBoxOrgaEinheit = new JComboBox<String>();
		comboBoxOrgaEinheit.setModel(new ListComboBoxModel<String>(
					OrgaEinheitListeString));
		AutoCompleteDecorator.decorate(comboBoxOrgaEinheit);
		comboBoxOrgaEinheit.setBounds(175, 110, 250, 26);
		contentPanel.add(comboBoxOrgaEinheit);
	
	}

}
