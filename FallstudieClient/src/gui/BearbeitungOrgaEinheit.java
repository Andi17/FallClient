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
import javax.swing.JComboBox;

import Webservice.Webservice;

@SuppressWarnings("serial")
public class BearbeitungOrgaEinheit extends JDialog {

	
	private String Benutzername;
	private String Passwort;
	private Webservice port;
	
	private int idOrgaEinheit;
	private String aktuellerOrgaEinheitName;
	private String neuerOrgaEinheitName;
	
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
	/**
	 * Create the dialog.
	 */
	public void initialize() {
		setTitle("Organisationseinheit - Deaktivieren");
		setResizable(false);
		setBackground(Color.WHITE);
		setBounds(100, 100, 700, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txtIdOrgaEinheit = new JTextField();
			txtIdOrgaEinheit.setBounds(231, 6, 134, 28);
			contentPanel.add(txtIdOrgaEinheit);
			txtIdOrgaEinheit.setColumns(10);
		}
		{
			JLabel lblOrganisationseinheit = new JLabel("Organisationseinheit:");
			lblOrganisationseinheit.setBounds(74, 12, 145, 16);
			contentPanel.add(lblOrganisationseinheit);
		}
		{
			JButton okButton = new JButton("Inaktiv setzen");
			okButton.setBounds(199, 123, 132, 29);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {			
					//TODO Aktion
					neuerOrgaEinheitName = txtNeuerOrgaEinheitName.getText();
					try {
						if (txtIdOrgaEinheit.getText().equals("")) {
							idOrgaEinheit = 0;
						} else {
							idOrgaEinheit = Integer.parseInt(txtIdOrgaEinheit.getText());
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
			cancelButton.setBounds(343, 123, 111, 29);
			contentPanel.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
		}
		{
			JComboBox comboBoxOrgaEinheit = new JComboBox();
			comboBoxOrgaEinheit.setBounds(377, 7, 77, 27);
			contentPanel.add(comboBoxOrgaEinheit);
		}
		
		txtNeuerOrgaEinheitName = new JTextField();
		txtNeuerOrgaEinheitName.setBounds(231, 83, 134, 28);
		contentPanel.add(txtNeuerOrgaEinheitName);
		txtNeuerOrgaEinheitName.setColumns(10);
		
		JLabel lblNeuerName = new JLabel("Neuer Name:");
		lblNeuerName.setBounds(74, 89, 95, 16);
		contentPanel.add(lblNeuerName);
		
		txtAktuellerOrgaEinheitName = new JTextField();
		txtAktuellerOrgaEinheitName.setBounds(231, 46, 134, 28);
		contentPanel.add(txtAktuellerOrgaEinheitName);
		txtAktuellerOrgaEinheitName.setColumns(10);
		
		JLabel lblAktuellerName = new JLabel("Aktueller Name:");
		lblAktuellerName.setBounds(74, 52, 111, 16);
		contentPanel.add(lblAktuellerName);
	}
}
