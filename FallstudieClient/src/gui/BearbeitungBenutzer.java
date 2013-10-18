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
import java.util.List;

import javax.swing.JComboBox;

import Webservice.ComBenutzer;
import Webservice.ComOrgaEinheit;
import Webservice.Webservice;

@SuppressWarnings("serial")
public class BearbeitungBenutzer extends JDialog {
	private String Benutzername;
	private String Passwort;
	private Webservice port;
	private int idOrgaEinheit;
	private String benutzername;
	private String neuerBenutzername;
	private String passwort;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtPasswort;
	private JTextField txtBenutzername;
	private JTextField txtneuerBenutzername;
	private JTextField txtOrgaEinheit;
	private JComboBox<?> comboBoxBenutzername;
	private String[] Combobezeichnung;
	private JComboBox<?> comboBoxOrgaEinheit;
	private String[] CoboBezeichnungOrgaEinheit;
	private List<ComOrgaEinheit> OrgaEinheitListe;

	/**
	 * Create the dialog.
	 */
	public BearbeitungBenutzer(String Benutzername, String Passwort, Webservice port) {
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.port = port;
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
			txtBenutzername = new JTextField();
			txtBenutzername.setBounds(200, 20, 142, 26);
			contentPanel.add(txtBenutzername);
			txtBenutzername.setColumns(1);
		}
		{
			txtneuerBenutzername = new JTextField();
			txtneuerBenutzername.setBounds(200, 50, 142, 26);
			contentPanel.add(txtneuerBenutzername);
			txtneuerBenutzername.setColumns(10);
		}
		{
			txtPasswort = new JTextField();
			txtPasswort.setBounds(200, 80, 142, 26);
			contentPanel.add(txtPasswort);
			txtPasswort.setColumns(10);
		}
		{
			txtOrgaEinheit = new JTextField();
			txtOrgaEinheit.setBounds(200, 110, 142, 26);
			contentPanel.add(txtOrgaEinheit);
			txtOrgaEinheit.setColumns(1);
		}
		{
			JButton okButton = new JButton("\u00C4ndern");
			okButton.setBackground(new Color(255, 255, 255));
			okButton.setBounds(280, 162, 100, 30);
			okButton.setBackground(Color.ORANGE);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					benutzername = txtBenutzername.getText();
					passwort = txtPasswort.getText();
					neuerBenutzername = txtneuerBenutzername.getText();
					try {
						if (txtOrgaEinheit.getText().equals("")) {
							idOrgaEinheit = 0;
						} else {
							idOrgaEinheit = Integer.parseInt(txtOrgaEinheit
									.getText());
						}
						if (false == port.gibtesBenutzerschon(Benutzername,	Passwort, benutzername)) {
							txtBenutzername.setText("");
							txtPasswort.setText("");
						} else {
							if (false == port.gibtesBenutzerschon(Benutzername,	Passwort, neuerBenutzername)) {
								if ((txtneuerBenutzername.getText().equals(""))	&& (txtPasswort.getText().equals("")) && (txtOrgaEinheit.getText().equals(""))) {
								} else {
									BearbeitungBenutzerFrage BearbeitungBenutzerFrage = new BearbeitungBenutzerFrage(Benutzername, Passwort, port,benutzername, passwort,neuerBenutzername, idOrgaEinheit);
									BearbeitungBenutzerFrage.setVisible(true);
									dispose();
								}
							} else {
								txtneuerBenutzername.setText("");
							}
						}
					} catch (NumberFormatException a) {
						if (!port.gibtesBenutzerschon(Benutzername, Passwort,benutzername)) {
							txtBenutzername.setText("");
							txtPasswort.setText("");
						}
						txtOrgaEinheit.setText("");
					}
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
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
		List<ComBenutzer> BenutzerListe = port.getBenutzer(Benutzername,Passwort);
		Combobezeichnung = new String[BenutzerListe.size()];
		int zaehler = 0;
		for (ComBenutzer Ben : BenutzerListe) {
			Combobezeichnung[zaehler] = Ben.getBenutzername();
			zaehler++;
		}
		comboBoxBenutzername = new JComboBox<Object>(Combobezeichnung);
		comboBoxBenutzername.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtBenutzername.setText(Combobezeichnung[comboBoxBenutzername.getSelectedIndex()]);
			}
		});
		comboBoxBenutzername.setBounds(350, 20, 142, 26);
		contentPanel.add(comboBoxBenutzername);
		OrgaEinheitListe = port.getOrgaEinheiten(Benutzername, Passwort, true);
		CoboBezeichnungOrgaEinheit = new String[OrgaEinheitListe.size()];
		int zaehler2 = 0;
		for (ComOrgaEinheit Orga : OrgaEinheitListe) {
			CoboBezeichnungOrgaEinheit[zaehler2] = Orga.getOrgaEinheitBez();
			zaehler2++;
		}
		comboBoxOrgaEinheit = new JComboBox<Object>(CoboBezeichnungOrgaEinheit);
		comboBoxOrgaEinheit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {
				txtOrgaEinheit.setText("" + OrgaEinheitListe.get(comboBoxOrgaEinheit.getSelectedIndex()).getIdOrgaEinheit());
			}
		});
		comboBoxOrgaEinheit.setBounds(350, 110, 142, 26);
		contentPanel.add(comboBoxOrgaEinheit);
	}
}