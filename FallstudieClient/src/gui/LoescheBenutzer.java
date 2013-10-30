package gui;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import Webservice.Webservice;
@SuppressWarnings("serial")
public class LoescheBenutzer extends JDialog {
	
	private String Benutzername;
	private String Passwort;
	private Webservice port;
	
	private String loeschenBenutzer;
	private final JPanel contentPanel = new JPanel();
	private JComboBox<String> comboBoxBenutzername;
	/**
	 * Create the dialog.
	 */
	public LoescheBenutzer(String Benutzername, String Passwort,
			Webservice port) {
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.port = port;
		initialize();
	}
	@SuppressWarnings("unchecked")
	public void initialize(){
		setTitle("Benutzer - L\u00F6schen");
		setResizable(false);
		setBackground(new Color(255, 250, 240));
		setBounds(100, 100, 320, 130);
		setModal(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 250, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		//Erstellung der Combobox für die auswahl des Benutzers
		{
			comboBoxBenutzername = new JComboBox<String>();
			comboBoxBenutzername.setBounds(150, 19, 150, 26);
			contentPanel.add(comboBoxBenutzername);
			List<String> alleBenutzerNamen = new ArrayList<String>();
			List<ComBenutzer> alleBenutzer = port.getBenutzer(Benutzername,
					Passwort);
			for (ComBenutzer benutzer : alleBenutzer) {
				alleBenutzerNamen.add(benutzer.getBenutzername());
			}
			comboBoxBenutzername.setModel(new ListComboBoxModel<String>(
					alleBenutzerNamen));
			AutoCompleteDecorator.decorate(comboBoxBenutzername);
		}
		{
			JLabel lblBenutzername = new JLabel("Benutzername:");
			lblBenutzername.setBounds(30, 18, 150, 30);
			contentPanel.add(lblBenutzername);
		}
		{
			JButton okButton = new JButton("L\u00F6schen");
			okButton.setBackground(Color.ORANGE);
			okButton.setBounds(95, 60, 100, 30);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					loeschenBenutzer = (String) comboBoxBenutzername.getSelectedItem();
					if ( port.gibtesBenutzerschon(Benutzername, Passwort, loeschenBenutzer)){
					//Erstellung des LoescheBenutzerFrage-Fensters
					LoescheBenutzerFrage LoescheBenutzerFrage = new LoescheBenutzerFrage(Benutzername, Passwort, port, loeschenBenutzer);
					LoescheBenutzerFrage.setVisible(true);
					dispose();
					}
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Abbrechen");
			cancelButton.setBounds(205, 60, 100, 30);
			cancelButton.setBackground(Color.WHITE);
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