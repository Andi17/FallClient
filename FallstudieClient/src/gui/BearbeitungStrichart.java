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
import Webservice.ComStrichart;
import Webservice.Webservice;

@SuppressWarnings("serial")
public class BearbeitungStrichart extends JDialog {
	private String Benutzername;
	private String Passwort;
	private Webservice port;
	private final JPanel contentPanel = new JPanel();
	private JComboBox<String> txtStrichBez;
	private JTextField txtNeueStrichartBez;
	private String[] Combobezeichnung;
	private JComboBox<String> comboBoxZustand;
	private JButton okButton;

	/**
	 * Create the dialog.
	 */
	public BearbeitungStrichart(String Benutzername, String Passwort,
			Webservice port) {
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.port = port;
		initialize();
	}

	private void initialize() {
		setTitle("Strichart - Bearbeiten");
		setBackground(new Color(255, 250, 240));
		setResizable(false);
		setBounds(100, 100, 480, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 250, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblStrichart = new JLabel("Strichart:");
			lblStrichart.setBounds(30, 20, 150, 30);
			contentPanel.add(lblStrichart);
		}
		{
			JLabel lblBenutzername = new JLabel("Neue Bezeichnung:");
			lblBenutzername.setBounds(30, 50, 150, 30);
			contentPanel.add(lblBenutzername);
		}
		{
			JLabel lblBenutzername = new JLabel("Zustand:");
			lblBenutzername.setBounds(30, 80, 150, 30);
			contentPanel.add(lblBenutzername);
		}
		{
			txtStrichBez = new JComboBox<String>();
			txtStrichBez.setBounds(200, 20, 250, 26);
			contentPanel.add(txtStrichBez);
			// txtBenutzername.setColumns(1);
			List<String> alleStricharten = new ArrayList<String>();
			List<ComStrichart> alleStrichelArten = port.getStrichelArten(Benutzername,
					Passwort, false);
			for (ComStrichart strichart : alleStrichelArten) {
				alleStricharten.add(strichart.getStrichBez());
			}
			txtStrichBez.setModel(new ListComboBoxModel<String>(alleStricharten));
			AutoCompleteDecorator.decorate(txtStrichBez);
		}
		{
			txtNeueStrichartBez = new JTextField();
			txtNeueStrichartBez.setBounds(200, 50, 250, 26);
			contentPanel.add(txtNeueStrichartBez);
			txtNeueStrichartBez.setColumns(10);
		}
		{
			okButton = new JButton("\u00C4ndern");
			okButton.setBounds(240, 125, 100, 30);
			okButton.setBackground(Color.ORANGE);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String StrichBez = (String) txtStrichBez
							.getSelectedItem();
					String NeueStrichBez = txtNeueStrichartBez.getText();
					boolean zustand = true;
					if(comboBoxZustand.getSelectedItem().equals("gesperrt"))zustand=false;

					if (port.gibtesBenutzerschon(Benutzername, Passwort,
							NeueStrichBez)) {
						Fehlermeldung fehlermeldung = new Fehlermeldung(
								"Fehler!",
								"Der gewünschte Benutzername ist schon vergeben.");
						fehlermeldung.setVisible(true);
					} else {
						if ((NeueStrichBez.equals(""))) {
						} else {
							BearbeitungStrichartFrage BearbeitungStrichartFrage = new BearbeitungStrichartFrage(
									Benutzername, Passwort, port, StrichBez,
									NeueStrichBez, zustand);
							BearbeitungStrichartFrage.setVisible(true);
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
			cancelButton.setBounds(350, 125, 100, 30);
			contentPanel.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
		}

		String[] zustand = {"aktiv", "gesperrt"};
		comboBoxZustand = new JComboBox<String>(zustand);
		comboBoxZustand.setBounds(200, 80, 250, 26);
		contentPanel.add(comboBoxZustand);
	}
}