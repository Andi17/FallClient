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

import Webservice.ComOrgaEinheit;
import Webservice.Webservice;

@SuppressWarnings("serial")
public class BearbeitungOrgaEinheit extends JDialog {

	private String Benutzername;
	private String Passwort;
	private Webservice port;

	private String neuerOrgaEinheitName;
	private List<ComOrgaEinheit> OrgaEinheitListe;
	private JComboBox<?> comboBoxOrgaEinheit;
	private String[] CoboBezeichnungOrgaEinheit;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdOrgaEinheit;
	private JTextField txtNeuerOrgaEinheitName;
	private JTextField txtAktuellerOrgaEinheitName;

	public BearbeitungOrgaEinheit(String Benutzername, String Passwort,
			Webservice port) {
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.port = port;
		initialize();
	}

	public void initialize() {
		setTitle("Organisationseinheit - Deaktivieren");
		setResizable(false);
		setBackground(Color.WHITE);
		setBounds(100, 100, 600, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 250, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txtIdOrgaEinheit = new JTextField();
			txtIdOrgaEinheit.setBounds(207, 12, 134, 28);
			contentPanel.add(txtIdOrgaEinheit);
			txtIdOrgaEinheit.setColumns(10);
		}
		{
			JLabel lblOrganisationseinheit = new JLabel("Organisationseinheit:");
			lblOrganisationseinheit.setBounds(10, 18, 145, 16);
			contentPanel.add(lblOrganisationseinheit);
		}
		{
			JButton okButton = new JButton("\u00C4ndern");
			okButton.setBackground(Color.ORANGE);
			okButton.setBounds(303, 219, 132, 29);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					neuerOrgaEinheitName = txtNeuerOrgaEinheitName.getText();
					try {
						if (txtIdOrgaEinheit.getText().equals("")) {
						} else {
							Integer.parseInt(txtIdOrgaEinheit.getText());
						}
						if (false == port.gibtEsOrgaEinheitSchon(Benutzername,
								Passwort, neuerOrgaEinheitName)) {

						} else {

						}
					} catch (NumberFormatException a) {

					}
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Abbrechen");
			cancelButton.setBackground(Color.WHITE);
			cancelButton.setBounds(458, 219, 111, 29);
			contentPanel.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
		}

		txtNeuerOrgaEinheitName = new JTextField();
		txtNeuerOrgaEinheitName.setBounds(207, 88, 134, 28);
		contentPanel.add(txtNeuerOrgaEinheitName);
		txtNeuerOrgaEinheitName.setColumns(10);

		JLabel lblNeuerName = new JLabel("Neuer Name:");
		lblNeuerName.setBounds(10, 94, 95, 16);
		contentPanel.add(lblNeuerName);
		{
			txtAktuellerOrgaEinheitName = new JTextField();
			txtAktuellerOrgaEinheitName.setBounds(207, 51, 134, 28);
			contentPanel.add(txtAktuellerOrgaEinheitName);
			txtAktuellerOrgaEinheitName.setColumns(10);
		}
		{
			OrgaEinheitListe = port.getOrgaEinheiten(Benutzername, Passwort,
					true);
			CoboBezeichnungOrgaEinheit = new String[OrgaEinheitListe.size()];
			int zaehler2 = 0;
			for (ComOrgaEinheit Orga : OrgaEinheitListe) {
				CoboBezeichnungOrgaEinheit[zaehler2] = Orga.getOrgaEinheitBez();
				zaehler2++;
			}
			comboBoxOrgaEinheit = new JComboBox<Object>(
					CoboBezeichnungOrgaEinheit);
			comboBoxOrgaEinheit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent c) {
					txtAktuellerOrgaEinheitName.setText(""
							+ OrgaEinheitListe.get(
									comboBoxOrgaEinheit.getSelectedIndex())
									.getIdOrgaEinheit());
				}
			});
			comboBoxOrgaEinheit.setBounds(351, 52, 142, 26);
			contentPanel.add(comboBoxOrgaEinheit);
		}
		JLabel lblAktuellerName = new JLabel("Aktueller Name:");
		lblAktuellerName.setBounds(10, 57, 111, 16);
		contentPanel.add(lblAktuellerName);
	}
}
